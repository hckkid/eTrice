/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DetailCodeTranslator {

	public static interface ITranslationProvider {
		String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args);
		String getAttributeText(Attribute att);
		String getOperationText(Operation op, ArrayList<String> args);
	}

	private ActorClass ac;
	private ITranslationProvider provider;
	private HashMap<String, InterfaceItem> name2item;
	private HashMap<String, Attribute> name2attr;
	private HashMap<String, Operation> name2op;
	private int curr;
	
	public DetailCodeTranslator(ActorClass ac, ITranslationProvider provider) {
		this.ac = ac;
		this.provider = provider;
		
		prepare();
	}
	
	public String translateDetailCode(DetailCode code) {
		if (code==null)
			return null;
		
		// concatenate lines
		StringBuilder text = new StringBuilder();
		for (String line : code.getCommands()) {
			text.append(line+"\n");
		}

		StringBuilder result = new StringBuilder();
		translateText(text.substring(0, text.length()-1), result);
		
		return result.toString();
	}
	
	private void translateText(String text, StringBuilder result) {
		curr = 0;
		int last = 0;
		
		while (curr<text.length()) {
			proceedToToken(text);
			
			last = appendParsed(text, last, result);
			
			String token = getToken(text);
			if (token.isEmpty()) {
				while (curr<text.length() && !Character.isWhitespace(text.charAt(curr)))
					++curr;
				last = appendParsed(text, last, result);
			}
			else {
				// translate token if possible
				String translated = null;
				Attribute attribute = name2attr.get(token);
				if (attribute!=null) {
					translated = provider.getAttributeText(attribute);
				}
				else {
					Operation operation = name2op.get(token);
					if (operation!=null) {
						ArrayList<String> args = getArgs(text);
						if (args!=null && operation.getArguments().size()==args.size()) {
							// TODO: recursively apply this algorithm to each argument (needs curr to be wrapped in object and passed as param)
							translated = provider.getOperationText(operation, args);
						}
					}
					else {
						InterfaceItem item = name2item.get(token);
						if (item!=null) {
							Message msg = getMessage(text, item);
							ArrayList<String> args = getArgs(text);
							if (msg!=null && args!=null && argsMatching(msg, args)) {
								translated = provider.getInterfaceItemMessageText(item, msg, args);
							}
						}
					}
				}
				if (translated!=null) {
					last = curr;
					result.append(translated);
				}
				else
					last = appendParsed(text, last, result);
			}
		}
	}

	/**
	 * @param text
	 * @param result
	 * @return 
	 */
	private int appendParsed(String text, int last, StringBuilder result) {
		String str = text.substring(last, curr);
		result.append(str);
		return curr;
	}

	private boolean argsMatching(Message msg, ArrayList<String> args) {
		if (msg.getData()==null && args.isEmpty())
			return true;
		if (msg.getData()!=null && args.size()==1)
			return true;
		
		return false;
	}

	private void proceedToToken(String text) {
		boolean stop = false;
		while (curr<text.length() && !stop) {
			if (text.charAt(curr)=='"') {
				skipString(text);
			}
			else if (text.charAt(curr)=='/') {
				if (curr+1<text.length()) {
					if (text.charAt(curr+1)=='/') {
						skipSingleComment(text);
					}
					else if (text.charAt(curr+1)=='*') {
						skipMultiComment(text);
					}
				}
			}
			else if (Character.isWhitespace(text.charAt(curr))) {
				skipWhiteSpace(text);
			}
			else
				stop = true;
		}
	}
	
	private Message getMessage(String text, InterfaceItem item) {
		proceedToToken(text);

		if (text.charAt(curr)!='.')
			return null;
		++curr;
		
		proceedToToken(text);
		
		String token = getToken(text);
		
		List<Message> messages = null;
		if (item instanceof Port) {
			if (((Port) item).isConjugated())
				messages = ((Port) item).getProtocol().getIncomingMessages();
			else
				messages = ((Port) item).getProtocol().getOutgoingMessages();
		}
		else if (item instanceof SAPRef) {
			messages = ((SAPRef)item).getProtocol().getIncomingMessages();
		}
		else if (item instanceof SPPRef) {
			messages = ((SPPRef)item).getProtocol().getOutgoingMessages();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		for (Message message : messages) {
			if (message.getName().equals(token))
				return message;
		}
		
		return null;
	}
	
	private ArrayList<String> getArgs(String text) {
		proceedToToken(text);

		if (text.charAt(curr)!='(')
			return null;
		++curr;
		
		ArrayList<String> result = new ArrayList<String>();
		
		boolean stop = false;
		do {
			proceedToToken(text);
			if (text.charAt(curr)!=')') {
				String arg = getParam(text);
				result.add(arg);
				proceedToToken(text);
			}
			if (text.charAt(curr)==',')
				++curr;
			else
				stop = true;
		}
		while (!stop);

		if (text.charAt(curr)!=')')
			return null;
		
		++curr;
		
		return result;
	}

	private String getToken(String text) {
		int begin = curr;
		while (curr<text.length() && isTokenChar(text.charAt(curr)))
			++curr;
		String token = text.substring(begin, curr);
		return token;
	}

	private String getParam(String text) {
		int begin = curr;
		int parenthesisLevel = 0;
		while (curr<text.length()) {
			if (text.charAt(curr)=='(')
				++parenthesisLevel;
			else if (text.charAt(curr)==')') {
				if (parenthesisLevel==0)
					break;
				else
					--parenthesisLevel;
			}
			else if (parenthesisLevel==0) {
				if (text.charAt(curr)==',')
					break;
			}
			++curr;
		}
		String token = text.substring(begin, curr).trim();
		return token;
	}

	private void skipWhiteSpace(String text) {
		while (curr<text.length() && Character.isWhitespace(text.charAt(curr)))
			++curr;
	}

	private void skipMultiComment(String text) {
		curr += 2;
		while (curr<text.length()-1 && text.charAt(curr++)!='*')
			if (text.charAt(curr)=='/')
				break;
		++curr;
	}

	private void skipSingleComment(String text) {
		while (curr<text.length() && text.charAt(curr)!='\n')
			++curr;
		++curr;
	}

	private void skipString(String text) {
		while (++curr<text.length() && text.charAt(curr)!='"')
			if (text.charAt(curr)=='\\')
				++curr;
	}

	private boolean isTokenChar(char c) {
		return Character.isDigit(c) || Character.isLetter(c) || c=='_';
	}

	private void prepare() {
		name2item = new HashMap<String, InterfaceItem>();
		List<InterfaceItem> items = RoomHelpers.getAllInterfaceItems(ac);
		for (InterfaceItem item : items) {
			name2item.put(item.getName(), item);
		}

		name2attr = new HashMap<String, Attribute>();
		List<Attribute> attributes = RoomHelpers.getAllAttributes(ac);
		for (Attribute attribute : attributes) {
			name2attr.put(attribute.getName(), attribute);
		}
		
		name2op = new HashMap<String, Operation>();
		List<Operation> operations = RoomHelpers.getAllOperations(ac);
		for (Operation operation : operations) {
			name2op.put(operation.getName(), operation);
		}
	}
}

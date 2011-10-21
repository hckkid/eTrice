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

package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.dialogs.PortMessageSelectionDialog.MsgItemPair;
import org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractMemberAwarePropertyDialog extends AbstractPropertyDialog {
	
	final class LastTextListener implements FocusListener {
		private final Text text;

		LastTextListener(Text text) {
			this.text = text;
		}

		@Override
		public void focusGained(FocusEvent e) {
			lastTextField = text;
			members.setEnabled(true);
			messages.setEnabled(true);
		}

		@Override
		public void focusLost(FocusEvent e) {
		}
	}

	private Text lastTextField = null;
	private Button members;
	private Button messages;
	private ActorClass ac;

	/**
	 * @param shell
	 * @param title
	 * @param ac
	 */
	public AbstractMemberAwarePropertyDialog(Shell shell, String title, ActorClass ac) {
		super(shell, title);
		this.ac = ac;
	}

	/**
	 * @return the ac
	 */
	public ActorClass getActorClass() {
		return ac;
	}

	/**
	 * @param body
	 */
	protected void createMembersAndMessagesButtons(Composite body) {
		Composite buttonsArea = getToolkit().createComposite(body);
		buttonsArea.setLayout(new GridLayout(2, true));
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.horizontalSpan = 2;
		buttonsArea.setLayoutData(gd);
		
		members = new Button(buttonsArea, SWT.PUSH);
		members.setText("Mem&bers");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		members.setLayoutData(gd);
		members.setEnabled(false);
		members.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleMembersPressed();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleMembersPressed();
			}
		});
		
		messages = new Button(buttonsArea, SWT.PUSH);
		messages.setText("Me&ssages");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		messages.setLayoutData(gd);
		messages.setEnabled(false);
		messages.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleMessagesPressed();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleMessagesPressed();
			}
		});
	}

	protected void handleMembersPressed() {
		MemberSelectionDialog dlg = new MemberSelectionDialog(getShell(), ac);
		if (dlg.open()==Window.OK) {
			Object selected = dlg.getSelected();
			if (selected instanceof Attribute)
				insertText(((Attribute)selected).getName());
			else if (selected instanceof Operation)
				insertText(((Operation)selected).getName()+RoomHelpers.getSignature((Operation) selected));
		}
	}

	protected void handleMessagesPressed() {
		PortMessageSelectionDialog dlg = new PortMessageSelectionDialog(getShell(), ac);
		if (dlg.open()==Window.OK) {
			if (dlg.getMsgItemPair()!=null) {
				MsgItemPair pair = dlg.getMsgItemPair();
				if (pair.out) {
					String data = pair.msg.getData()!=null? pair.msg.getData().getName() : "";
					insertText(pair.item.getName()+"."+pair.msg.getName()+"("+data+")");
				}
				else
					insertText(pair.item.getName()+"."+pair.msg.getName());
			}
		}
	}

	private void insertText(String txt) {
		if (lastTextField!=null) {
			int begin = txt.indexOf('(');
			int end = txt.indexOf(')');
			int offset = lastTextField.getSelection().x;
			lastTextField.insert(txt);
			if (begin>=0 && end>=0 && end>begin+1)
				lastTextField.setSelection(offset+begin+1, offset+end);
			lastTextField.setFocus();
		}
	}

}

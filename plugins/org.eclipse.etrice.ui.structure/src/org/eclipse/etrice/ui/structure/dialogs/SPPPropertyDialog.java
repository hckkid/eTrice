/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.dialogs;

import java.util.ArrayList;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPPRef;

public class SPPPropertyDialog extends AbstractPropertyDialog {

	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				if (name.isEmpty())
					return ValidationStatus.error("name must not be empty");
				
				// TODOHRR: check valid identifier
				// TODOHRR: use ValidationUtil
				
				if (nameExists(acc, name))
					return ValidationStatus.error("name already exists");

				return Status.OK_STATUS;
			}
			return Status.OK_STATUS;
		}

		private boolean nameExists(ActorContainerClass ac, String name) {
			for (SPPRef s : ac.getIfSPPs()) {
				if (s!=spp && s.getName().equals(name))
					return true;
			}

			if (ac instanceof ActorClass)
				if (((ActorClass)ac).getBase()!=null)
					return nameExists(((ActorClass)ac).getBase(), name);
			
			return false;
		}
	}
	
	class ProtocolValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value==null)
				return ValidationStatus.error("select a protocol");
			
			return Status.OK_STATUS;
		}
	}
	
	private SPPRef spp;
	private ActorContainerClass acc;
	private boolean newSPP;
	private boolean refitem;

	public SPPPropertyDialog(Shell shell, SPPRef spp, ActorContainerClass acc, boolean newSPP, boolean refitem) {
		super(shell, "Edit SPP");
		this.spp = spp;
		this.acc = acc;
		this.newSPP = newSPP;
		this.refitem = refitem;
	}

	@Override
	protected void initializeBounds() {
		getShell().setSize(300, 300);
	}
	
	@Override
	protected void createContent(IManagedForm mform, Composite body, DataBindingContext bindingContext) {
		boolean connected = ValidationUtil.isConnectedSrc(spp, acc);
		NameValidator nv = new NameValidator();
		ProtocolValidator pv = new ProtocolValidator();

		ArrayList<ProtocolClass> protocols = new ArrayList<ProtocolClass>();
		if (acc.eResource()!=null) {
			for (Resource r: acc.eResource().getResourceSet().getResources()) {
				if (!r.getContents().isEmpty()) {
					if (r.getContents().get(0) instanceof RoomModel) {
						protocols.addAll(((RoomModel)r.getContents().get(0)).getProtocolClasses());
					}
				}
			}
		}
		
		Text name = createText(body, "Name:", spp, RoomPackage.eINSTANCE.getInterfaceItem_Name(), nv);
		Combo protocol = createCombo(body, "Protocol:", spp, ProtocolClass.class, RoomPackage.eINSTANCE.getInterfaceItem_Protocol(), protocols, RoomPackage.eINSTANCE.getRoomClass_Name(), pv);
		
		if (!newSPP) {
			// TODOHRR: check whether spp is used externally?
			if (connected) {
				protocol.setEnabled(false);
			}
			if (refitem) {
				name.setEnabled(false);
				protocol.setEnabled(false);
			}
		}
		
		createDecorator(name, "invalid name");
		createDecorator(protocol, "no protocol selected");
		
		name.setFocus();
	}
}

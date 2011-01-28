/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class TrPointPropertyDialog extends AbstractPropertyDialog {
	
	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				if (name.isEmpty())
					return ValidationStatus.error("name must not be empty");

				for (TrPoint t : sg.getTrPoints()) {
					if (t!=tp && t.getName()!=null && t.getName().equals(name))
						return ValidationStatus.error("name already used");
				}
			}
			return Status.OK_STATUS;
		}
	}

	private StateGraph sg;
	private TrPoint tp;

	public TrPointPropertyDialog(Shell shell, TrPoint tp, StateGraph sg,
			boolean subtp) {
		super(shell, "Edit Transition Point");
		this.sg = sg;
		this.tp = tp;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {

		NameValidator nv = new NameValidator();
		
		Text name = createText(body, "&Name:", tp, RoomPackage.eINSTANCE.getTrPoint_Name(), nv);
		
		if (tp instanceof TransitionPoint) {
			createCheck(body, "Is &Handler:", tp, RoomPackage.eINSTANCE.getTransitionPoint_Handler());
		}
		
		createDecorator(name, "invalid name");
		
		name.setFocus();
	}

}

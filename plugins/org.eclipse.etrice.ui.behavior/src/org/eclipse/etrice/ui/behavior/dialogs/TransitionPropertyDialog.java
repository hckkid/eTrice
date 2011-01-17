package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class TransitionPropertyDialog extends AbstractPropertyDialog {
	
	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				if (name.isEmpty())
					return ValidationStatus.error("name must not be empty");

				for (Transition t : sg.getTransitions()) {
					if (t!=trans && t.getName()!=null && t.getName().equals(name))
						return ValidationStatus.error("name already used");
				}
			}
			return Status.OK_STATUS;
		}
	}
	
	private Transition trans;
	private StateGraph sg;

	public TransitionPropertyDialog(Shell shell, StateGraph sg, Transition trans) {
		super(shell, "Edit Transition");
		this.sg = sg;
		this.trans = trans;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {
		
		boolean initTrans = (trans instanceof InitialTransition);
		
		if (!initTrans) {
			NameValidator nv = new NameValidator();
			
			Text name = createText(body, "Name:", trans, RoomPackage.eINSTANCE.getTransition_Name(), nv);
			
			createDecorator(name, "invalid name");
			
			name.setFocus();
		}
		
		DetailCodeToString m2s = new DetailCodeToString();
		StringToDetailCode s2m = new StringToDetailCode();
		Text action = createText(body, "Action Code:", trans, RoomPackage.eINSTANCE.getTransition_Action(), null, s2m, m2s, true);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 100;
		action.setLayoutData(gd);
	}

}

package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class TransitionPropertyDialog extends AbstractPropertyDialog {
	
	private class TriggerContentProvider implements IStructuredContentProvider {
		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getElements(Object inputElement) {
			if (trans instanceof TriggeredTransition) {
				return ((TriggeredTransition) trans).getTriggers().toArray();
			}
			return new Object[] {};
		}

	}

	private class TriggerLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof Trigger) {
				Trigger trig = (Trigger) element;
				return RoomNameProvider.getTriggerLabel(trig);
			}
			return super.getText(element);
		}
	}

	private class MessageFromInterfaceContentProvider implements IStructuredContentProvider {
		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Trigger) {
				return ((Trigger) inputElement).getMsgFromIfPairs().toArray();
			}
			return new Object[] {};
		}

	}

	private class MessageFromInterfaceLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof MessageFromIf) {
				MessageFromIf mif = (MessageFromIf) element;
				return RoomNameProvider.getMsgFromIfLabel(mif);
			}
			return super.getText(element);
		}
	}

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
	private Combo messageCombo;
	private Combo interfaceCombo;
	private TableViewer mifViewer;
	private ActorClass ac;
	private List<InterfaceItem> interfaceItems = new ArrayList<InterfaceItem>();
	private TableViewer triggerViewer;
	private EList<Message> currentMsgs;

	public TransitionPropertyDialog(Shell shell, StateGraph sg, Transition trans) {
		super(shell, "Edit Transition");
		this.sg = sg;
		this.trans = trans;
		this.ac = getActorClass(sg);
		
		collectInterfaceItems();
	}

	private void collectInterfaceItems() {
		interfaceItems.addAll(ac.getIntPorts());
		for (ExternalPort p : ac.getExtPorts()) {
			interfaceItems.add(p.getIfport());
		}
		interfaceItems.addAll(ac.getStrSAPs());
		for (ServiceImplementation svc : ac.getServiceImplementations()) {
			interfaceItems.add(svc.getSpp());
		}
	}

	private ActorClass getActorClass(StateGraph sg2) {
		EObject obj = sg;
		while (obj!=null) {
			if (obj instanceof ActorClass) {
				return (ActorClass) obj;
				
			}
			obj = obj.eContainer();
		}
		return null;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {
		
		if (!(trans instanceof InitialTransition)) {
			NameValidator nv = new NameValidator();
			
			Text name = createText(body, "Name:", trans, RoomPackage.eINSTANCE.getTransition_Name(), nv);
			
			createDecorator(name, "invalid name");
			
			name.setFocus();
		}
		
		if (trans instanceof TriggeredTransition) {
			FormToolkit toolkit = mform.getToolkit();

			initIfEmpty();

			Label l = toolkit.createLabel(body, "Triggers:", SWT.NONE);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			l.setLayoutData(gd);

			Composite triggerCompartment = toolkit.createComposite(body);
			triggerCompartment.setLayout(new GridLayout(3, false));
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			triggerCompartment.setLayoutData(gd);
			
			triggerViewer = createTriggerTable(triggerCompartment, toolkit);
			mifViewer = createMifTable(triggerCompartment, toolkit);
			
			createInterfaceCombo(triggerCompartment, toolkit);
			createMessageCombo(toolkit, triggerCompartment);

			addListeners();
			
			triggerViewer.setSelection(new StructuredSelection(((TriggeredTransition) trans).getTriggers().get(0)), true);
			
//			IObservableValue tableObs = ViewerProperties.singleSelection().observe(triggers);
//			IWidgetValueProperty comboProp = WidgetProperties.selection();
//			bindingContext.bindValue(
//					comboProp.observe(comboContext),
//					prop.observeDetail(tableObs)
//				);
		}

		DetailCodeToString m2s = new DetailCodeToString();
		StringToDetailCode s2m = new StringToDetailCode();

		if (trans instanceof CPBranchTransition) {
			Text cond = createText(body, "Condition:", trans, RoomPackage.eINSTANCE.getCPBranchTransition_Condition(), null, s2m, m2s, true);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.heightHint = 100;
			cond.setLayoutData(gd);
		}
		
		{
			Text action = createText(body, "Action Code:", trans, RoomPackage.eINSTANCE.getTransition_Action(), null, s2m, m2s, true);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.heightHint = 100;
			action.setLayoutData(gd);
		}
	}

	private void addListeners() {
		triggerViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
					mifViewer.setInput(firstElement);
					if (firstElement instanceof Trigger)
						mifViewer.setSelection(new StructuredSelection(((Trigger)firstElement).getMsgFromIfPairs().get(0)), true);
				}
			}
		});

		mifViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateCombos();
			}
		});
		
		interfaceCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateInterfaceItem();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		messageCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateMessage();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}

	private void createMessageCombo(FormToolkit toolkit,
			Composite triggerCompartment) {
		messageCombo = new Combo(triggerCompartment, SWT.READ_ONLY);
		messageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		messageCombo.setVisibleItemCount(10);
		toolkit.adapt(messageCombo, true, true);
	}

	protected void updateMessage() {
		String msgName = messageCombo.getItem(messageCombo.getSelectionIndex());
		for (Message message : currentMsgs) {
			if (msgName.equals(message.getName())) {
				MessageFromIf mif = (MessageFromIf) ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
				mif.setMessage(message);
				break;
			}
		}
		
		triggerViewer.refresh();
		mifViewer.refresh();
	}

	protected void updateInterfaceItem() {
		String ifName = interfaceCombo.getItem(interfaceCombo.getSelectionIndex());
		for (InterfaceItem item : interfaceItems) {
			if (item.getName().equals(ifName)) {
				MessageFromIf mif = (MessageFromIf) ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
				mif.setFrom(item);
				updateCombos();
				break;
			}
		}
		
		triggerViewer.refresh();
		mifViewer.refresh();
	}

	private void createInterfaceCombo(Composite triggerCompartment,
			FormToolkit toolkit) {
		interfaceCombo = new Combo(triggerCompartment, SWT.READ_ONLY);
		interfaceCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		interfaceCombo.setVisibleItemCount(10);
		toolkit.adapt(interfaceCombo, true, true);
		
		for (InterfaceItem item : interfaceItems) {
			interfaceCombo.add(item.getName());
		}
	}

	protected void updateCombos() {
		messageCombo.removeAll();
		
		if (mifViewer.getSelection() instanceof IStructuredSelection) {
			Object sel = ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
			if (sel instanceof MessageFromIf) {
				MessageFromIf mif = (MessageFromIf) sel;
				String[] items = interfaceCombo.getItems();
				for (int i = 0; i < items.length; i++) {
					if (items[i].equals(mif.getFrom().getName())) {
						interfaceCombo.select(i);
						boolean regular = true;
						if (mif.getFrom() instanceof Port) {
							if (((Port)mif.getFrom()).isConjugated())
								regular = false;
						}
						else if (mif.getFrom() instanceof SPPRef)
							regular = false;
						currentMsgs = regular? mif.getFrom().getProtocol().getIncomingMessages()
								: mif.getFrom().getProtocol().getOutgoingMessages();
						int pos = 0;
						int idx = 0;
						for (Message message : currentMsgs) {
							messageCombo.add(message.getName());
							if (message==mif.getMessage())
								idx = pos;
							++pos;
						}
						messageCombo.select(idx);
						break;
					}
				}
			}
		}
	}

	private TableViewer createMifTable(Composite triggerCompartment,
			FormToolkit toolkit) {
		GridData gd;
		Table mifTable = toolkit.createTable(triggerCompartment, SWT.NONE | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 100;
		gd.verticalSpan = 2;
		mifTable.setLayoutData(gd);
		final TableViewer mifViewer = new TableViewer(mifTable);
		mifViewer.setContentProvider(new MessageFromInterfaceContentProvider());
		mifViewer.setLabelProvider(new MessageFromInterfaceLabelProvider());
		return mifViewer;
	}

	private TableViewer createTriggerTable(Composite body, FormToolkit toolkit) {
		Table triggerTable = toolkit.createTable(body, SWT.NONE | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 100;
		gd.verticalSpan = 2;
		triggerTable.setLayoutData(gd);
		TableViewer triggerViewer = new TableViewer(triggerTable);
		triggerViewer.setContentProvider(new TriggerContentProvider());
		triggerViewer.setLabelProvider(new TriggerLabelProvider());
		triggerViewer.setInput(trans);
		return triggerViewer;
	}

	private void initIfEmpty() {
		if (((TriggeredTransition) trans).getTriggers().isEmpty()) {
			Trigger tri = RoomFactory.eINSTANCE.createTrigger();
			((TriggeredTransition) trans).getTriggers().add(tri);

			if (!interfaceItems.isEmpty()) {
				MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
				mif.setFrom(interfaceItems.get(0));
				mif.setMessage(interfaceItems.get(0).getProtocol().getIncomingMessages().get(0));
				tri.getMsgFromIfPairs().add(mif);
			}
		}
	}

}

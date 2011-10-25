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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class PortMessageSelectionDialog extends FormDialog {

	public static class MsgItemPair {
		Message msg;
		InterfaceItem item;
		boolean out;
		
		public MsgItemPair(Message msg, InterfaceItem item, boolean out) {
			super();
			this.msg = msg;
			this.item = item;
			this.out = out;
		}
	}
	
	private class PortMessageContentProvider implements ITreeContentProvider {

		private HashMap<InterfaceItem, ArrayList<MsgItemPair>> msg2item;
		
		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			msg2item = new HashMap<InterfaceItem, ArrayList<MsgItemPair>>();
			List<InterfaceItem> items = RoomHelpers.getAllInterfaceItems(ac);
			for (InterfaceItem item : items) {
				ArrayList<MsgItemPair> pairs = new ArrayList<MsgItemPair>();
				List<Message> out = RoomHelpers.getMessageList(item, true);
				for (Message msg : out) {
					pairs.add(new MsgItemPair(msg, item, true));
				}
				if (ac.getStateMachine().isDataDriven()) {
					List<Message> in = RoomHelpers.getMessageList(item, false);
					for (Message msg : in) {
						pairs.add(new MsgItemPair(msg, item, false));
					}
				}
				msg2item.put(item, pairs);
			}
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return RoomHelpers.getAllInterfaceItems(ac).toArray();
		}

		@Override
		public Object[] getChildren(Object element) {
			if (element instanceof InterfaceItem) {
				ArrayList<MsgItemPair> list = msg2item.get(element);
				return list.toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof MsgItemPair)
				return ((MsgItemPair) element).item;
			
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof InterfaceItem) {
				if (!RoomHelpers.getMessageList(((InterfaceItem)element), true).isEmpty())
					return true;
				
				if (ac.getStateMachine().isDataDriven())
					if (!RoomHelpers.getMessageList(((InterfaceItem)element), false).isEmpty())
						return true;
			}
			
			return false;
		}
		
	}
	
	private class PortMessageLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex==0) {
				if (element instanceof MsgItemPair)
					element = ((MsgItemPair) element).msg;
				return labelProvider.getImage(element);
			}
			
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				if (element instanceof InterfaceItem)
					return ((InterfaceItem) element).getName();
				else if (element instanceof MsgItemPair)
					return ((MsgItemPair) element).msg.getName();
				break;
			case 1:
				if (element instanceof MsgItemPair)
					return ((MsgItemPair) element).out? "out" : "in";
				break;
			case 2:
				if (element instanceof MsgItemPair) {
					Message msg = ((MsgItemPair) element).msg;
					if (msg.getData()!=null)
						return msg.getData().getName()+" : "+RoomHelpers.getName(msg.getData().getType());
				}
				break;
			}
			return null;
		}
		
		@Override
		public String getText(Object element) {
			return getColumnText(element, 0);
		}
		
		@Override
		public Image getImage(Object element) {
			return labelProvider.getImage(element);
		}
	}
	
	private ActorClass ac;
	private TreeViewer viewer;
	private MsgItemPair selected = null;

	@Inject
	ILabelProvider labelProvider;

	/**
	 * @param shell
	 */
	public PortMessageSelectionDialog(Shell shell, ActorClass ac) {
		super(shell);
		this.ac = ac;
		
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}
	
	@Override
	protected void createFormContent(IManagedForm mform) {
		FormToolkit toolkit = mform.getToolkit();

		Form form = mform.getForm().getForm();
		form.setText("Select a port.message Combination");

		form.setImage(Activator.getImage("icons/Behavior.gif"));
		toolkit.decorateFormHeading(form);

		Composite body = form.getBody();
		
		viewer = new TreeViewer(body, SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL);
		
		TreeColumn col0 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col0.setText("interface item/message");
		TreeColumn col1 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col1.setText("direction");
		TreeColumn col2 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col2.setText("data");

		viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.setContentProvider(new PortMessageContentProvider());
		viewer.setLabelProvider(new PortMessageLabelProvider());
		
		viewer.getTree().setHeaderVisible(true);
		viewer.setInput(ac);
		viewer.expandAll();
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Button ok = getButton(OK);
				if (ok!=null) {
					if (event.getSelection() instanceof IStructuredSelection) {
						Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
						ok.setEnabled(element instanceof MsgItemPair);
					}
				}
			}
		});

		// the tree layout is crucial!
		TreeColumnLayout layout = new TreeColumnLayout();
		body.setLayout(layout);

		layout.setColumnData(col0, new ColumnWeightData(40));
		layout.setColumnData(col1, new ColumnWeightData(20));
		layout.setColumnData(col2, new ColumnWeightData(40));
	}
	
	@Override
	protected void okPressed() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof MsgItemPair) {
				selected = (MsgItemPair) element;
			}
		}
		super.okPressed();
	}

	public MsgItemPair getMsgItemPair() {
		return selected;
	}
}

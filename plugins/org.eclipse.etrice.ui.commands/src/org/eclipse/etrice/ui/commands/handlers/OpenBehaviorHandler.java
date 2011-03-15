package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class OpenBehaviorHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public OpenBehaviorHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (editor instanceof StructureEditor) {
			StructureClass sc = ((StructureEditor)editor).getStructureClass();
			if (sc instanceof ActorClass) {
				DiagramAccess da = new DiagramAccess();
				da.openDiagramEditor(sc);
			}
		}
		else if (editor instanceof XtextEditor) {
			XtextEditor xed = (XtextEditor) editor;
			ISelection selection = xed.getSelectionProvider().getSelection();
			if (selection instanceof ITextSelection) {
				final ITextSelection ss = (ITextSelection) selection;
				xed.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						EObject obj = EObjectAtOffsetHelper.resolveElementAt(resource, ss.getOffset(), null);
						while (obj!=null) {
							if (obj instanceof ActorClass) {
								DiagramAccess da = new DiagramAccess();
								da.openDiagramEditor((ActorClass)obj);
								break;
							}
							obj = obj.eContainer();
						}
					}
				});
			}
		}
		return null;
	}
}

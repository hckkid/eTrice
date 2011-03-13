package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

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
		return null;
	}
}

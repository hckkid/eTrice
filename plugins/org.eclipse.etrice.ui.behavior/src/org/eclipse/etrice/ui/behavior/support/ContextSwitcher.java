package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

public class ContextSwitcher {

	public static void switchTo(Diagram diagram, StateGraph sg) {
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			assert(bo instanceof StateGraph): "expected state graph";
			
			if (bo instanceof StateGraph && bo==sg)
				activateContext(ctxShape, true);
			else
				activateContext(ctxShape, false);
		}
		
		activateTransitions(diagram);
	}

	private static void activateTransitions(Diagram diagram) {
		for (Connection conn : diagram.getConnections()) {
			boolean visible = conn.getStart().getParent().isVisible();
			conn.setVisible(visible);
			for (ConnectionDecorator dec : conn.getConnectionDecorators()) {
				dec.setVisible(visible);
			}
		}
	}

	private static void activateContext(Shape ctxShape, boolean activate) {
		ctxShape.setVisible(activate);
		TreeIterator<EObject> it = ctxShape.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof Shape) {
				((Shape) obj).setVisible(activate);
			}
		}
	}
}

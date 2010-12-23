/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.ActorContainerRefPropertyDialog;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemRef;

public class ActorContainerRefSupport {
	
	private static final int LINE_WIDTH = 1;
	public static final int DEFAULT_SIZE_X = 200;
	public static final int DEFAULT_SIZE_Y = 120;
	public static final int MIN_SIZE_X = 100;
	public static final int MIN_SIZE_Y = 60;
	public static final int MARGIN = 20;
	
	private static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	private static final IColorConstant INHERITED_COLOR = new ColorConstant(100, 100, 100);
	private static final IColorConstant BACKGROUND = new ColorConstant(200, 200, 200);

	private static class FeatureProvider extends DefaultFeatureProvider {
		
		private class CreateFeature extends AbstractCreateFeature {
	
			private boolean actorRef;

			public CreateFeature(IFeatureProvider fp, boolean actorRef) {
				super(fp, actorRef?"ActorRef":"SubSystemRef", "create "+(actorRef?"ActorRef":"SubSystemRef"));
				this.actorRef = actorRef;
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_REF;
			}
	
			@Override
			public boolean canCreate(ICreateContext context) {
				if (context.getTargetContainer().getLink()!=null)
					if (context.getTargetContainer().getLink().getBusinessObjects().size()==1) {
						EObject obj = context.getTargetContainer().getLink().getBusinessObjects().get(0);
						if (obj instanceof ActorContainerClass) {
							return actorRef;
						}
						if (obj instanceof LogicalSystem) {
							return !actorRef;
						}
					}
				return false;
			}
	
			@Override
			public Object[] create(ICreateContext context) {
		        
		        StructureClass sc = (StructureClass) context.getTargetContainer().getLink().getBusinessObjects().get(0);
		        
		        ActorContainerRef newRef = null;
		        if (sc instanceof ActorContainerClass) {
		        	ActorContainerClass acc = (ActorContainerClass) sc;
		        	
		        	// create ActorRef
		        	ActorRef ar = RoomFactory.eINSTANCE.createActorRef();
		        	ar.setName("");
			        
		        	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, ar, sc, true);
					if (dlg.open()!=Window.OK)
						// find a method to abort creation
						//throw new RuntimeException();
						return EMPTY;

			        acc.getActorRefs().add(ar);
		        	newRef = ar;
		        	
		        }
		        else if (sc instanceof LogicalSystem) {
		        	LogicalSystem sys = (LogicalSystem) sc;
		        	
		        	// create ActorRef
		        	SubSystemRef ssr = RoomFactory.eINSTANCE.createSubSystemRef();
		        	ssr.setName("");
			        
		        	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, ssr, sc, true);
					if (dlg.open()!=Window.OK)
						// find a method to abort creation
						//throw new RuntimeException();
						return EMPTY;
		        	
		        	sys.getSubSystems().add(ssr);
		        	newRef = ssr;
		        }
		        
		        addGraphicalRepresentation(context, newRef);
		        
		        // return newly created business object(s)
		        return new Object[] { newRef };
			}
		}
	
		private class AddFeature extends AbstractAddFeature {
	
			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canAdd(IAddContext context) {
				if (context.getNewObject() instanceof ActorContainerRef) {
					if (context.getTargetContainer().getLink().getBusinessObjects().size()==1) {
						EObject obj = context.getTargetContainer().getLink().getBusinessObjects().get(0);
						if (obj instanceof StructureClass) {
							return true;
						}
					}
				}
				return false;
			}
	
			@Override
			public PictogramElement add(IAddContext context) {
				ActorContainerRef ar = (ActorContainerRef) context.getNewObject();
				ContainerShape acShape = context.getTargetContainer();
	
				// CONTAINER SHAPE WITH RECTANGLE
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				ContainerShape containerShape =
					peCreateService.createContainerShape(acShape, true);
				
				Graphiti.getPeService().setPropertyValue(containerShape, Constants.TYPE_KEY, Constants.REF_TYPE);
	
				int width = context.getWidth() <= 0 ? DEFAULT_SIZE_X : context.getWidth();
				int height = context.getHeight() <= 0 ? DEFAULT_SIZE_Y : context.getHeight();
			
				EObject parent = acShape.getLink().getBusinessObjects().get(0);
				boolean inherited = isInherited(ar, parent);
				Color lineColor = manageColor(inherited?INHERITED_COLOR:LINE_COLOR);
				IGaService gaService = Graphiti.getGaService();
				{
					final Rectangle invisibleRectangle = gaService.createInvisibleRectangle(containerShape);
					gaService.setLocationAndSize(invisibleRectangle,
							context.getX(), context.getY(), width + 2*MARGIN, height + 2*MARGIN);
	
					Rectangle rect = gaService.createRectangle(invisibleRectangle);
					rect.setForeground(lineColor);
					rect.setBackground(manageColor(BACKGROUND));
					rect.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(rect, MARGIN, MARGIN, width, height);

					addSubStructureHint(ar, rect, lineColor);
					
					// anchor for layer connections
					ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
					anchor.setReferencedGraphicsAlgorithm(rect);
					
					// create link and wire it
					link(containerShape, ar);
					
					if (inherited) {
						InterfaceItemSupport.createInheritedRefItems(ar, containerShape, fp);
					}
					else {
						InterfaceItemSupport.createRefItems(ar, containerShape, fp);
					}
				}
				
				{
					Shape labelShape = peCreateService.createShape(containerShape, false);
					Text label = gaService.createDefaultText(labelShape, getLabel(ar));
					label.setForeground(lineColor);
					label.setBackground(lineColor);
					label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
					label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
					gaService.setLocationAndSize(label, MARGIN, MARGIN, width, height);
				}
	
				// call the layout feature
				layoutPictogramElement(containerShape);
	
				return containerShape;
			}
	
		}
		
		private class LayoutFeature extends AbstractLayoutFeature {
	
			public LayoutFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canLayout(ILayoutContext context) {
				// return true, if pictogram element is linked to an ActorContainerRef
				PictogramElement pe = context.getPictogramElement();
				if (!(pe instanceof ContainerShape))
					return false;
	
				EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
				return businessObjects.size() == 1
						&& businessObjects.get(0) instanceof ActorContainerRef;
			}
	
			@Override
			public boolean layout(ILayoutContext context) {
				boolean anythingChanged = false;
				ContainerShape containerShape = (ContainerShape) context
						.getPictogramElement();
	
				// our invisible rectangle
				GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
				
				int w = containerGa.getWidth();
				int h = containerGa.getHeight();
	
				if (containerGa.getGraphicsAlgorithmChildren().size()==1) {
					// the visible outer frame
					GraphicsAlgorithm ga = containerGa.getGraphicsAlgorithmChildren().get(0);
					
					int nw = w-2*MARGIN;
					int nh = h-2*MARGIN;
					
					ga.setWidth(nw);
					ga.setHeight(nh);
					
					Object bo = getBusinessObjectForPictogramElement(containerShape);
					if (bo instanceof ActorContainerRef) {
						ActorContainerRef acr = (ActorContainerRef) bo;
						ga.getGraphicsAlgorithmChildren().clear();
						EObject parent = containerShape.getContainer().getLink().getBusinessObjects().get(0);
						Color lineColor = manageColor(isInherited(acr, parent)?INHERITED_COLOR:LINE_COLOR);
						addSubStructureHint(acr, (Rectangle) ga, lineColor);
					}

					int last = containerShape.getChildren().size()-1;
					if (last>=0) {
						GraphicsAlgorithm childGA = containerShape.getChildren().get(last).getGraphicsAlgorithm();
						childGA.setWidth(nw);
						childGA.setHeight(nh);
					}
					
					anythingChanged = true;
				}
				
				return anythingChanged;
			}
		}

		private static class PropertyFeature extends AbstractCustomFeature {

			public PropertyFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Edit Reference...";
			}
			
			@Override
			public String getDescription() {
				return "Edit Reference Properties";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorContainerRef) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void execute(ICustomContext context) {
				ActorContainerRef acr = (ActorContainerRef) getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				StructureClass sc = (StructureClass)acr.eContainer();
				
				ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, acr, sc, false);
				if (dlg.open()!=Window.OK)
					// TODOHRR: introduce a method to revert changes
					throw new RuntimeException();
				
				updateFigure(acr, context);
			}

			private void updateFigure(ActorContainerRef acr, ICustomContext context) {
				PictogramElement pe = context.getPictogramElements()[0];
				ContainerShape container = (ContainerShape)pe;
				
				// we clear the figure and rebuild it
//				GraphicsAlgorithm invisibleRect = pe.getGraphicsAlgorithm();
//				invisibleRect.getGraphicsAlgorithmChildren().clear();
				
//				createPortFigure(acr, false, container, invisibleRect, manageColor(DARK_COLOR), manageColor(BRIGHT_COLOR));
				
				GraphicsAlgorithm ga = container.getChildren().get(1).getGraphicsAlgorithm();
				if (ga instanceof Text) {
					((Text)ga).setValue(acr.getName());
				}

			}
			
		}
		
		private static class DrillDownFeature extends AbstractDrillDownFeature {

			private ActorContainerRef ref = null;

			public DrillDownFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Open associated diagram";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorContainerRef) {
						ref  = (ActorContainerRef) bo;
						return true;
					}
				}
				return false;
			}
			
			@Override
			protected Collection<Diagram> getDiagrams() {
				ArrayList<Diagram> result = new ArrayList<Diagram>();
				if (ref!=null) {
					if (ref instanceof ActorRef) {
						result.add(DiagramAccess.getDiagram(((ActorRef) ref).getType()));
					}
					else if (ref instanceof SubSystemRef) {
						result.add(DiagramAccess.getDiagram(((SubSystemRef) ref).getType()));
					}
				}
				return result;
			}
			@Override
			protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
				return getDiagrams();
			}
		}
		
		private class UpdateFeature extends AbstractUpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public boolean canUpdate(IUpdateContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy())
					return true;
				
				return bo instanceof ActorContainerRef;
			}

			@Override
			public IReason updateNeeded(IUpdateContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy()) {
					return Reason.createTrueReason("Ref deleted from model");
				}
				ActorContainerRef acr = (ActorContainerRef) bo;
				
				// check if ref still owned/inherited anymore
				ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
				bo = getBusinessObjectForPictogramElement(containerShape);
				if (bo instanceof ActorClass) {
					ActorClass ac = (ActorClass) bo;
					boolean found = false;
					do {
						if (ac==acr.eContainer())
							found = true;
						ac = ac.getBase();
					}
					while (!found && ac!=null);
					
					if (!found)
						return Reason.createTrueReason("Ref not inherited anymore");
				}
				
				// check sub structure hint
				{
					boolean hasSubStruct = hasSubStructure(acr);
					GraphicsAlgorithm invisibleRect = containerShape.getGraphicsAlgorithm();
					if (!invisibleRect.getGraphicsAlgorithmChildren().isEmpty()) {
						
						GraphicsAlgorithm borderRect = invisibleRect.getGraphicsAlgorithmChildren().get(0);
						if (hasSubStruct && borderRect.getGraphicsAlgorithmChildren().isEmpty())
							return Reason.createTrueReason("Ref has sub structure now");
						if (!hasSubStruct && !borderRect.getGraphicsAlgorithmChildren().isEmpty())
							return Reason.createTrueReason("Ref has no sub structure anymore");
					}
				}
				
				// check class name
				int last = containerShape.getChildren().size()-1;
				if (last>=0) {
					GraphicsAlgorithm ga = containerShape.getChildren().get(last).getGraphicsAlgorithm();
					if (ga instanceof Text) {
						if (bo instanceof ActorContainerRef) {
							String label = getLabel((ActorContainerRef) bo);
							if (!((Text)ga).getValue().equals(label))
								return Reason.createTrueReason("Class name is out of date");
						}
					}
				}
				
				// TODOHRR: check interface ports and spps added to model not present in diagram
				
				return Reason.createFalseReason();
			}

			@Override
			public boolean update(IUpdateContext context) {
				ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
				Object bo = getBusinessObjectForPictogramElement(containerShape);
				if (bo instanceof EObject && ((EObject)bo).eIsProxy()) {
					IRemoveContext rc = new RemoveContext(containerShape);
					IFeatureProvider featureProvider = getFeatureProvider();
					IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
					if (removeFeature != null) {
						removeFeature.remove(rc);
					}
					EcoreUtil.delete((EObject) bo);
					return true;
				}
				
				{
					ActorContainerRef acr = (ActorContainerRef) bo;
					boolean hasSubStruct = hasSubStructure(acr);
					if (hasSubStruct && containerShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().isEmpty()) {
						EObject parent = containerShape.getContainer().getLink().getBusinessObjects().get(0);
						Color lineColor = manageColor(isInherited(acr, parent)?INHERITED_COLOR:LINE_COLOR);
						addSubStructureHint(acr, (Rectangle) containerShape.getGraphicsAlgorithm(), lineColor);
					}
					else if (!hasSubStruct && !containerShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().isEmpty())
						containerShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().clear();
				}
				
				int last = containerShape.getChildren().size()-1;
				if (last>=0) {
					GraphicsAlgorithm ga = containerShape.getChildren().get(last).getGraphicsAlgorithm();
					if (ga instanceof Text) {
						if (bo instanceof ActorContainerRef) {
							((Text)ga).setValue(getLabel((ActorContainerRef) bo));
						}
					}
				}

				// TODOHRR: add interface ports and spps added to model not present in diagram
				
				return true;
			}
		}
		
		private class MoveShapeFeature extends DefaultMoveShapeFeature {
	
			public MoveShapeFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canMoveShape(IMoveShapeContext context) {
				boolean canMove = super.canMoveShape(context);
	
				if (canMove) {
					Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
					
					if (bo instanceof ActorContainerRef) {
						ActorContainerRef ar = (ActorContainerRef) bo;
						ContainerShape acShape = context.getTargetContainer();
						EObject parent = acShape.getLink().getBusinessObjects().get(0);
						
						// TODOHRR: also check coordinates (no overlap with actor boundaries)
						
						return !isInherited(ar, parent);
					}
				}
				
				return canMove;
			}
		}
		
		private class ResizeFeature extends DefaultResizeShapeFeature {

			public ResizeFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canResizeShape(IResizeShapeContext context) {
				if (!super.canResizeShape(context))
					return false;
				
				int width = context.getWidth()-MARGIN;
				int height = context.getHeight()-MARGIN;
				if (width>0 && height>0)
					if (width < MIN_SIZE_X+MARGIN || height < MIN_SIZE_Y+MARGIN)
						return false;
				
				return true;
			}
			
			@Override
			public void resizeShape(IResizeShapeContext context) {
				Shape shape = context.getShape();
				
				if (shape.getGraphicsAlgorithm()!=null) {
					GraphicsAlgorithm containerGa = shape.getGraphicsAlgorithm();
					if (containerGa.getGraphicsAlgorithmChildren().size()==1) {
						// scale interface item coordinates
						// we refer to the visible rectangle which defines the border of our structure class
						// since the margin is not scaled
						GraphicsAlgorithm ga = containerGa.getGraphicsAlgorithmChildren().get(0);
						double sx = (context.getWidth()-2*MARGIN)/(double)ga.getWidth();
						double sy = (context.getHeight()-2*MARGIN)/(double)ga.getHeight();
						
						for (Shape childShape : ((ContainerShape)context.getShape()).getChildren()) {
							Object childBo = getBusinessObjectForPictogramElement(childShape);
							if (childBo instanceof InterfaceItem) {
								ga = childShape.getGraphicsAlgorithm();
								ga.setX((int) (ga.getX()*sx));
								ga.setY((int) (ga.getY()*sy));
							}
							
						}
					}
				}
				super.resizeShape(context);
			}
		}
		
		private IFeatureProvider fp;
	
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp);
			this.fp = fp;
		}
	
		@Override
		public ICreateFeature[] getCreateFeatures() {
			return new ICreateFeature[] { new CreateFeature(fp, true), new CreateFeature(fp, false) };
		}
	
		@Override
		public IAddFeature getAddFeature(IAddContext context) {
			return new AddFeature(fp);
		}
		
		@Override
		public ILayoutFeature getLayoutFeature(ILayoutContext context) {
			return new LayoutFeature(fp);
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			return new UpdateFeature(fp);
		}
		
		@Override
		public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
			return new MoveShapeFeature(fp);
		}
		
		@Override
		public IResizeShapeFeature getResizeShapeFeature(
				IResizeShapeContext context) {
			return new ResizeFeature(fp);
		}
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] { new PropertyFeature(fp), new DrillDownFeature(fp) };
		}

		protected static String getLabel(ActorContainerRef acr) {
			String className = "<unknown>";
			if (acr instanceof ActorRef) {
				if (((ActorRef)acr).getType()!=null)
					className = ((ActorRef)acr).getType().getName();
			}
			else if (acr instanceof SubSystemRef) {
				if (((SubSystemRef)acr).getType()!=null)
					className = ((SubSystemRef)acr).getType().getName();
			}
			return acr.getName()+"\n("+className+")";
		}
		
		protected static boolean isInherited(ActorContainerRef ar, EObject parent) {
			return ar.eContainer()!=parent;
		}

		private static boolean hasSubStructure(ActorContainerRef acr) {
			if (acr instanceof ActorRef) {
				if (!((ActorRef) acr).getType().getActorRefs().isEmpty())
					return true;
			}
			else if (acr instanceof SubSystemRef) {
				if (!((SubSystemRef)acr).getType().getActorRefs().isEmpty())
					return true;
			}
			return false;
		}
		
		private static void addSubStructureHint(ActorContainerRef acr,
				Rectangle rect, Color lineColor) {
			
			if (hasSubStructure(acr)) {
				int x = rect.getWidth()-35;
				int y = rect.getHeight()-30;
				IGaService gaService = Graphiti.getGaService();
				Rectangle hint1 = gaService.createRectangle(rect);
				hint1.setForeground(lineColor);
				hint1.setFilled(false);
				hint1.setLineWidth(LINE_WIDTH);
				gaService.setLocationAndSize(hint1, x+5, y, 20, 10);
				Rectangle hint2 = gaService.createRectangle(rect);
				hint2.setForeground(lineColor);
				hint2.setFilled(false);
				hint2.setLineWidth(LINE_WIDTH);
				gaService.setLocationAndSize(hint2, x, y+15, 20, 10);
			}
		}
	}
	
	private class BehaviorProvider extends DefaultToolBehaviorProvider {

		public BehaviorProvider(IDiagramTypeProvider dtp) {
			super(dtp);
		}
		
		@Override
		public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
            GraphicsAlgorithm rectangle =
                            invisible.getGraphicsAlgorithmChildren().get(0);
            return new GraphicsAlgorithm[] { rectangle };
		}
		
		@Override
		public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();

            GraphicsAlgorithm rectangle =
                invisible.getGraphicsAlgorithmChildren().get(0);
            return rectangle;
		}
		
		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
			return new FeatureProvider.DrillDownFeature(getDiagramTypeProvider().getFeatureProvider());
		}
	}
	
	private FeatureProvider pfp;
	private BehaviorProvider tbp;
	
	public ActorContainerRefSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
		pfp = new FeatureProvider(dtp,fp);
		tbp = new BehaviorProvider(dtp);
	}
	
	public IFeatureProvider getFeatureProvider() {
		return pfp;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return tbp;
	}
}

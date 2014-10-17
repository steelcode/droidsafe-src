package droidsafe.eclipse.plugin.core.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.ide.dialogs.SimpleListContentProvider;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.marker.ClassMarkerProcessor;
import droidsafe.eclipse.plugin.core.marker.ProjectMarkerProcessor;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.SourceSinkPair;
import droidsafe.eclipse.plugin.core.wizards.NewFilterWizard;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.IModelChangeSupport;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

public class FilterTaintSources extends AbstractHandler {
	
	private TaintSoucesContentProvider fContentProvider;

	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IProject project = DroidsafePluginUtilities.getSelectedProject();
        IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
        if (project != null && editor != null && editor instanceof ITextEditor) {
            ProjectMarkerProcessor taintMarkerProcessor = ProjectMarkerProcessor.get(project);
            Map<String,Set<CallLocationModel>> taintKinds = taintMarkerProcessor.getTaintKinds();
            Map<String,Set<CallLocationModel>> filteredTaintKinds = taintMarkerProcessor.getFilteredTaintSourcesMap();
            Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
            CheckedTreeSelectionDialog selectionDialog =
            		new CheckedTreeSelectionDialog(shell, new LabelProvider(), getContentProvider(project));
            selectionDialog.setTitle("Filter Taint Sources");
            selectionDialog.setMessage("Select the taint sources to display:");
            selectionDialog.setContainerMode(true);
            selectionDialog.setInput(project);
            selectionDialog.setExpandedElements(getExpandedElements());
            selectionDialog.setInitialElementSelections(getInitialSelection());
            
            selectionDialog.open();
            Object[] result = selectionDialog.getResult();
            if (result != null) {
            	Map<String, Set<CallLocationModel>> newFilteredTaintKinds = new TreeMap<String, Set<CallLocationModel>>();
                for (Object selected: result) {
                	TreeElement<?, ?> selectedElement = (TreeElement<?, ?>) selected;
                	Object data = selectedElement.getData();
                	if (data instanceof CallLocationModel) {
                		String taintKind = (String) selectedElement.getParent().getData();
                		CallLocationModel taintSource = (CallLocationModel) data;
                        Set<CallLocationModel> taintSources = newFilteredTaintKinds.get(taintKind);
                        if (taintSources == null) {
                        	taintSources = new TreeSet<CallLocationModel>();
                        	newFilteredTaintKinds.put(taintKind, taintSources);
                        }
                        taintSources.add(taintSource);
                	}
                }
                if (!newFilteredTaintKinds.equals(filteredTaintKinds)) {
                    ITextEditor textEditor = (ITextEditor) editor;
                    taintMarkerProcessor.setFilteredTaintSources(textEditor, newFilteredTaintKinds);
                }
            }
        }
        return null;
    }
	
	private ITreeContentProvider getContentProvider(IProject project) {
		if (fContentProvider == null) {
			fContentProvider = new TaintSoucesContentProvider();
		}
		fContentProvider.init(project);
		return fContentProvider;
	}

	private List getInitialSelection() {
		return fContentProvider.getInitialSelection();
	}

    private Object[] getExpandedElements() {
    	return fContentProvider.getExpandedElements();
	}

	class TaintSoucesContentProvider extends DroidsafeInfoTreeElementContentProvider {

        private IProject fProject;
        private Object[] fRoots;
        private Map<String, Set<CallLocationModel>> fTaintSourcesMap;
        private Map<String, Set<CallLocationModel>> fFilteredTaintSourcesMap;
        
        @Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof IProject) {
				return fRoots;
			}
			return NO_CHILDREN;
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	        fViewer = (TreeViewer) viewer;
		}

		@Override
		protected Object[] initializeRoots() {
			if (fTaintSourcesMap.isEmpty())
				return NO_CHILDREN;
			List<Object> roots = new ArrayList<Object>();
			for (Entry<String, Set<CallLocationModel>> entry : fTaintSourcesMap.entrySet()) {
				String taintKind = entry.getKey();
				TreeElement<String, CallLocationModel> root =
						new TreeElement<String, CallLocationModel>(taintKind, taintKind, CallLocationModel.class);
				for (CallLocationModel taintSource : entry.getValue()) {
					TreeElement<CallLocationModel, Object> taintSourceElement =
							new TreeElement<CallLocationModel, Object>(taintSource.toString(), taintSource, Object.class);
					root.addChild(taintSourceElement);
				}
				roots.add(root);
			}
			
			return roots.toArray();
		}

		@Override
		protected void reset() {
		}

		void init(IProject project) {
            fProject = project;
			ProjectMarkerProcessor markerProcessor = ProjectMarkerProcessor.get(fProject);
			fTaintSourcesMap = markerProcessor.getTaintKinds();
			fFilteredTaintSourcesMap = markerProcessor.getFilteredTaintSourcesMap();
			fRoots = initializeRoots();
		}
		
		
		Object[] getExpandedElements() {
			List<Object> toExpand = new ArrayList<Object>();
			for (Object root: getElements(fProject)) {
				TreeElement<?, ?> rootElement = (TreeElement<?, ?>) root;
				String taintKind = (String) rootElement.getData();
				Set<CallLocationModel> filteredTaintSources = fFilteredTaintSourcesMap.get(taintKind);
				if (filteredTaintSources != null) {
					Set<CallLocationModel> taintSources = fTaintSourcesMap.get(taintKind);
					if (filteredTaintSources.size() != taintSources.size()) {
						toExpand.add(rootElement);
					}
				}
			}
			return toExpand.toArray(new Object[0]);
		}

		List getInitialSelection() {
			List<Object> initialSelection = new ArrayList<Object>();
			for (Object root: getElements(fProject)) {
				TreeElement<?, ?> rootElement = (TreeElement<?, ?>) root;
				String taintKind = (String) rootElement.getData();
				Set<CallLocationModel> filteredTaintSources = fFilteredTaintSourcesMap.get(taintKind);
				if (filteredTaintSources != null) {
					Set<CallLocationModel> taintSources = fTaintSourcesMap.get(taintKind);
					for (TreeElement<?, ?> child: rootElement.getChildren()) {
						if (filteredTaintSources.contains(child.getData())) {
							initialSelection.add(child);
						}
					}
				}
			}
			return initialSelection;
		}

    }
}

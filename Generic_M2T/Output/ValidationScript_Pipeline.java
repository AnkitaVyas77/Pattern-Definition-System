
package ca.mcgill.devops.pipeline.resourceloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Injector;
import ca.mcgill.devops.pipeline.PipelineStandaloneSetup;
import ca.mcgill.devops.pipeline.pipeline.*;
public class PatternToValidationScript {

private static boolean matchesPattern(EObject root) {
    if (root instanceof Pipeline) {
        return matchesPatternPipeline(((Pipeline) root));
    }
    return false;
}


private static boolean matchesPatternPipeline(Pipeline root) {
    return 
      matchesEventTriggers_1(root) 
 ;
}
  

    //template protected generateRelationMethods(rel : Relation, className : String)]
    //Relation: triggers
    private static boolean matchesEventTriggers_1(Pipeline classElem ) {
        boolean hastriggers = false;
        
        
            int matchedBlocks = 0;
            
             List<Integer> triggersMatchedIdx = new ArrayList<>(); 
    
    
                 {
                    //int ind =0;
    
                    
                    
                        int triggersStartIdx = 0;
    
    
                        // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                    EStructuralFeature _feat_triggers =
                        classElem.eClass().getEStructuralFeature("triggers");
                    if (_feat_triggers == null) return false;
                    
                    Object _raw_triggers = classElem.eGet(_feat_triggers);
                    if (!(_raw_triggers instanceof EList<?>)) return false;
                    
                    EList<?> listOfTriggers = (EList<?>) _raw_triggers;
                    
                    for (int triggersidx = triggersStartIdx;
                         triggersidx < listOfTriggers.size();
                         triggersidx++) {
                    
                        Object _item_ = listOfTriggers.get(triggersidx);
                    
                        // Type refinement: only proceed if element IS the requested subclass
                        if (!(_item_ instanceof Event)) {
                            continue;
                        }
                        Event EventtriggersElem = (Event) _item_;
    
           
                    
    
                    int blockCounter = 0;
                    //ind += 1 ;
    
                     if (!(triggersMatchedIdx.contains(triggersidx)))  { 
                    
    
                    
                        
                                EStructuralFeature attrF_workflowTypeKW = EventtriggersElem.eClass().getEStructuralFeature("workflowTypeKW");
                                Object attr_workflowTypeKW = (attrF_workflowTypeKW != null) ? EventtriggersElem.eGet(attrF_workflowTypeKW) : null;
                                if (attr_workflowTypeKW != null && String.valueOf(attr_workflowTypeKW).equals("workflow_call:")) {
                                    blockCounter += 1;
                                }
                        
                        
                        
                            
                                
    
                                // **CALL** the nested match function with the same childSuffix the declaration uses:
                                if ( matchesActivityWorkFlowActivities_1_1(EventtriggersElem) ) {
          
                                blockCounter++;
                            }
                        
                        
    
                    if (blockCounter == 2) {
                        matchedBlocks++;
                             triggersMatchedIdx.add(triggersidx);
                        
     break; 
                            }                        
                        }
                    }
                 } 
    
            
            if (matchedBlocks == 1) {
                hastriggers = true;
                
            }
        
    
        return hastriggers; 
    
    }
          
  
  
              //template protected generateRelationMethods(rel : Relation, className : String)]
              //Relation: workFlowActivities
              private static boolean matchesActivityWorkFlowActivities_1_1(Event classElem ) {
                  boolean hasworkFlowActivities = false;
                  
                  
                      int matchedBlocks = 0;
                      
                       List<Integer> workFlowActivitiesMatchedIdx = new ArrayList<>(); 
              
              
                           {
                              //int ind =0;
              
                              
                              
                                  int workFlowActivitiesStartIdx = 0;
              
              
                                  // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                              EStructuralFeature _feat_workFlowActivities =
                                  classElem.eClass().getEStructuralFeature("workFlowActivities");
                              if (_feat_workFlowActivities == null) return false;
                              
                              Object _raw_workFlowActivities = classElem.eGet(_feat_workFlowActivities);
                              if (!(_raw_workFlowActivities instanceof EList<?>)) return false;
                              
                              EList<?> listOfWorkFlowActivities = (EList<?>) _raw_workFlowActivities;
                              
                              for (int workFlowActivitiesidx = workFlowActivitiesStartIdx;
                                   workFlowActivitiesidx < listOfWorkFlowActivities.size();
                                   workFlowActivitiesidx++) {
                              
                                  Object _item_ = listOfWorkFlowActivities.get(workFlowActivitiesidx);
                              
                                  // Type refinement: only proceed if element IS the requested subclass
                                  if (!(_item_ instanceof Activity)) {
                                      continue;
                                  }
                                  Activity ActivityworkFlowActivitiesElem = (Activity) _item_;
              
                     
                              
              
                              int blockCounter = 0;
                              //ind += 1 ;
              
                               if (!(workFlowActivitiesMatchedIdx.contains(workFlowActivitiesidx)))  { 
                              
              
                              
                                  
                                          EStructuralFeature attrF_name = ActivityworkFlowActivitiesElem.eClass().getEStructuralFeature("name");
                                          Object attr_name = (attrF_name != null) ? ActivityworkFlowActivitiesElem.eGet(attrF_name) : null;
                                          if (attr_name != null && String.valueOf(attr_name).equals("inputs:")) {
                                              blockCounter += 1;
                                          }
                                  
                                  
              
                              if (blockCounter == 1) {
                                  matchedBlocks++;
                                       workFlowActivitiesMatchedIdx.add(workFlowActivitiesidx);
                                  
               break; 
                                      }                        
                                  }
                              }
                           } 
              
                      
                      if (matchedBlocks == 1) {
                          hasworkFlowActivities = true;
                          
                      }
                  
              
                  return hasworkFlowActivities; 
              
              }
               
                       
  
                  


                      



public static Pipeline resourceLoad(String resourcePath, String fileName) {
    try {
        
        Injector injector = new PipelineStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

        // Ensure consistent file path without duplicate slashes
        String normalizedPath = Paths.get(resourcePath, fileName).toString().replace("\\", "/");
        String inputURI = "file:///" + normalizedPath;



        URI uri = URI.createURI(inputURI);
        Resource xtextResource = resourceSet.getResource(uri, true);

        IResourceValidator resourceValidator = injector.getInstance(IResourceValidator.class);
        Iterable<Issue> issues = resourceValidator.validate(xtextResource, CheckMode.ALL, CancelIndicator.NullImpl);
        // Print validation issues
        int issueCounter = printValidationIssues(issues);
        EcoreUtil.resolveAll(xtextResource);

        if (issueCounter == 0) {
            return (Pipeline) xtextResource.getContents().get(0);
        } else {
            System.out.println("File skipped due to validation issues: " + fileName);
            return null;
        }
    } catch (Exception e) {
        System.err.println("Error reading or parsing file: " + fileName + " - " + e.getMessage());
        return null;
    }
}

private static int printValidationIssues(Iterable<Issue> issues) {
    int counter = 0;
    for (Issue issue : issues) {
        counter++;
    }
    return counter;
}

public static void main(String[] args) {
     String datasetPath = "/Users/ankita/Desktop/sample_V3_dataset"; //V3_DatasetTest_Valid
        String fileExtension = ".Pipeline"; // e.g. “.Pipeline” or whatever your DSL uses
        String outputNonMatching = "/Users/ankita/Desktop/Thesis-work/Generic M2T metrics/non_matching_files_all_files.txt";
        String outputInvalid = "/Users/ankita/Desktop/Thesis-work/Generic M2T metrics/invalid_files_all_files.txt";
        String outputMatching = "/Users/ankita/Desktop/Thesis-work/Generic M2T metrics/Patternmatching_files_all_files.txt";

    File folder = new File(datasetPath);
    File[] allFiles = folder.listFiles();
    if (allFiles == null || allFiles.length == 0) {
        System.out.println("No files found.");
        return;
    }

    List<String> matches = new ArrayList<>();
    List<String> nonMatches = new ArrayList<>();
    List<String> invalids = new ArrayList<>();
    int validated = 0;

    for (File f : allFiles) {
        if (!f.getName().endsWith(fileExtension)) continue;
        Pipeline model = resourceLoad(datasetPath, f.getName());
        if (model == null) {
            invalids.add(f.getName());
            continue;
        }
        validated++;
        if (matchesPattern(model)) {
            matches.add(f.getName());
        } else {
            nonMatches.add(f.getName());
        }
    }

    try { Files.write(Paths.get(outputMatching), matches); } catch (IOException e) {}
    try { Files.write(Paths.get(outputNonMatching), nonMatches); } catch (IOException e) {}
    try { Files.write(Paths.get(outputInvalid), invalids); } catch (IOException e) {}

   
    //System.out.println("Validated: " + validated + ", Matches: " + matches.size());
    System.out.println("Successfully validated files: " + validated);
    System.out.println("Files matching pattern: " + matches.size());
    double percentageMatching = validated > 0 ? ((double) matches.size() / validated) * 100 : 0;
    System.out.println("Percentage matching (matchingFiles / validatedFiles): " + percentageMatching + "%");
}
}

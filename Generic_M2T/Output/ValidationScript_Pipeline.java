
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
          matchesConfigurationPipelineConfiguration_1(root) && 
          matchesEventTriggers_1(root) && 
          matchesJobJobs_1(root)
        ;
    
    }



        //template protected generateRelationMethods(rel : Relation, className : String)]
        //Relation: pipelineConfiguration
        private static boolean matchesConfigurationPipelineConfiguration_1(Pipeline classElem ) {
            boolean haspipelineConfiguration = false;
            
            
                int matchedBlocks = 0;
                
                
        
        
                     {
                        //int ind =0;
        
                        
                        
            
                            EStructuralFeature _feat_pipelineConfiguration = classElem.eClass().getEStructuralFeature("pipelineConfiguration");
                            if (_feat_pipelineConfiguration == null) return false;
        
                            Object _obj_pipelineConfiguration = classElem.eGet(_feat_pipelineConfiguration);
                            if (!(_obj_pipelineConfiguration instanceof Configuration)) {
                                    return false; // present but not the refined type
                            }
                            Configuration ConfigurationpipelineConfigurationElem = (Configuration) _obj_pipelineConfiguration;
        
                        
                        
        
                        int blockCounter = 0;
                        //ind += 1 ;
        
                        
                        
        
                        
                            
                                    EStructuralFeature attrF_name = ConfigurationpipelineConfigurationElem.eClass().getEStructuralFeature("name");
                                    Object attr_name = (attrF_name != null) ? ConfigurationpipelineConfigurationElem.eGet(attrF_name) : null;
                                    if (attr_name != null) {
                                        blockCounter += 1;
                                    }
                            
                            
        
                        if (blockCounter == 1) {
                            matchedBlocks++;
                                
                            
                                
                            }
                        }
                    
        
                
                if (matchedBlocks == 1) {
                    haspipelineConfiguration = true;
                    
                }
            
        
            return haspipelineConfiguration; 
        
        }
        
      


        //template protected generateRelationMethods(rel : Relation, className : String)]
        //Relation: triggers
        private static boolean matchesEventTriggers_1(Pipeline classElem ) {
            boolean hastriggers = false;
            
            
                    // --- presence only relation (like Steps etc) ---
                    if (classElem.getTriggers() != null && !(classElem.getTriggers().isEmpty())) {
                    hastriggers = true;
                    }
                return hastriggers;
        
        }
        
      


        //template protected generateRelationMethods(rel : Relation, className : String)]
        //Relation: jobs
        private static boolean matchesJobJobs_1(Pipeline classElem ) {
            boolean hasjobs = false;
            
            
                int matchedBlocks = 0;
                
                 List<Integer> jobsMatchedIdx = new ArrayList<>(); 
        
        
                     {
                        //int ind =0;
        
                        
                        
                            int jobsStartIdx = 0;
        
        
                            // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                        EStructuralFeature _feat_jobs =
                            classElem.eClass().getEStructuralFeature("jobs");
                        if (_feat_jobs == null) return false;
                        
                        Object _raw_jobs = classElem.eGet(_feat_jobs);
                        if (!(_raw_jobs instanceof EList<?>)) return false;
                        
                        EList<?> listOfJobs = (EList<?>) _raw_jobs;
                        
                        for (int jobsidx = jobsStartIdx;
                             jobsidx < listOfJobs.size();
                             jobsidx++) {
                        
                            Object _item_ = listOfJobs.get(jobsidx);
                        
                            // Type refinement: only proceed if element IS the requested subclass
                            if (!(_item_ instanceof Job)) {
                                continue;
                            }
                            Job JobjobsElem = (Job) _item_;
        
               
                        
        
                        int blockCounter = 0;
                        //ind += 1 ;
        
                         if (!(jobsMatchedIdx.contains(jobsidx)))  { 
                        
        
                        
                            
                                    EStructuralFeature attrF_name = JobjobsElem.eClass().getEStructuralFeature("name");
                                    Object attr_name = (attrF_name != null) ? JobjobsElem.eGet(attrF_name) : null;
                                    if (attr_name != null) {
                                        blockCounter += 1;
                                    }
                            
                            
                            
                                
                                    
        
                                    // **CALL** the nested match function with the same childSuffix the declaration uses:
                                    if ( matchesParameterValueJobParameterValues_1_1(JobjobsElem) ) {
              
                                    blockCounter++;
                                }
                            
                            
                            
                                
                                    
        
                                    // **CALL** the nested match function with the same childSuffix the declaration uses:
                                    if ( matchesStepSteps_1_1(JobjobsElem) ) {
              
                                    blockCounter++;
                                }
                            
                            
        
                        if (blockCounter == 3) {
                            matchedBlocks++;
                                 jobsMatchedIdx.add(jobsidx);
                            
         break; 
                                }                        
                            }
                        }
                     } 
        
                
                if (matchedBlocks == 1) {
                    hasjobs = true;
                    
                }
            
        
            return hasjobs; 
        
        }
        
      
      
                  //template protected generateRelationMethods(rel : Relation, className : String)]
                  //Relation: jobParameterValues
                  private static boolean matchesParameterValueJobParameterValues_1_1(Job classElem ) {
                      boolean hasjobParameterValues = false;
                      
                      
                          int matchedBlocks = 0;
                          
                           List<Integer> jobParameterValuesMatchedIdx = new ArrayList<>(); 
                  
                  
                               {
                                  //int ind =0;
                  
                                  
                                  
                                      int jobParameterValuesStartIdx = 0;
                  
                  
                                      // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                                  EStructuralFeature _feat_jobParameterValues =
                                      classElem.eClass().getEStructuralFeature("jobParameterValues");
                                  if (_feat_jobParameterValues == null) return false;
                                  
                                  Object _raw_jobParameterValues = classElem.eGet(_feat_jobParameterValues);
                                  if (!(_raw_jobParameterValues instanceof EList<?>)) return false;
                                  
                                  EList<?> listOfJobParameterValues = (EList<?>) _raw_jobParameterValues;
                                  
                                  for (int jobParameterValuesidx = jobParameterValuesStartIdx;
                                       jobParameterValuesidx < listOfJobParameterValues.size();
                                       jobParameterValuesidx++) {
                                  
                                      Object _item_ = listOfJobParameterValues.get(jobParameterValuesidx);
                                  
                                      // Type refinement: only proceed if element IS the requested subclass
                                      if (!(_item_ instanceof ParameterValue)) {
                                          continue;
                                      }
                                      ParameterValue ParameterValuejobParameterValuesElem = (ParameterValue) _item_;
                  
                         
                                  
                  
                                  int blockCounter = 0;
                                  //ind += 1 ;
                  
                                   if (!(jobParameterValuesMatchedIdx.contains(jobParameterValuesidx)))  { 
                                  
                  
                                  
                                      
                                              EStructuralFeature _ef_ = ParameterValuejobParameterValuesElem.eClass().getEStructuralFeature("name");
                                              Object _ev_ = (_ef_ != null) ? ParameterValuejobParameterValuesElem.eGet(_ef_) : null;
                                              if (_ev_ != null) {
                                                  String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                                  if ("runs-on:".equals(_lit_)) {
                                                      blockCounter += 1;
                                                  }
                                              }
                                      
                                      
                  
                                  if (blockCounter == 1) {
                                      matchedBlocks++;
                                           jobParameterValuesMatchedIdx.add(jobParameterValuesidx);
                                      
                   break; 
                                          }                        
                                      }
                                  }
                               } 
                  
                               {
                                  //int ind =0;
                  
                                  
                                  
                                      int jobParameterValuesStartIdx = 0;
                  
                  
                                      // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                                  EStructuralFeature _feat_jobParameterValues =
                                      classElem.eClass().getEStructuralFeature("jobParameterValues");
                                  if (_feat_jobParameterValues == null) return false;
                                  
                                  Object _raw_jobParameterValues = classElem.eGet(_feat_jobParameterValues);
                                  if (!(_raw_jobParameterValues instanceof EList<?>)) return false;
                                  
                                  EList<?> listOfJobParameterValues = (EList<?>) _raw_jobParameterValues;
                                  
                                  for (int jobParameterValuesidx = jobParameterValuesStartIdx;
                                       jobParameterValuesidx < listOfJobParameterValues.size();
                                       jobParameterValuesidx++) {
                                  
                                      Object _item_ = listOfJobParameterValues.get(jobParameterValuesidx);
                                  
                                      // Type refinement: only proceed if element IS the requested subclass
                                      if (!(_item_ instanceof ParameterValue)) {
                                          continue;
                                      }
                                      ParameterValue ParameterValuejobParameterValuesElem = (ParameterValue) _item_;
                  
                         
                                  
                  
                                  int blockCounter = 0;
                                  //ind += 1 ;
                  
                                   if (!(jobParameterValuesMatchedIdx.contains(jobParameterValuesidx)))  { 
                                  
                  
                                  
                                      
                                              EStructuralFeature _ef_ = ParameterValuejobParameterValuesElem.eClass().getEStructuralFeature("name");
                                              Object _ev_ = (_ef_ != null) ? ParameterValuejobParameterValuesElem.eGet(_ef_) : null;
                                              if (_ev_ != null) {
                                                  String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                                  if ("container:".equals(_lit_)) {
                                                      blockCounter += 1;
                                                  }
                                              }
                                      
                                      
                                      
                                          
                                              
                  
                                              // **CALL** the nested match function with the same childSuffix the declaration uses:
                                              if ( matchesParameterValueSubParameters_1_1_1(ParameterValuejobParameterValuesElem) ) {
                        
                                              blockCounter++;
                                          }
                                      
                                      
                  
                                  if (blockCounter == 2) {
                                      matchedBlocks++;
                                           jobParameterValuesMatchedIdx.add(jobParameterValuesidx);
                                      
                   break; 
                                          }                        
                                      }
                                  }
                               } 
                  
                          
                          if (matchedBlocks == 2) {
                              hasjobParameterValues = true;
                              
                          }
                      
                  
                      return hasjobParameterValues; 
                  
                  }
                   
                
                
                            //template protected generateRelationMethods(rel : Relation, className : String)]
                            //Relation: subParameters
                            private static boolean matchesParameterValueSubParameters_1_1_1(ParameterValue classElem ) {
                                boolean hassubParameters = false;
                                
                                
                                    int matchedBlocks = 0;
                                    
                                     List<Integer> subParametersMatchedIdx = new ArrayList<>(); 
                            
                            
                                         {
                                            //int ind =0;
                            
                                            
                                            
                                                int subParametersStartIdx = 0;
                            
                            
                                                // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                                            EStructuralFeature _feat_subParameters =
                                                classElem.eClass().getEStructuralFeature("subParameters");
                                            if (_feat_subParameters == null) return false;
                                            
                                            Object _raw_subParameters = classElem.eGet(_feat_subParameters);
                                            if (!(_raw_subParameters instanceof EList<?>)) return false;
                                            
                                            EList<?> listOfSubParameters = (EList<?>) _raw_subParameters;
                                            
                                            for (int subParametersidx = subParametersStartIdx;
                                                 subParametersidx < listOfSubParameters.size();
                                                 subParametersidx++) {
                                            
                                                Object _item_ = listOfSubParameters.get(subParametersidx);
                                            
                                                // Type refinement: only proceed if element IS the requested subclass
                                                if (!(_item_ instanceof ParameterValue)) {
                                                    continue;
                                                }
                                                ParameterValue ParameterValuesubParametersElem = (ParameterValue) _item_;
                            
                                   
                                            
                            
                                            int blockCounter = 0;
                                            //ind += 1 ;
                            
                                             if (!(subParametersMatchedIdx.contains(subParametersidx)))  { 
                                            
                            
                                            
                                                
                                                        EStructuralFeature _ef_ = ParameterValuesubParametersElem.eClass().getEStructuralFeature("name");
                                                        Object _ev_ = (_ef_ != null) ? ParameterValuesubParametersElem.eGet(_ef_) : null;
                                                        if (_ev_ != null) {
                                                            String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                                            if ("image:".equals(_lit_)) {
                                                                blockCounter += 1;
                                                            }
                                                        }
                                                
                                                
                            
                                            if (blockCounter == 1) {
                                                matchedBlocks++;
                                                     subParametersMatchedIdx.add(subParametersidx);
                                                
                             break; 
                                                    }                        
                                                }
                                            }
                                         } 
                            
                                    
                                    if (matchedBlocks == 1) {
                                        hassubParameters = true;
                                        
                                    }
                                
                            
                                return hassubParameters; 
                            
                            }
                             
                                     
                
                           
      
      
      
                  //template protected generateRelationMethods(rel : Relation, className : String)]
                  //Relation: steps
                  private static boolean matchesStepSteps_1_1(Job classElem ) {
                      boolean hassteps = false;
                      
                      
                          int matchedBlocks = 0;
                          
                           List<Integer> stepsMatchedIdx = new ArrayList<>(); 
                  
                  
                               {
                                  //int ind =0;
                  
                                  
                                  
                                      int stepsStartIdx = 0;
                  
                  
                                      // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                                  EStructuralFeature _feat_steps =
                                      classElem.eClass().getEStructuralFeature("steps");
                                  if (_feat_steps == null) return false;
                                  
                                  Object _raw_steps = classElem.eGet(_feat_steps);
                                  if (!(_raw_steps instanceof EList<?>)) return false;
                                  
                                  EList<?> listOfSteps = (EList<?>) _raw_steps;
                                  
                                  for (int stepsidx = stepsStartIdx;
                                       stepsidx < listOfSteps.size();
                                       stepsidx++) {
                                  
                                      Object _item_ = listOfSteps.get(stepsidx);
                                  
                                      // Type refinement: only proceed if element IS the requested subclass
                                      if (!(_item_ instanceof Step)) {
                                          continue;
                                      }
                                      Step StepstepsElem = (Step) _item_;
                  
                         
                                  
                  
                                  int blockCounter = 0;
                                  //ind += 1 ;
                  
                                   if (!(stepsMatchedIdx.contains(stepsidx)))  { 
                                  
                  
                                  
                                      
                                              EStructuralFeature _ef_ = StepstepsElem.eClass().getEStructuralFeature("actionKeyword");
                                              Object _ev_ = (_ef_ != null) ? StepstepsElem.eGet(_ef_) : null;
                                              if (_ev_ != null) {
                                                  String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                                  if ("name:".equals(_lit_)) {
                                                      blockCounter += 1;
                                                  }
                                              }
                                      
                                      
                                      
                                          
                                              
                  
                                              // **CALL** the nested match function with the same childSuffix the declaration uses:
                                              if ( matchesScriptSubSteps_1_1_1(StepstepsElem) ) {
                        
                                              blockCounter++;
                                          }
                                      
                                      
                  
                                  if (blockCounter == 2) {
                                      matchedBlocks++;
                                           stepsMatchedIdx.add(stepsidx);
                                      
                   break; 
                                          }                        
                                      }
                                  }
                               } 
                  
                          
                          if (matchedBlocks == 1) {
                              hassteps = true;
                              
                          }
                      
                  
                      return hassteps; 
                  
                  }
                   
                
                
                            //template protected generateRelationMethods(rel : Relation, className : String)]
                            //Relation: subSteps
                            private static boolean matchesScriptSubSteps_1_1_1(Step classElem ) {
                                boolean hassubSteps = false;
                                
                                
                                    int matchedBlocks = 0;
                                    
                                     List<Integer> subStepsMatchedIdx = new ArrayList<>(); 
                            
                            
                                         {
                                            //int ind =0;
                            
                                            
                                            
                                                int subStepsStartIdx = 0;
                            
                            
                                                // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                                            EStructuralFeature _feat_subSteps =
                                                classElem.eClass().getEStructuralFeature("subSteps");
                                            if (_feat_subSteps == null) return false;
                                            
                                            Object _raw_subSteps = classElem.eGet(_feat_subSteps);
                                            if (!(_raw_subSteps instanceof EList<?>)) return false;
                                            
                                            EList<?> listOfSubSteps = (EList<?>) _raw_subSteps;
                                            
                                            for (int subStepsidx = subStepsStartIdx;
                                                 subStepsidx < listOfSubSteps.size();
                                                 subStepsidx++) {
                                            
                                                Object _item_ = listOfSubSteps.get(subStepsidx);
                                            
                                                // Type refinement: only proceed if element IS the requested subclass
                                                if (!(_item_ instanceof Script)) {
                                                    continue;
                                                }
                                                Script ScriptsubStepsElem = (Script) _item_;
                            
                                   
                                            
                            
                                            int blockCounter = 0;
                                            //ind += 1 ;
                            
                                             if (!(subStepsMatchedIdx.contains(subStepsidx)))  { 
                                            
                            
                                            
                                                
                                                        EStructuralFeature attrF_name = ScriptsubStepsElem.eClass().getEStructuralFeature("name");
                                                        Object attr_name = (attrF_name != null) ? ScriptsubStepsElem.eGet(attrF_name) : null;
                                                        if (attr_name != null && String.valueOf(attr_name).equals("run:")) {
                                                            blockCounter += 1;
                                                        }
                                                
                                                
                            
                                            if (blockCounter == 1) {
                                                matchedBlocks++;
                                                     subStepsMatchedIdx.add(subStepsidx);
                                                
                             break; 
                                                    }                        
                                                }
                                            }
                                         } 
                            
                                    
                                    if (matchedBlocks == 1) {
                                        hassubSteps = true;
                                        
                                    }
                                
                            
                                return hassubSteps; 
                            
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

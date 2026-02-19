
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
      matchesJobJobs_1(root) 
 ;
}
  

    //template protected generateRelationMethods(rel : Relation, className : String)]
    //Relation: Jobs
    private static boolean matchesJobJobs_1(Pipeline classElem ) {
        boolean hasJobs = false;
        
        
            int matchedBlocks = 0;
            
             List<Integer> JobsMatchedIdx = new ArrayList<>(); 
    
    
                 {
                    //int ind =0;
    
                    
                    
                        int JobsStartIdx = 0;
    
    
                        // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                    EStructuralFeature _feat_Jobs =
                        classElem.eClass().getEStructuralFeature("Jobs");
                    if (_feat_Jobs == null) return false;
                    
                    Object _raw_Jobs = classElem.eGet(_feat_Jobs);
                    if (!(_raw_Jobs instanceof EList<?>)) return false;
                    
                    EList<?> listOfJobs = (EList<?>) _raw_Jobs;
                    
                    for (int Jobsidx = JobsStartIdx;
                         Jobsidx < listOfJobs.size();
                         Jobsidx++) {
                    
                        Object _item_ = listOfJobs.get(Jobsidx);
                    
                        // Type refinement: only proceed if element IS the requested subclass
                        if (!(_item_ instanceof Job)) {
                            continue;
                        }
                        Job JobJobsElem = (Job) _item_;
    
           
                    
    
                    int blockCounter = 0;
                    //ind += 1 ;
    
                     if (!(JobsMatchedIdx.contains(Jobsidx)))  { 
                    
    
                    
                        
                                EStructuralFeature attrF_name = JobJobsElem.eClass().getEStructuralFeature("name");
                                Object attr_name = (attrF_name != null) ? JobJobsElem.eGet(attrF_name) : null;
                                if (attr_name != null) {
                                    blockCounter += 1;
                                }
                        
                        
                        
                                EStructuralFeature attrF_dependKW = JobJobsElem.eClass().getEStructuralFeature("dependKW");
                                Object attr_dependKW = (attrF_dependKW != null) ? JobJobsElem.eGet(attrF_dependKW) : null;
                                if (attr_dependKW != null) {
                                    blockCounter += 1;
                                }
                        
                        
                        
                            
                                
    
                                // **CALL** the nested match function with the same childSuffix the declaration uses:
                                if ( matchesParameterValueJobParameterValues_1_1(JobJobsElem) ) {
          
                                blockCounter++;
                            }
                        
                        
                        
                            
                                
    
                                // **CALL** the nested match function with the same childSuffix the declaration uses:
                                if ( matchesStepSteps_1_1(JobJobsElem) ) {
          
                                blockCounter++;
                            }
                        
                        
    
                    if (blockCounter == 4) {
                        matchedBlocks++;
                             JobsMatchedIdx.add(Jobsidx);
                        
     break; 
                            }                        
                        }
                    }
                 } 
    
            
            if (matchedBlocks == 1) {
                hasJobs = true;
                
            }
        
    
        return hasJobs; 
    
    }
          
  
  
              //template protected generateRelationMethods(rel : Relation, className : String)]
              //Relation: JobParameterValues
              private static boolean matchesParameterValueJobParameterValues_1_1(Job classElem ) {
                  boolean hasJobParameterValues = false;
                  
                  
                      int matchedBlocks = 0;
                      
                       List<Integer> JobParameterValuesMatchedIdx = new ArrayList<>(); 
              
              
                           {
                              //int ind =0;
              
                              
                              
                                  int JobParameterValuesStartIdx = 0;
              
              
                                  // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                              EStructuralFeature _feat_JobParameterValues =
                                  classElem.eClass().getEStructuralFeature("JobParameterValues");
                              if (_feat_JobParameterValues == null) return false;
                              
                              Object _raw_JobParameterValues = classElem.eGet(_feat_JobParameterValues);
                              if (!(_raw_JobParameterValues instanceof EList<?>)) return false;
                              
                              EList<?> listOfJobParameterValues = (EList<?>) _raw_JobParameterValues;
                              
                              for (int JobParameterValuesidx = JobParameterValuesStartIdx;
                                   JobParameterValuesidx < listOfJobParameterValues.size();
                                   JobParameterValuesidx++) {
                              
                                  Object _item_ = listOfJobParameterValues.get(JobParameterValuesidx);
                              
                                  // Type refinement: only proceed if element IS the requested subclass
                                  if (!(_item_ instanceof ParameterValue)) {
                                      continue;
                                  }
                                  ParameterValue ParameterValueJobParameterValuesElem = (ParameterValue) _item_;
              
                     
                              
              
                              int blockCounter = 0;
                              //ind += 1 ;
              
                               if (!(JobParameterValuesMatchedIdx.contains(JobParameterValuesidx)))  { 
                              
              
                              
                                  
                                          EStructuralFeature _ef_ = ParameterValueJobParameterValuesElem.eClass().getEStructuralFeature("name");
                                          Object _ev_ = (_ef_ != null) ? ParameterValueJobParameterValuesElem.eGet(_ef_) : null;
                                          if (_ev_ != null) {
                                              String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                              if ("runs-on".equals(_lit_)) {
                                                  blockCounter += 1;
                                              }
                                          }
                                  
                                  
              
                              if (blockCounter == 1) {
                                  matchedBlocks++;
                                       JobParameterValuesMatchedIdx.add(JobParameterValuesidx);
                                  
               break; 
                                      }                        
                                  }
                              }
                           } 
              
                           {
                              //int ind =0;
              
                              
                              
                                  int JobParameterValuesStartIdx = 0;
              
              
                                  // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                              EStructuralFeature _feat_JobParameterValues =
                                  classElem.eClass().getEStructuralFeature("JobParameterValues");
                              if (_feat_JobParameterValues == null) return false;
                              
                              Object _raw_JobParameterValues = classElem.eGet(_feat_JobParameterValues);
                              if (!(_raw_JobParameterValues instanceof EList<?>)) return false;
                              
                              EList<?> listOfJobParameterValues = (EList<?>) _raw_JobParameterValues;
                              
                              for (int JobParameterValuesidx = JobParameterValuesStartIdx;
                                   JobParameterValuesidx < listOfJobParameterValues.size();
                                   JobParameterValuesidx++) {
                              
                                  Object _item_ = listOfJobParameterValues.get(JobParameterValuesidx);
                              
                                  // Type refinement: only proceed if element IS the requested subclass
                                  if (!(_item_ instanceof ParameterValue)) {
                                      continue;
                                  }
                                  ParameterValue ParameterValueJobParameterValuesElem = (ParameterValue) _item_;
              
                     
                              
              
                              int blockCounter = 0;
                              //ind += 1 ;
              
                               if (!(JobParameterValuesMatchedIdx.contains(JobParameterValuesidx)))  { 
                              
              
                              
                                  
                                          EStructuralFeature _ef_ = ParameterValueJobParameterValuesElem.eClass().getEStructuralFeature("name");
                                          Object _ev_ = (_ef_ != null) ? ParameterValueJobParameterValuesElem.eGet(_ef_) : null;
                                          if (_ev_ != null) {
                                              String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                              if ("name".equals(_lit_)) {
                                                  blockCounter += 1;
                                              }
                                          }
                                  
                                  
              
                              if (blockCounter == 1) {
                                  matchedBlocks++;
                                       JobParameterValuesMatchedIdx.add(JobParameterValuesidx);
                                  
               break; 
                                      }                        
                                  }
                              }
                           } 
              
                           {
                              //int ind =0;
              
                              
                              
                                  int JobParameterValuesStartIdx = 0;
              
              
                                  // Reflective access: supports any metamodel & feature type (fix for, Step -> Action generalization)
                              EStructuralFeature _feat_JobParameterValues =
                                  classElem.eClass().getEStructuralFeature("JobParameterValues");
                              if (_feat_JobParameterValues == null) return false;
                              
                              Object _raw_JobParameterValues = classElem.eGet(_feat_JobParameterValues);
                              if (!(_raw_JobParameterValues instanceof EList<?>)) return false;
                              
                              EList<?> listOfJobParameterValues = (EList<?>) _raw_JobParameterValues;
                              
                              for (int JobParameterValuesidx = JobParameterValuesStartIdx;
                                   JobParameterValuesidx < listOfJobParameterValues.size();
                                   JobParameterValuesidx++) {
                              
                                  Object _item_ = listOfJobParameterValues.get(JobParameterValuesidx);
                              
                                  // Type refinement: only proceed if element IS the requested subclass
                                  if (!(_item_ instanceof ParameterValue)) {
                                      continue;
                                  }
                                  ParameterValue ParameterValueJobParameterValuesElem = (ParameterValue) _item_;
              
                     
                              
              
                              int blockCounter = 0;
                              //ind += 1 ;
              
                               if (!(JobParameterValuesMatchedIdx.contains(JobParameterValuesidx)))  { 
                              
              
                              
                                  
                                          EStructuralFeature _ef_ = ParameterValueJobParameterValuesElem.eClass().getEStructuralFeature("name");
                                          Object _ev_ = (_ef_ != null) ? ParameterValueJobParameterValuesElem.eGet(_ef_) : null;
                                          if (_ev_ != null) {
                                              String _lit_ = (_ev_ instanceof org.eclipse.emf.common.util.Enumerator) ? ((org.eclipse.emf.common.util.Enumerator)_ev_).getLiteral() : String.valueOf(_ev_);
                                              if ("if".equals(_lit_)) {
                                                  blockCounter += 1;
                                              }
                                          }
                                  
                                  
              
                              if (blockCounter == 1) {
                                  matchedBlocks++;
                                       JobParameterValuesMatchedIdx.add(JobParameterValuesidx);
                                  
               break; 
                                      }                        
                                  }
                              }
                           } 
              
                      
                      if (matchedBlocks == 3) {
                          hasJobParameterValues = true;
                          
                      }
                  
              
                  return hasJobParameterValues; 
              
              }
               
                       
  
  
  
              //template protected generateRelationMethods(rel : Relation, className : String)]
              //Relation: steps
              private static boolean matchesStepSteps_1_1(Job classElem ) {
                  boolean hassteps = false;
                  
                  
                          // --- presence only relation (like Steps etc) ---
                          if (classElem.getSteps() != null && !(classElem.getSteps().isEmpty())) {
                          hassteps = true;
                          }
                      return hassteps;
              
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


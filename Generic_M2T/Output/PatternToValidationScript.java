package ca.mcgill.devops.pipeline.resourceloader;

import org.eclipse.emf.ecore.EObject;
import java.util.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import com.google.inject.Injector;
import ca.mcgill.devops.pipeline.*;

public class PatternToValidationScript {

    private static int matchCount = 0; // For reporting matches

    public static boolean matchesPattern(Object root) {
        if (!(root instanceof EObject)) return false;
        EObject eo = (EObject) root;
        boolean result = false;
            result = result || matchRootClass_Pipeline(eo);
        return result;
    }

    private static boolean matchRootClass_Pipeline(EObject eo) {
        // Check correct metaclass
        if (!eo.eClass().getName().equals("Pipeline")) return false;
        Pipeline rootObj = (Pipeline) eo;

        if (!matchRelation_Jobjobs(rootObj)) return false;

        matchCount++;
        return true;
    }

    private static boolean matchRelation_Jobjobs(Job parentObj) {
        if (parentObj == null) return false;
        // Fetch the list via getter
        java.util.List<Job> children = parentObj.getjobs();
        if (children == null || children.isEmpty()) return false;

        for (Job child : children) {
            boolean allMatched = true;

            // Attribute “name” presence
            if (child.getname() == null) {
                allMatched = false;
            }
            if (!allMatched) continue;

            // Nested Relation “ParameterValue” via “jobParameterValues”
            if (!matchRelation_ParameterValuejobParameterValues(child)) {
                allMatched = false;
            }
            if (!allMatched) continue;

            // Nested Relation “Step” via “steps”
            if (!matchRelation_Stepsteps(child)) {
                allMatched = false;
            }
            if (!allMatched) continue;

            if (allMatched) {
                matchCount++;
                return true;
            }
        }
        return false;
    }
    private static boolean matchRelation_ParameterValuejobParameterValues(ParameterValue parentObj) {
        if (parentObj == null) return false;
        // Fetch the list via getter
        java.util.List<ParameterValue> children = parentObj.getjobParameterValues();
        if (children == null || children.isEmpty()) return false;

        for (ParameterValue child : children) {
            boolean allMatched = true;

            // Enumeration “name” match literal if provided, else presence
            {
                boolean foundEnum = false;
                PipelineKeyword enumVal = child.getname();
                if (enumVal != null) {
                    if (enumVal.toString().equals("runs-on")) {
                        foundEnum = true;
                    }
                }
                if (!foundEnum) allMatched = false;
            }
            if (!allMatched) continue;

            // Attribute “dependKW” presence
            if (child.getdependKW() == null) {
                allMatched = false;
            }
            if (!allMatched) continue;

            // Enumeration “name” match literal if provided, else presence
            {
                boolean foundEnum = false;
                PipelineKeyword enumVal = child.getname();
                if (enumVal != null) {
                    if (enumVal.toString().equals("name")) {
                        foundEnum = true;
                    }
                }
                if (!foundEnum) allMatched = false;
            }
            if (!allMatched) continue;

            // Enumeration “name” match literal if provided, else presence
            {
                boolean foundEnum = false;
                PipelineKeyword enumVal = child.getname();
                if (enumVal != null) {
                    if (enumVal.toString().equals("if")) {
                        foundEnum = true;
                    }
                }
                if (!foundEnum) allMatched = false;
            }
            if (!allMatched) continue;

            if (allMatched) {
                matchCount++;
                return true;
            }
        }
        return false;
    }
    private static boolean matchRelation_Stepsteps(Step parentObj) {
        if (parentObj == null) return false;
        // Fetch the list via getter
        java.util.List<Step> children = parentObj.getsteps();
        if (children == null || children.isEmpty()) return false;

        for (Step child : children) {
            boolean allMatched = true;


            if (allMatched) {
                matchCount++;
                return true;
            }
        }
        return false;
    }

    // === Resource Loading ===
    public static EObject resourceLoad(String resourcePath, String fileName) {
        try {
            Injector injector = new ca.mcgill.devops.pipeline.PipelineStandaloneSetup().createInjectorAndDoEMFRegistration();
            XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

            String inputURI = "file://" + resourcePath + "/" + fileName;
            URI uri = URI.createURI(inputURI);
            Resource xtextResource = resourceSet.getResource(uri, true);

            IResourceValidator validator = injector.getInstance(IResourceValidator.class);
            Iterable<Issue> issues = validator.validate(xtextResource, CheckMode.ALL, CancelIndicator.NullImpl);
            int issueCount = printValidationIssues(issues);
            EcoreUtil.resolveAll(xtextResource);

            if (issueCount == 0 && !xtextResource.getContents().isEmpty()) {
                return (EObject) xtextResource.getContents().get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error loading file \"" + fileName + "\": " + e.getMessage());
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
        String datasetPath = "/Users/ankita/Desktop/V3_DatasetTest";
        String fileExtension = ".Pipeline";
        String outputNonMatching = "/Users/ankita/Desktop/V2- devops dialect editor/non_matching_files_all_files.txt";
        String outputInvalid = "/Users/ankita/Desktop/V2- devops dialect editor/invalid_files_all_files.txt";
        String outputMatching = "/Users/ankita/Desktop/V2- devops dialect editor/Patternmatching_files_all_files.txt";

        File datasetFolder = new File(datasetPath);
        File[] allFiles = datasetFolder.listFiles();
        if (allFiles == null || allFiles.length == 0) {
            System.out.println("No files found in the dataset.");
            return;
        }

        java.util.List<File> filesToCheck = new java.util.ArrayList<>();
        for (File file : allFiles) {
            if (file.getName().endsWith(fileExtension)) {
                filesToCheck.add(file);
            }
        }
        if (filesToCheck.isEmpty()) {
            System.out.println("No files with extension " + fileExtension + " found.");
            return;
        }

        int validatedCount = 0;
        int matchingCount = 0;
        java.util.List<String> matches = new java.util.ArrayList<>();
        java.util.List<String> nonMatches = new java.util.ArrayList<>();
        java.util.List<String> invalids = new java.util.ArrayList<>();

        System.out.println("Processing up to " + filesToCheck.size() + " files...");
        for (File file : filesToCheck) {
            String name = file.getName();
            EObject modelRoot = resourceLoad(datasetPath, name);
            if (modelRoot == null) {
                invalids.add(name);
                continue;
            }
            validatedCount++;
            boolean found = matchesPattern(modelRoot);
            if (found) {
                matchingCount++;
                matches.add(name);
            } else {
                nonMatches.add(name);
            }
        }

        System.out.println("\n=== Validation Results ===");
        System.out.println("Total files examined: " + allFiles.length);
        System.out.println("Successfully validated: " + validatedCount);
        System.out.println("Files matching pattern: " + matchingCount);
        double pct = validatedCount > 0 ? ((double) matchingCount / validatedCount) * 100 : 0;
        System.out.println("Percentage matching: " + pct + "%");

        try {
            Files.write(Paths.get(outputMatching), matches);
            System.out.println("Matching filenames saved to " + outputMatching);
        } catch (IOException e) {
            System.err.println("Error writing matching list: " + e.getMessage());
        }
        try {
            Files.write(Paths.get(outputNonMatching), nonMatches);
            System.out.println("Non-matching filenames saved to " + outputNonMatching);
        } catch (IOException e) {
            System.err.println("Error writing non-matching list: " + e.getMessage());
        }
        try {
            Files.write(Paths.get(outputInvalid), invalids);
            System.out.println("Invalid filenames saved to " + outputInvalid);
        } catch (IOException e) {
            System.err.println("Error writing invalid list: " + e.getMessage());
        }
    }
}

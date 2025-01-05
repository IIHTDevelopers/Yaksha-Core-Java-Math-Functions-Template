package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

    // Test for Math Operations
	public boolean testMathOperations(String filePath) throws IOException {
        System.out.println("Starting testMathOperations with file: " + filePath);

        // Load participant's file
        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        // Parse the file using JavaParser
        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        // Flag to check for math-related operations
        boolean hasMathOperations = false;

        // 1. Checking if any math-related methods (e.g., abs, max, min, sqrt, pow, sin, log) are used
        System.out.println("------ Checking Math Operations ------");
        for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
            String methodName = method.getNameAsString();
            if (methodName.matches("abs|max|min|sqrt|pow|sin|log")) {
                hasMathOperations = true;
                System.out.println("✓ Found math operation: " + methodName);
            }
        }

        // Output the result for math operations
        if (hasMathOperations) {
            System.out.println("✓ Math operations are present.");
        } else {
            System.out.println("✘ Missing math operations.");
        }

        // Test result
        System.out.println("Test result: " + hasMathOperations);
        return hasMathOperations;
    }
}

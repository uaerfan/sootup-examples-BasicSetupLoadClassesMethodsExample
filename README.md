# sootup-examples-BasicSetupLoadClassesMethodsExample

Practice 01: Load Classes and Methods 
Clone the project, compile, and execute the program.
or manually create and analyse the program in the following steps.

GitHub Repository: 
https://github.com/uaerfan/sootup-examples-BasicSetupLoadClassesMethodsExample.git 

Objective 

In this practice exercise, we analyze the compiled target program and extract: 

All loaded classes 

All methods within each class 

Their method signatures 

This demonstrates how SootUp’s JavaView provides access to program structure. 

 

Step 01: Create the File 

Create the following file: 

Src/main/java/edu/ua/programanalysis/LoadClasses.java 

Step 02: Add the Source Code 

package edu.ua.programanalysis; 

  

import sootup.core.inputlocation.AnalysisInputLocation; 

import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation; 

import sootup.java.core.JavaProject; 

import sootup.java.core.language.JavaLanguage; 

import sootup.java.core.views.JavaView; 

  

public class LoadClasses { 

  

    public static void main(String[] args) { 

  

        AnalysisInputLocation inputLocation = 

            new JavaClassPathAnalysisInputLocation("target/classes"); 

  

        JavaProject project = JavaProject.builder(new JavaLanguage(17)) 

            .addInputLocation(inputLocation) 

            .build(); 

  

        JavaView view = project.createView(); 

  

        // Print all loaded classes 

        view.getClasses().forEach(c -> 

            System.out.println("Loaded class: " + c)); 

  

        // For each class, print all methods 

        view.getClasses().forEach(c -> { 

            System.out.println("\nClass: " + c.getName()); 

  

            c.getMethods().forEach(m -> 

                System.out.println("   Method: " + m.getSignature()) 

            ); 

        }); 

    } 

} 

 

Step 03: Compile the Program  

mvn compile 

Step 04: Execute the Program 

mvn exec:java -Dexec.mainClass="edu.ua.programanalysis.LoadClasses" 

 

What This Program Does 

Loads all compiled .class files from target/classes 

Retrieves all classes via view.getClasses() 

Iterates through each class 

Extracts all method signatures 

You’ll get all compiled classes from target/classes (i.e., everything produced by mvn compile). If your project contains more .class files/packages (including inner classes like App$1.class), you will see more entries in the output. 

Example Output 

All Classes 

Loaded class: edu.ua.programanalysis.App 

Loaded class: edu.ua.programanalysis.LoadClasses 

Loaded class: demo.TargetProgram 

Step 5: For each class, list all methods (signatures) 

Iterate Over Classes and Methods 

c.getMethods().forEach(m -> System.out.println(m.getSignature())); 

Example Output 

Class: edu.ua.programanalysis.LoadClasses 

   Method: <edu.ua.programanalysis.LoadClasses: void lambda$0(sootup.java.core.JavaSootClass)> 

   Method: <edu.ua.programanalysis.LoadClasses: void lambda$2(sootup.java.core.JavaSootMethod)> 

   Method: <edu.ua.programanalysis.LoadClasses: void <init>()> 

   Method: <edu.ua.programanalysis.LoadClasses: void lambda$1(sootup.java.core.JavaSootClass)> 

   Method: <edu.ua.programanalysis.LoadClasses: void main(java.lang.String[])> 

Class: demo.TargetProgram 

   Method: <demo.TargetProgram: void main(java.lang.String[])> 

   Method: <demo.TargetProgram: int add(int,int)> 

   Method: <demo.TargetProgram: void <init>()> 

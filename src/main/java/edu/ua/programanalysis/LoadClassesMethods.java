package edu.ua.programanalysis;

import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.language.JavaLanguage;
import sootup.java.core.views.JavaView;

public class LoadClassesMethods {

    public static void main(String[] args) {

        AnalysisInputLocation inputLocation
                = new JavaClassPathAnalysisInputLocation("target/classes");

        JavaProject project = JavaProject.builder(new JavaLanguage(17))
                .addInputLocation(inputLocation)
                .build();

        JavaView view = project.createView();

        System.out.println("All Classes\n");
        view.getClasses().forEach(c
                -> System.out.println("Class: " + c));

        System.out.println("\nClasses and Methods\n");
        view.getClasses().forEach(c -> {
            System.out.println("Class: " + c.getName());

            c.getMethods().forEach(m
                    -> System.out.println("   Method: " + m.getSignature())
            );
        });

    }

}

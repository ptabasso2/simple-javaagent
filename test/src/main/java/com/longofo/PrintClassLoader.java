package com.longofo;


import com.sun.source.util.SimpleTreeVisitor;
import java.sql.BatchUpdateException;

import java.sql.Date;
import java.util.ArrayList;

import static java.util.Objects.isNull;

public class PrintClassLoader {

    public static void main(String[] args) {
        ModuleLayer layer = ModuleLayer.boot();
          layer.modules().forEach(module -> {
            ClassLoader classLoader = module.getClassLoader();
            String classLoaderName = isNull(classLoader) ? "bootstrap" : classLoader.getName();
            System.out.println(classLoaderName + ": " + module.getName());
        });
    }


    /*public static void main(String[] args) {
        PrintClassLoader demoObject = new PrintClassLoader();
        ClassLoader applicationClassLoader = demoObject.getClass().getClassLoader();
        printClassLoaderDetails(applicationClassLoader);

        // java.sql classes are loaded by platform classloader
        java.sql.Date now = new Date(System.currentTimeMillis());
        ClassLoader platformClassLoder = now.getClass().getClassLoader();
        printClassLoaderDetails(platformClassLoder);

        // java.lang classes are loaded by bootstrap classloader
        ClassLoader bootstrapClassLoder = args.getClass().getClassLoader();
        printClassLoaderDetails(bootstrapClassLoder);
    }
    private static void printClassLoaderDetails(ClassLoader classLoader){
        // bootstrap classloader is represented by null in JVM
        if(classLoader != null) {
            System.out.println("ClassLoader name : " + classLoader.getName());
            System.out.println("ClassLoader class : " + classLoader.getClass().getName());
        }else {
            System.out.println("Bootstrap classloader");
        }
    }
*/


    /*public void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:" + PrintClassLoader.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
        System.out.println("Classloader of BatchUpdateExecution:" + BatchUpdateException.class.getClassLoader());

    }


    public static void main(String[] args) throws ClassNotFoundException {
        new PrintClassLoader().printClassLoaders();
    }*/
}
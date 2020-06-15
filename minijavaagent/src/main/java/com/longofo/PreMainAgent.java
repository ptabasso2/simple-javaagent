package com.longofo;


import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.sql.SQLOutput;
import java.util.Arrays;

import static java.util.Objects.isNull;

public class PreMainAgent {
    static {
        System.out.println("PreMainAgent class static block run...");
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("PreMainAgent agentArgs : " + agentArgs);
        Class<?>[] cLasses = inst.getAllLoadedClasses();


        /*Arrays.stream(cLasses).filter(s -> s.getName()
                .startsWith("java.sql"))
                .forEach(s -> {
                    //System.out.println("Class loaded: "+ s.getName() + " -=- ClassLoader: " + s.getClassLoader().getName());
                    System.out.println("Class loaded: "+ s.getName());
                });*/


        for (Class<?> cls : cLasses) {
            if ( !cls.getName().startsWith("java.")
                    && !cls.getName().startsWith("javax.")
                    && !cls.getName().startsWith("sun.")
                    && !cls.getName().startsWith("java/")
                    && !cls.getName().startsWith("[")
                    && !cls.getName().startsWith("jdk")
            ){
                //System.out.println("PreMainAgent get loaded class: " + cls.getName());
                //System.out.println("PreMainAgent get classloader: " + cls.getClassLoader());
                String classLoaderName = isNull(cls.getClassLoader()) ? "bootstrap" : String.valueOf(cls.getClassLoader());
                System.out.println("PreMainAgent get loaded class: " + cls.getName() + " classloader: " + classLoaderName);

            }
        }

        //inst.addTransformer(new DefineTransformer(), true);
    }

    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("PreMainAgent transform Class:" + className);
            return classfileBuffer;
        }
    }
}

package org.example;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Analyzer {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Usage: java Analyzer");
            return;
        }

        String className = args[0];
        try{
            Class<?> clazz = Class.forName(className);

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods of class " + className + ":");
            for (Method method : methods){
                System.out.println(method);

                if(method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers()) &&
                method.getParameterCount() == 0){
                    System.out.println("Invoking test method: "+ method.getName());
                    method.invoke(null);
                }
            }

        }catch (ClassNotFoundException e){
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        }catch (Exception e){
            System.err.println("An error occured while analyzing the class: ");
            e.printStackTrace();
        }

    }
}

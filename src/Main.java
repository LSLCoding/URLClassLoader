import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) throws ClassNotFoundException, MalformedURLException {
        //Put file path here ex: C:\\Folder\\Folder2\\Jar.jar
        File file  = new File("");

        URI uri = file.toURI();
        URL[] urls = new URL[]{uri.toURL()};

        ClassLoader classLoader = new URLClassLoader(urls);

        /*
        Load the class and then print the information
        EX: printInformation(classLoader.loadClass("com.example.project.Class"));
         */
    }

    public static void printInformation(Class c) {
        System.out.println("Class Name: " + c.getName() + " Class Simple Name: " + c.getSimpleName());
        System.out.println("Super class: " + c.getSuperclass());

        System.out.println(" ");

        for(Annotation a : c.getAnnotations()) {
            System.out.println("Annotation: " + a.toString() + " Type: " + a.annotationType());
        }

        System.out.println(" ");

        for(Method m : c.getMethods()) {
            System.out.println("Method: " + m.getName() + " Return Type: " + m.getReturnType());
        }

        System.out.println(" ");

        for (Field f : c.getDeclaredFields()) {
            System.out.println("Field name " + f.getName() + " Type: " + f.getType());
        }

        System.out.println(" ");
    }
}

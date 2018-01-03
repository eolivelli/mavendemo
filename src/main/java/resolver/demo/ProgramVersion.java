/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolver.demo;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

/**
 *
 * @author eolivelli
 */
public class ProgramVersion implements AutoCloseable {

    private ProgramVersion(URLClassLoader cl) {
        this.classloader = cl;
    }

    private final URLClassLoader classloader;

    public static ProgramVersion resolve(String mainArtifact) throws Exception {
        File[] files = Maven.resolver().resolve(mainArtifact)
                .withTransitivity().asFile();
        URL[] urls = new URL[files.length];
        int i = 0;
        for (File f : files) {
            urls[i++] = f.toURI().toURL();
        }
        for (File f : files) {
            System.out.println("dep for "+mainArtifact+": " + f);
        }
        URLClassLoader cl = new URLClassLoader(urls);
        return new ProgramVersion(cl);
    }

    public Object newInstance(String className, Object... args) throws Exception {
        Class bookkeeper = Class.forName(className, true, classloader);
        Class[] paramTypes = new Class[args.length];
        int i = 0;
        for (Object o : args) {
            paramTypes[i] = args[i++].getClass();
        }
        return bookkeeper.getConstructor(paramTypes).newInstance(args);
    }

    public void close() throws Exception {
        classloader.close();
    }
}

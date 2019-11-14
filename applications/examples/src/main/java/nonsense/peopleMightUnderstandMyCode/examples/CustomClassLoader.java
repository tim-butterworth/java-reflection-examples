package nonsense.peopleMightUnderstandMyCode.examples;

import java.io.*;

public class CustomClassLoader extends ClassLoader {

    /*
    reference: https://www.baeldung.com/java-classloaders
     */
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = null;
        try {
            String[] split = fileName.split("\\.");
            String name = split[split.length - 1];
            inputStream = new FileInputStream(new File("/Users/swathimakkena/workspace/reflectionTalk/applications/forClassLoading/build/classes/java/main/where/classes/are/"+name+".class"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
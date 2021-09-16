package demo.jvm0914;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @author SimonZhang 2021-09-16
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class helloc = new HelloClassLoader().findClass("Hello");
            Method hello = helloc.getDeclaredMethod("hello");
            hello.invoke(helloc.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = generatebyte("./src/demo/jvm0914/Hello.xlass");
        return defineClass(name, bytes,0,bytes.length);
    }

    private static byte[] generatebyte(String path) {
        File file = new File(path);
        long fileSize = file.length();
        byte[] buffer = new byte[(int) fileSize];
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return buffer;
        }

        try {
            FileInputStream fi = new FileInputStream(file);
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
            fi.close();

            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = (byte)(255 - buffer[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}

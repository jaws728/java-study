package java9;

import java.io.*;

public class InputStreamNew {
    public static void main(String[] args) {
        TestInputStream stream = new TestInputStream();
        stream.methodInputStream();
    }
}

class TestInputStream {
    public void methodInputStream(){
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream inputStream = cl.getResourceAsStream("test.txt");
             OutputStream outputStream = new FileOutputStream("src/java9/out.txt")) {
            inputStream.transferTo(outputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package java9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tryNew {
    public static void main(String[] args) {
        // JDK8: 原本需要在finally中关闭资源，而现则可在()中声明执行完后自动关闭
        try (InputStreamReader reader = new InputStreamReader(System.in)){
            char[] buf = new char[20];
            int len;
            if ((len = reader.read(buf)) != -1) {
                String s = new String(buf, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //JDK9：可在外部创建资源 - 内部不可以改，只能用
        InputStreamReader streamReader = new InputStreamReader(System.in);
        try (streamReader) {
            char[] buf = new char[20];
            int len;
            if ((len = streamReader.read(buf)) != -1) {
                String s = new String(buf, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

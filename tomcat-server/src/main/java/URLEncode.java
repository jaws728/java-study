import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "张三";

        String encode = URLEncoder.encode(name, "utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);
    }
}

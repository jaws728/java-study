import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> headers = new HashMap<>(3);
        String requestUrl = "\n" + "http://127.0.0.1:4523/m1/1149057-0-default/api/clients";
        String jsonStr = "{\"method\":\"enroll\",\"dengxin_id\":\"563\",\"wx_id\":\"pp\"}";
        headers.put("content-type", "application/json");
        // 发送post请求
        String resultData = HttpClientUtils.sendPostWithJson(requestUrl, jsonStr, headers);
        // 并接收返回结果
        System.out.println(resultData);
    }
}

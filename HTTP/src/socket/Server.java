package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server is running...");
        while (true){
            Socket s = ss.accept();
            System.out.println("connected from " + s.getRemoteSocketAddress());
            Thread t = new Handler(s);
            t.start();
        }
    }
}

class Handler extends Thread{
    Socket s;

    public Handler(Socket s){
        this.s = s;
    }

    public void run(){
        try (InputStream input = this.s.getInputStream()){
            try (OutputStream output = this.s.getOutputStream()) {
                handle(input, output);
            }
        } catch (IOException e) {
            try {
                this.s.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));

        // 读取HTTP请求
        boolean requestOK = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")){
            requestOK = true;
        }
        for (;;){
            String header = reader.readLine();
            if (header.isEmpty()){
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOK ? "Response OK" : "Response Error");
        if (!requestOK){
            // 发送错误响应
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        } else {
            // 发送成功请求
            // 读取html文件转换为字符串
            BufferedReader br = new BufferedReader(new FileReader("http/html/a.html"));
            StringBuilder data = new StringBuilder();
            String line = null;
            while((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();

            int len = data.toString().getBytes(StandardCharsets.UTF_8).length;

            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Connection: keep-alive\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + len +"\r\n");
            writer.write("\r\n");
            writer.write(data.toString());
            writer.flush();
        }
    }
}

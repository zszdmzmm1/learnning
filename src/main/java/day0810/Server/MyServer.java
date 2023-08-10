package day0810.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("服务器启动...");
            while (true) {
                Socket sock = ss.accept();
                System.out.println("接收到客户端链接：" + sock.getRemoteSocketAddress());
                Thread myThread = new MyHandler(sock);
                myThread.start();
            }
        }
    }
}

class MyHandler extends Thread {
    Socket sock;

    public MyHandler(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try (InputStream input = this.sock.getInputStream()) {
            try (OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        boolean requestOk = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestOk = true;
        }
        for (; ; ) {
            String header = reader.readLine();
            if (header.isEmpty()) { // 读取到空行时, HTTP Header 读取完毕
                break;
            }
            if(header.startsWith("User-Agent: ")){
                if(!header.equals("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")){
                    requestOk = false;
                }
            }
/*            if(header.startsWith("Sec-Ch-Ua-Platform: ")){
                if(header.equals("Sec-Ch-Ua-Platform: Windows")){
                    requestOk = false;
                }
            }*/
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");
        if (!requestOk) {
            // 发送错误响应:
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        } else {
            // 发送成功响应:
            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Connection: keep-alive\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: 152\r\n");
            writer.write("\r\n"); // 空行标识Header和Body的分隔
            writer.write("""
                    <!DOCTYPE html>
                    <html lang="zh">
                    <head>
                        <meta charset="UTF-8">
                        <title>Index</title>
                    </head>
                    <body>
                        <p>html from MyServer...</p>
                    </body>
                    </html>
                    """);
            writer.flush();
        }
    }
}
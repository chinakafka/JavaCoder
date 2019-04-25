package client;
import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPClient {
    public static void main(String[] args) {
        //确定http请求的uri
        String uri = "index.html";
        if (args.length != 0) {
            uri = args[0];
            doGet("localhost", 8080, uri);
        }
    }
        /*按照GET请求方式访问*/

        public static void doGet (String host,int port, String uri){

            Socket socket = null;

            //与sever建立TCP建立连接
            try {
                socket = new Socket(host, port);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                //创建HTTP请求
                StringBuffer sb = new StringBuffer("GET" + uri + "HTTP/1.1\r\n");//HTTP请求第一行
                //HTTP请求头2
                sb.append("accept:*/*\r\n");
                sb.append("accept-language:zh-cn\r\n");
                sb.append("accept-encoding:gzip,deflate\r\n");
                sb.append("user-agent:HTTPCLIENT\r\n");
                sb.append("Host:localhost:8080\r\n");
                sb.append("Connection:Keep-alive\r\n\r\n");

                /*发送HTTP请求*/
                OutputStream socketOut = socket.getOutputStream();//获得输出流
                socketOut.write(sb.toString().getBytes());

                //睡眠2秒，等待响应结果
                Thread.sleep(2000);

                /*接受响应结果*/
                InputStream socketIn = socket.getInputStream();//获得输入流
                int size = socketIn.available();
                byte[] buffer = new byte[size];
                socketIn.read(buffer);
                System.out.println(new String(buffer)); //打印响应结果

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } //#doGet()
    }


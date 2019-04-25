package server;
import java.io.*;
import java.net.*;
public class HTTPServer {
    //主方法
    public static void main(String[]args){
        //声明端口
        int port;
        //声明服务器端套接字
        ServerSocket serverSocket;

        //设置端口值
       try{
           port = Integer.parseInt(args[0]);
       }catch(Exception e){
           System.out.println("port=8080(默认)");
           port=8080; //默认端口值
       }

       //建立服务器与客户端的套接字连接
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("服务器正在监听端口："+serverSocket.getLocalPort());

            //服务器在一个无限循环中不断接受来自客户的TCP连接请求
            while(true){
                try{
                    //等待客户端的连接请求
                    final Socket socket=serverSocket.accept();
                    System.out.println("建立了与客户端的一个新的TCP连接,该客户的地址为："+socket.getInetAddress()+":"+socket.getPort());

                    //响应客户请求
                    service(socket);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //响应客户的HTTP请求

    public static void service(Socket socket)throws Exception{
        //读取HTTP请求
        //获得输入流
        InputStream socketIn = socket.getInputStream();
        //睡眠500毫秒，等待HTTP请求
        Thread.sleep(500);
        int size = socketIn.available();
        byte[]buffer=new byte[size];
        socketIn.read(buffer);
        String request=new String(buffer);
        System.out.println(request);

        /*解析HTTP请求*/

        //获得HTTP请求的第一行
        String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
        //解析HTTP请求的第一行
        String [] parts = firstLineOfRequest.split("");
        //获得HTTP请求中的uri
        String uri = parts[1];

        /*决定HTTP响应正文的类型，此处做了简化处理*/
        String contentType;
        if(uri.indexOf("html")!=-1||uri.indexOf("htm")!=-1){
            contentType="text/html";
        }else if(uri.indexOf("jpg")!=-1||uri.indexOf("jpeg")!=-1){
            contentType="image/jpeg";
        }else if(uri.indexOf("gif")!=-1){
            contentType="image/gif";
        }else {
            contentType = "application/cotet-stream"; //字节流
        }

        /*创建HTTP响应结果*/
        //HTTP响应第一行
        String responseFirstLine="HTTP/1.1 200 OK\r\n";
        //HTTP响应头
        String responseHeader="Content-type"+contentType+"\r\n\r\n";

        //获得读取响应正文数据的输入流
        InputStream in = HTTPServer.class.getResourceAsStream("root/"+uri);

        /*发送HTTP响应结果*/
        OutputStream socketOut = socket.getOutputStream(); //获得输出流
        //发送HTTP响应第一行
        socketOut.write(responseFirstLine.getBytes());
        //发送HTTP响应的头
        socketOut.write(responseHeader.getBytes());
        //发送HTTP响应正文
        int len = 0;
        buffer = new byte[128];
        while((len=in.read(buffer))!=-1){
            socketOut.write(buffer,0,len);
        }

        //睡眠1妙，等待客户接受HTTP响应结果
        Thread.sleep(1000);
        socket.close();
    }

}


package club.ajiajia.programming.socket.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private int port;

    private ServerSocket serverSocket;

    protected Socket socket;

    public Server(int port){
        this.port = port;
    }

    public void init(){
        try {
            this.serverSocket = new ServerSocket();
            this.serverSocket.bind(new InetSocketAddress(port));    //将port绑定bind
            System.out.println("Server初始化成功");

        } catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }

    // 等 client 来，坐着干等
    public void responce(){
        if (serverSocket == null){
            System.out.println("Server未初始化");
        }
        try {
            //三次握手 🤝
            socket = serverSocket.accept();
            System.out.println("连接建立成功");

            InputStream inputStream = socket.getInputStream(); // 把Client发过来的东西，读出来

            Scanner scanner = new Scanner(inputStream);// 这处理的就不是systerm.in 而是inputstream

            while(scanner.hasNextLine()){
                String data = scanner.nextLine();

                if(data.equals("close")){
                    break;
                }

                System.out.println("收到 买菜的人 说:" + data);
                data = data + "\n";

                // 给 client 回应
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Copy that!\n".getBytes()); // 转换成二进制的字节
            }

            // close 四次挥手 （防止内存泄露）
            socket.close();

        }catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server demoServer = new Server(8081);
        demoServer.init();
        demoServer.responce();

    }
}

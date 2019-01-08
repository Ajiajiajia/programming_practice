package club.ajiajia.programming.socket.Server;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
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
//        socket = new Socket();
        try {
//            socket.getRemoteSocketAddress();
            this.serverSocket = new ServerSocket();
            this.serverSocket.bind(new InetSocketAddress(port));    //将port绑定bind
            System.out.println("Server初始化成功");

        } catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }
    public void responce(){
        if (serverSocket == null){
            System.out.println("Server未初始化");
        }
        try {
            //三次握手 🤝
            socket = serverSocket.accept();
            System.out.println("连接建立成功");

            socket.getRemoteSocketAddress();


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
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket socket = null;
//        Server demoServer = new Server(8081);
//        demoServer.init();

        //记录client的数量
        int count = 0;
        System.out.println("***服务器即将启动，等待client的链接***");
        //循环监听等待client的链接
        while (true) {
            //调用accept()方法開始监听，等待client的链接
            socket = serverSocket.accept();
            //创建一个新的线程
            ServerThread serverThread = new ServerThread(socket);
            //启动线程
            serverThread.start();

            count++; //统计client的数量
            System.out.println("client的数量: " + count);
            InetAddress address = socket.getInetAddress();
            System.out.println("当前client的IP ： " + address.getHostAddress());
        }
        }catch (Exception e) {
        e.printStackTrace();
    }
    }
}
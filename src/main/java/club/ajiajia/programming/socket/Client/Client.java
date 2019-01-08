package club.ajiajia.programming.socket.Client;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Socket socket;


    public Socket getSocket(){
        return socket;
    }

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void init(){
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip,port));
            System.out.println("连接建立成功");
            }catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }

    public void say(String data){
        if (socket == null){
            System.out.println("连接不存在");
            return;
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            data = data + "\n";
            outputStream.write(data.getBytes());
        }catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }

    public void close(){
        if (socket == null){
            System.out.println("连接不存在");
        }
        try {
            socket.close();
        }catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Client demoClient = new Client("127.0.0.1",8081);
        demoClient.init();

        Runnable listenThread = new ListenThread(demoClient.getSocket());
        new Thread(listenThread).start();

        Scanner scanner = new Scanner(System.in);//scaner 处理的是命令行里面的输入
        while (scanner.hasNextLine()){
            String line = scanner.nextLine(); //每按一次回车，就把刚才输入的一行保存到Line中
            //判断发送结束
            if(line.equals("close")){
                break;
            }
            demoClient.say(line);
        }
        demoClient.close();

    }

}

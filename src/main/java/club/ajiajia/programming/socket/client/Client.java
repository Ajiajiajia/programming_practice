package club.ajiajia.programming.socket.client;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Client
 * @author ajiajia
 */
public class Client {
    /**
     * 要连接到的服务端ip
     * （变量名称要更有意义，能让人明白其意义）
     */
    private String serverIp;

    /**
     * 要连接到的服务端port
     */
    private int serverPort;

    /**
     * 与服务端间建立的连接
     */
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public Client(String serverIp, int serverPort) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void init() {
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(serverIp, serverPort));
            System.out.println("连接建立成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void say(String data) {
        if (socket == null) {
            System.out.println("连接不存在");
            return;
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            // 数据尾部增加换行符以标记结束
            data = data + "\n";
            outputStream.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (socket == null) {
            System.out.println("连接不存在");
        }
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client demoClient = new Client("127.0.0.1", 1119);
        // 初始化建立连接
        demoClient.init();
        // 启动监听线程
        Runnable listenThread = new ListenThread(demoClient.getSocket());
        new Thread(listenThread).start();

        //scanner 处理的是命令行里面的输入 (不要使用行尾注释，注释都在代码上方另起一行)
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            //每按一次回车，就把刚才输入的一行保存到Line中
            String line = scanner.nextLine();
            //判断发送结束
            if ("close".equals(line)) {
                break;
            }
            demoClient.say(line);
        }
        demoClient.close();
    }
}

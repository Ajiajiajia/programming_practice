package club.ajiajia.programming.socket.server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Socket Server
 * @author ajiajia
 */
public class Server {

    /**
     * 线程池
     * 创建一个固定大小的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中
     */
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(50);

    /**
     * 监听端口
     */
    private int port;

    /**
     * 服务socket
     */
    private ServerSocket serverSocket;

    /**
     * 当前连接的客户端数量
     */
    private int clientCnt;

    public Server(int port) {
        this.port = port;
        this.clientCnt = 0;
    }

    /**
     * 初始化服务端
     */
    public void init() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server初始化成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动服务端
     */
    public void launch() {
        if (serverSocket == null) {
            System.out.println("Server未初始化");
            return;
        }
        try {
            Socket socket;
            // 三次握手
            while ((socket = serverSocket.accept()) != null) {
                System.out.println("与客户端 " + socket.getRemoteSocketAddress() + " 成功建立连接");
                System.out.println("当前客户端连接数： " + (++clientCnt));

                // 使用线程池优化处理
                THREAD_POOL.submit(new ServerThread(socket));
                // 如果不用线程池，可以简单写成下面样子
                // new Thread(new ServerThread(socket)).start();
            }

        } catch (Exception e) {//开启线程进行监听
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(1119);
            server.init();
            server.launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
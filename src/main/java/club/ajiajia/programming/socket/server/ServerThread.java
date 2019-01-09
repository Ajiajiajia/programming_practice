package club.ajiajia.programming.socket.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        if (socket == null){
            System.out.println("连接出现异常");
        }
        try{
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("来自client的请求：" + line);

                // 这里不能关闭输入流，否则同一个client只能发送一次请求，就不能再写入了。
                // socket.shutdownInput();

                //获取输出流,响应client的请求
                OutputStream outputStream = socket.getOutputStream();
                // 转换成二进制的字节
                outputStream.write("Copy that!\n".getBytes());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

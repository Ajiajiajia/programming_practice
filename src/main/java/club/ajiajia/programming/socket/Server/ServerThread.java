package club.ajiajia.programming.socket.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run() {
        if (socket == null){
            System.out.println("连接出现异常");
        }
        try{
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("来自client的响应：" + line);

                socket.shutdownInput(); //关闭输入流

                //获取输出流。响应client的请求
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Copy that!\n".getBytes()); // 转换成二进制的字节

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

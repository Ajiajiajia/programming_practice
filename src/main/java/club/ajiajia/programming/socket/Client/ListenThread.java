package club.ajiajia.programming.socket.Client;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

//  用于 读取信息
public class ListenThread implements Runnable
{
    public  ListenThread(Socket socket){
        this.socket = socket;
    }

    private Socket socket;
    public void run() {
        if(socket == null){
            System.out.println("连接出现异常");
        }
        try{
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                System.out.println("来自商贩的响应：" + line);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

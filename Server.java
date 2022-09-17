import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        //this file is a server program

        try {
            System.out.println("server start....");
            while (true){
                ServerSocket serverSocket = new ServerSocket(0);
                System.out.println("port:"+serverSocket.getLocalPort());
                //
                Socket s = serverSocket.accept();


                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                System.out.println("----------");
                System.out.println("client:"+s.getInetAddress());
                for(String loop:br.lines().toList()){
                    System.out.println(loop);
                }

                System.out.println("----------");
                serverSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

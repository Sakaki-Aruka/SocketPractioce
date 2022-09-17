import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChannelClient {
    public static void main(String[] args){

        int server_port = new Scanner(System.in).nextInt();


        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",server_port));
            // about write buffered
            Socket socket = socketChannel.socket();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            while(true){
                if(scanner.hasNext("end")){
                    break;
                }
                bw.append(scanner.nextLine());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            socketChannel.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

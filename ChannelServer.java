import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class ChannelServer {
    public static void main(String[] args){
        while(true){
            try{
                ServerSocketChannel socketChannel = ServerSocketChannel.open();
                socketChannel.bind(new InetSocketAddress("127.0.0.1",0));
                System.out.println("server port:"+socketChannel.socket().getLocalPort());
                socketChannel.configureBlocking(false);

                Selector selector = SelectorProvider.provider().openSelector();
                socketChannel.register(selector, SelectionKey.OP_ACCEPT);

                SocketChannel socketChannel1 = socketChannel.accept();
                Socket socket = socketChannel1.socket();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("----------");
                System.out.println("client:"+socket.getInetAddress());
                for(String loop:br.lines().toList()){
                    System.out.println(loop);
                }

                System.out.println("----------");
                socketChannel.close();

            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        }


    }
}

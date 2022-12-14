import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        int server_port = new Scanner(System.in).nextInt();

        try {
            Socket s = new Socket("127.0.0.1",server_port);

            OutputStream os = s.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
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


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

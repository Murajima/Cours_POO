package Client_interfaceV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public Serveur() {
        try{
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur est en écoute....");
            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté !");

            PrintWriter sout = new PrintWriter(socket.getOutputStream(), true);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader sin = new BufferedReader(isr);

            while (true) {
                String texteClient = sin.readLine();
                if(texteClient.equals("quitte")){
                    sout.println("okQuitte");
                    break;
                }
                sout.println("j'ai bien reçu " + texteClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        new Serveur();
    }
}

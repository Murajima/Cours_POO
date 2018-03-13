package Client_interface;

import java.io.IOException;
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
            sout.println("Salut à tous !");
            System.out.println("Message envoyé au client");
            serverSocket.close();
            System.out.println("Fermeture de la connexion");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

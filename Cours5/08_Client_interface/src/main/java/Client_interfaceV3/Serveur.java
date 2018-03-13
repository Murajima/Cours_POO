package Client_interfaceV3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public Serveur() {
        //
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur est en écoute...");

            while(true) {
                // création d'un socket depuis une nouvelle connexion client
                Socket socket = serverSocket.accept();
                System.out.println("Un client est connecté !");
                new Thread(new ThreadServeur(socket)).start();
            }

        } catch (IOException e) {
            System.err.println("Serveur : " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new Serveur();
    }

}
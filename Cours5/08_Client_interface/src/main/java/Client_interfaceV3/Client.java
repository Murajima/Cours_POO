package Client_interfaceV3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("La connexion est effectuée...");

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader sin = new BufferedReader(isr);
            PrintWriter sout = new PrintWriter(socket.getOutputStream(), true);
            Scanner cin = new Scanner(System.in);

            System.out.println("On va commencer à discuter...");

            while(true) {
                System.out.print("Texte à envoyer au serveur : ");
                String texte = cin.nextLine();
                sout.println(texte);

                String reponse = sin.readLine();
                System.out.println("J'ai reçu du serveur '" + reponse + "'");

                if(reponse.equals("okQuitte"))
                    break;
            }
            socket.close();
        } catch (Exception e) {
            System.err.println("Client : "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}

package Client_interfaceV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(){
        try {
            Socket socket = new Socket("localhost", 1234);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader sin = new BufferedReader(isr);
            PrintWriter sout = new PrintWriter(socket.getOutputStream(), true);

            Scanner cin = new Scanner(System.in);

            while(true) {
                System.out.print("Texte à envoyer au serveur :");
                String texte = cin.nextLine();
                sout.println(texte);

                String reponse = sin.readLine();
                System.out.println("J'ai reçu du serveur '" + reponse + "'");

                if(reponse.equals("okQuitte")){
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        new Client();
    }
}

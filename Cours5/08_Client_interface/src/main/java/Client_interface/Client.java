package Client_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public Client(){
        try {
            Socket socket = new Socket("localhost", 1234);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader sin = new BufferedReader(isr);

            String texteServeur = sin.readLine();
            System.out.println("le serveur a envoyé '" + texteServeur + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        new Client();
    }
}

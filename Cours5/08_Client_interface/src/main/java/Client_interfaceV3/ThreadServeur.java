package Client_interfaceV3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServeur implements Runnable {
	private Socket m_socket;

	public ThreadServeur(Socket socket) {
		m_socket = socket;
	}

	public void run() {
		try {
		// mise en place du mécanisme d'écriture
		PrintWriter sout = new PrintWriter(m_socket.getOutputStream(), true);
		// mise en place du mécanisme de lecture
		InputStreamReader isr = new InputStreamReader(m_socket.getInputStream());
		BufferedReader sin = new BufferedReader(isr);

		// boucle infinie de discussion avec le client
		while(true) {
			// on reçoit un texte du client
			String texteClient = sin.readLine();
			if(texteClient.equals("quitte")) {
				sout.println("okQuitte");
				break;
			}
			sout.println("J'ai bien reçu " + texteClient);
		}

		m_socket.close();
		System.out.println("Fermeture de la connexion");
		} catch(Exception exc) {
			System.err.println("Thread serveur : " + exc.getMessage());
		}

	}

}

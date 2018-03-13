package Morpion;

import javax.swing.*;

public class ThreadEspion implements Runnable {

    private Appli m_appli;
    public ThreadEspion(Appli appli) {
        m_appli = appli;
    }

    public void run() {
        while (true) {
            try{ Thread.sleep(500); } catch (InterruptedException e) {}

            if(m_appli.getM_nbBoutons() == 4) {
                JOptionPane.showMessageDialog(m_appli, "Gagne !");
                System.exit(0);
            }

            System.out.println("Ecoute");
        }
    }
}

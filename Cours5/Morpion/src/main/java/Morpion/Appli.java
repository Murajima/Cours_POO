package Morpion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Hello world!
 *
 */
public class Appli extends JFrame implements ActionListener
{
    private final int TAILLE = 4;
    private int m_nbBoutons = 0;
    private JButton[][] m_boutons = new JButton[TAILLE][TAILLE];

    public Appli() {
        setSize(400, 400);
        JPanel panel = new JPanel(new GridLayout(TAILLE, TAILLE, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        for(int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++){
                m_boutons[i][j] = new JButton("0");
                m_boutons[i][j].addActionListener(this);
                panel.add(m_boutons[i][j]);
            }
        }
        this.add(panel);

        // On initialise notre Thread Runnable
        ThreadEspion espion = new ThreadEspion(this);

        // On encapsule notre Thread Runnable dans un Thread -> OBLIGATOIRE
        new Thread(espion).start();
    }

    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();
        if(temp.getText().equals("0")) {
            temp.setText("X");
            m_nbBoutons ++;
        } else {
            temp.setText("O");
            m_nbBoutons--;
        }
        setTitle(m_nbBoutons + "cliques");
    }

    public int getM_nbBoutons() {
        return m_nbBoutons;
    }
}
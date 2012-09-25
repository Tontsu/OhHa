/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ohha.TopLista;

/**
 *
 * @author Tontsu
 */
public class Voittodialogi extends JFrame {
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    TopLista lista = new TopLista();
    boolean tarkistus = false;
    String nimi;
    private JButton ok;
    private oknappihandleri okhandleri;
    private long aika;
    private JTextField teksti = new JTextField();
    private Container pane;
  
    
    public Voittodialogi(long suoritusaika) {
        
        aika = suoritusaika;
        setTitle("Muistipeli");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JLabel voitto = new JLabel("Voitit!");
        voitto.setFont(new Font("Arial", 0, 30));
        pane.add(voitto);
        pane.add(new JLabel("Aikaa kului: " + suoritusaika + " sekuntia"));
        
        tarkistus = lista.tarkista(suoritusaika);
         
         lista.tulosta();
        
        if (tarkistus == true) {
            pane.add(new JLabel("Pääsit listalle"));
            
            teksti.setEditable(true);
            pane.add(teksti);
            
            ok = new JButton("Ok");
            okhandleri = new oknappihandleri();
            ok.addActionListener(okhandleri);
            pane.add(ok);
            
            
        }
        else {
            pane.add(new JLabel("Et päässyt listalle"));
        }
        
    }
        private class oknappihandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           nimi = teksti.getText();
           lista.kirjaaja(nimi, aika);
           Lista listanakyma = new Lista();
           setVisible(false);
            
        }
    }
    
}

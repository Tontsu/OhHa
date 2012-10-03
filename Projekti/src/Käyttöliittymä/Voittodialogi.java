/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ohha.TopLista;

/*
 * Pelin kolmas näkymä, joka näytetään pelisuorituksen jälkeen.
 * Tämä näkymä näyttää peliin kulutetun ajan ja kertoo listalle pääsystä.
 * Tässä näkymässä annetaan myös nimi Top-listalle.
 */
public class Voittodialogi extends JFrame {
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    TopLista lista = new TopLista("top.txt");
    boolean tarkistus = false;
    String nimi;
    private JButton ok;
    
    private oknappihandleri okhandleri;
    private toinenoknappihandleri toinenhandleri;
    private long aika;
    private JTextField teksti = new JTextField();
    private Container pane;
  
    
    public Voittodialogi(long suoritusaika, int koko) {
        
        aika = suoritusaika;
        asetaAlkuarvot();
        

        asetaElementit();
        
        tarkistus = lista.tarkista(suoritusaika);
         
        lista.tulosta();
        
        if (tarkistus && koko > 36 ) {
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
            JButton okkee = new JButton("Ok");
            toinenhandleri = new toinenoknappihandleri();
            okkee.addActionListener(toinenhandleri);
            pane.add(okkee);
           
        }
        
    }
    
    private void asetaAlkuarvot() {
        setTitle("Muistipeli");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
}
    
   private void asetaElementit() {
        pane = getContentPane();        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JLabel voitto = new JLabel("Voitit!");
        voitto.setFont(new Font("Arial", 0, 30));
        pane.add(voitto);
        pane.add(new JLabel("Aikaa kului: " + aika + " sekuntia"));
       
   }
   
       private class toinenoknappihandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
          
           Listanakyma listanakyma = new Listanakyma(lista);
           setVisible(false);
            
        }
    }
   
        private class oknappihandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           nimi = teksti.getText();
           lista.kirjaaja(nimi, aika);
           Listanakyma listanakyma = new Listanakyma(lista);
           setVisible(false);
            
        }
    }
        
    
    
}

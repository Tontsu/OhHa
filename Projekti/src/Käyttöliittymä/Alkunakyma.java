/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Pelin ensimmäinen näkymä, josta valitaan pelilaudan koko.
 */
public class Alkunakyma extends JFrame {

    private static final int leveys = 400;
    private static final int korkeus = 100;
    private JButton pieni, keski, suuri;
    private JLabel valikkoteksti;
    private pieniNappiHandleri pieniHandleri;
    private keskiNappiHandleri keskiHandleri;
    private suuriNappiHandleri suuriHandleri;
    private Container pane;
   

    public Alkunakyma() {
   
        asetaAlkuarvot();

        luoNapit();

        valikkoteksti = new JLabel("Valitse koko");

        pane = getContentPane();
        
        pane.setLayout(new FlowLayout(20,20,20));
        
        pieni.setMaximumSize(new Dimension(50,50));
        keski.setMaximumSize(new Dimension(50,50));
        suuri.setMaximumSize(new Dimension(50,50));
        
        lisaaElementit();
        
    }    
    
    private void asetaAlkuarvot() {
        setTitle("Muistipeli");
        setSize(leveys, korkeus);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void luoNapit() {
        
        pieni = new JButton("pieni");
        pieniHandleri = new pieniNappiHandleri();
        pieni.addActionListener(pieniHandleri);
        keski = new JButton("keski");
        keskiHandleri = new keskiNappiHandleri();
        keski.addActionListener(keskiHandleri);
        suuri = new JButton("suuri");
        suuriHandleri = new suuriNappiHandleri();
        suuri.addActionListener(suuriHandleri);
        
        
    }
    
   private void lisaaElementit() {
        pane.add(valikkoteksti);
        pane.add(pieni);
        pane.add(keski);
        pane.add(suuri);
        
    }

    private class pieniNappiHandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Lautanakyma peli = new Lautanakyma(1);
                     
        }
    }
    private class keskiNappiHandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Lautanakyma peli = new Lautanakyma(2);
            
        }
    }
    private class suuriNappiHandleri implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Lautanakyma peli = new Lautanakyma(3);
                    
        }
    }
    
    public boolean getstatus() {
        return this.isVisible();
    }    

public static void main(String[] args) {
       Alkunakyma alku = new Alkunakyma();
       
}
}

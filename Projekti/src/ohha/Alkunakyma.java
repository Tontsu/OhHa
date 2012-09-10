/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Tontsu
 */
public class Alkunakyma extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 100;
    private JButton pieni, keski, suuri;
    private JLabel valikkoteksti;
    private pieniNappiHandleri pieniHandleri;
    private keskiNappiHandleri keskiHandleri;
    private suuriNappiHandleri suuriHandleri;
   

    public Alkunakyma() {
   
        
        setTitle("Muistipeli");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        pieni = new JButton("pieni");
        pieniHandleri = new pieniNappiHandleri();
        pieni.addActionListener(pieniHandleri);
        keski = new JButton("keski");
        keskiHandleri = new keskiNappiHandleri();
        keski.addActionListener(keskiHandleri);
        suuri = new JButton("suuri");
        suuriHandleri = new suuriNappiHandleri();
        suuri.addActionListener(suuriHandleri);
        valikkoteksti = new JLabel("Valitse koko");



        Container pane = getContentPane();
        

        pane.setLayout(new FlowLayout(20,20,20));
        
        pieni.setMaximumSize(new Dimension(50,50));
        keski.setMaximumSize(new Dimension(50,50));
        suuri.setMaximumSize(new Dimension(50,50));
        
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

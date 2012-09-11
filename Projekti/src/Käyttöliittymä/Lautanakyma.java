/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ohha.Lauta;
/**
 *
 * @author Tontsu
 */
public class Lautanakyma extends JFrame {
    int pikselit;  
    Lauta pelilauta;
    int laudankoko;
    
    public Lautanakyma(int koko) {
        alustaja(koko);
        setTitle("Muistipeli");
        setSize(pikselit, pikselit);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       laudankoko = pelilauta.getSivu();
        
        Container paneeli = getContentPane();
        paneeli.setLayout(new GridLayout(laudankoko, laudankoko));
        
           for(int i = 0; i < pelilauta.getKoko(); i++) {
            paneeli.add(new JButton("i: " + i));
        }
    }
    

    
    private void alustaja(int koko) {
        if (koko == 1) {
            pikselit = 300;
            pelilauta = new Lauta(2);
        }
        if(koko == 2) {
            pikselit = 500;
            pelilauta = new Lauta(4);
        }
        if(koko == 3) {
            pikselit = 700;
            pelilauta = new Lauta(6);
        }
    }
    
    
    
}

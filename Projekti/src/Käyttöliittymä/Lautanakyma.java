/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ohha.Lauta;
import ohha.Nappula;
import ohha.Siirtokontrolleri;
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
        Siirtokontrolleri kontrolleri = new Siirtokontrolleri(pelilauta, this);
        
           for(int i = 0; i < pelilauta.getSivu(); i++) {
               for(int j = 0; j < pelilauta.getSivu(); j++) {
                   paneeli.add(new Nappula(j, i, pelilauta, kontrolleri));
               }
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

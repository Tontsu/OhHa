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
public class Lautanakyma extends JFrame {
    int pikselit;  
    Lauta pelilauta;
    
    public Lautanakyma(int koko) {
        alustaja(koko);
        setTitle("Muistipeli");
        setSize(pikselit, pikselit);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void alustaja(int koko) {
        if (koko == 1) {
            pikselit = 300;
            Lauta pelilauta = new Lauta(2);
        }
        if(koko == 2) {
            pikselit = 500;
            Lauta pelilauta = new Lauta(4);
        }
        if(koko == 3) {
            pikselit = 700;
            Lauta pelilauta = new Lauta(6);
        }
    }
    
}

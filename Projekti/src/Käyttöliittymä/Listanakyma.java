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
 * Pelin viimeinen näkymä, joka näyttää Top-listan.
 */
public class Listanakyma extends JFrame {
    
    private static final int WIDTH = 450;
    private static final int HEIGHT = 450;
    
    private Container pane;
    
    public Listanakyma(TopLista lista) {
    
        setTitle("Muistipeli");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JTextArea tulokset = new JTextArea(lista.tulosta());
        tulokset.setEditable(false);
        tulokset.setBackground(Color.PINK);
        tulokset.setFont(new Font("Arial", 0, 30));
        pane.add(tulokset);
        
    }
}

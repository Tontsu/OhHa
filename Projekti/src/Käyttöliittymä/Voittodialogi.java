/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Tontsu
 */
public class Voittodialogi extends JFrame {
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    
  
    
    public Voittodialogi(long suoritusaika) {
        
        setTitle("Muistipeli");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JLabel voitto = new JLabel("Voitit!");
        voitto.setFont(new Font("Arial", 0, 30));
        pane.add(voitto);
        pane.add(new JLabel("Aikaa kului: " + suoritusaika + " sekuntia."));
        
    }
    
}

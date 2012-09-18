/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Tontsu
 */
public class Nappula extends JButton implements ActionListener{
    
    private final int y;
    private final int x;
    private final Lauta pelilauta;
    
    public Nappula(int x, int y, Lauta pelilauta) {
        //super("(" + x + ", " + y + ")"); 
        this.y = y;
        this.x = x; 
        this.pelilauta = pelilauta;
        this.addActionListener(this);
     
       
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    public int getArvo() {
        return pelilauta.koordinaattitarkastaja(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setBackground(Color.white);
        this.setText("" + this.getArvo() );
        
    }
    
}

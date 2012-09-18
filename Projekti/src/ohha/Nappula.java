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
    private final Siirtokontrolleri kontrolleri;
    
    public Nappula(int x, int y, Lauta pelilauta, Siirtokontrolleri kontrolleri) {
        //super("(" + x + ", " + y + ")"); 
        this.kontrolleri = kontrolleri;
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
       
        kontrolleri.setNappi(this);
        
        
        
        
    }

    public void piilota() {
        this.setBackground(null);
        this.setText("");
    }

    void kaanna() {
        this.setBackground(Color.white);
        this.setText("" + this.getArvo() );
    }
    
}

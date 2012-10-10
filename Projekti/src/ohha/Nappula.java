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
 * Pelilaudan nappulaluokka.
 * @author Tontsu
 */
public class Nappula extends JButton implements ActionListener{
    
    private final int y;
    private final int x;
    private final Lauta pelilauta;
    private final Siirtokontrolleri kontrolleri;
    private boolean kaannetty;
    private boolean poistettu;
    
    /**
     * Luo uuden käännettävän pelinappulan satunnaisella arvolla.
     * 
     * @param x Nappulan X-koordinaatti laudalla.
     * @param y Nappulan Y-koordinaatti laudalla.
     * @param pelilauta Lauta, josta luetaan tietoa.
     * @param kontrolleri Siirtojen hallitsija.
     */
    
    public Nappula(int x, int y, Lauta pelilauta, Siirtokontrolleri kontrolleri) {
        //super("(" + x + ", " + y + ")"); 
        this.kontrolleri = kontrolleri;
        this.y = y;
        this.x = x; 
        this.pelilauta = pelilauta;
        this.addActionListener(this);
        kaannetty = false;
        poistettu = false;
    }

    /**
     * Palauttaa nappulan Y-koordinaatin.
     * @return Y-koordinaatti.
     */
    public int getY() {
        return y;
    }

    /**
     * Palauttaa nappulan X-koordinaatin.
     * @return X-koordinaatti.
     */
    public int getX() {
        return x;
    }
    
    /**
     * palauttaa pelinappulan arvon.
     * @return Pelinappulan arvo.
     */
    public int getArvo() {
        return pelilauta.koordinaattitarkastaja(x, y);
    }

    /**
     * Antaa painetun nappulan toiminnon siirtokontrollerin hallittavaksi.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {        
        kontrolleri.setNappi(this);   
    }
    
    /**
     * Piilottaa uudestaan väärin arvatun nappulan.
     */

    public void piilota() {
        kaannetty = false;
        this.setBackground(null);
        this.setText("");
    }
    
    /**
     * Kääntää nappulan ympäri ja paljastaa nappulan arvon.
     */

    public void kaanna() {
        kaannetty = true;
        this.setBackground(Color.white);
        this.setText("" + this.getArvo() );
    }
    
    public void poista() {
        poistettu = true;
    }

    /**
     * Palauttaa nappulan tilan.
     * @return Palauttaa truen jos nappula on käännetty, muuten false.
     */
    boolean onKaannetty() {
        return kaannetty;
    }
    boolean onPoistettu() {
        return poistettu;
        
    }
    
}

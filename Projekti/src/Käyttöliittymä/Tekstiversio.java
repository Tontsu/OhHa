/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.util.*;
import ohha.Lauta;

/**
 *
 * @author Tontsu
 */
public class Tekstiversio {

    static Scanner lukija = new Scanner(System.in);
    
    public static void main(String[] args) {
        int koko;
        
        while (true) {
            System.out.println("Syötä koko väliltä 1-3");
            
            koko = lukija.nextInt();
            
            if (koko >= 1 && koko <= 3) {
                break;
            }
            
            System.out.println("Virheellinen koko");
            
        }
        Lauta pelilauta = new Lauta(koko*2);
    }
}
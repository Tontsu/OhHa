/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import java.io.*;
import java.util.*;

/**
 *
 * @author Tontsu
 */
public class TopLista {

    String tiedostonimi;
    File tiedosto;
    Scanner lukija = null;
    FileWriter kirjoittaja = null;
    
    ArrayList<Long> ajat = new ArrayList<Long>();
    ArrayList<String> nimet = new ArrayList<String>();

   /**
    * Luo uuden Top-10-listan.
    * @param tiedostonimi Listalle annettava tiedosto, josta luetaan ja johon tallennetaan tiedot.
    */ 
    public TopLista(String tiedostonimi) {
        this.tiedostonimi = tiedostonimi;
        tiedosto = new File(tiedostonimi);
        lukutiedostonTarkistus();
        
    }
/**
 * Tarkistaa listasta, pääseekö annettu aika listalle.
 * @param aika Tarkistettava aika.
 * @return Palauttaa truen, jos aika pääsee listalle, muuten false.
 */
    public boolean tarkista(long aika) {
        
        //lukutiedostonTarkistus();
        luoListat();
        
        if(ajat.get(9) > aika) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean lukutiedostonTarkistus() {
         try {
            lukija = new Scanner(tiedosto);
            return true;
        } catch (Exception e) {
             System.out.println("Tiedostoa ei löydy");
             return false;
        }
    }
    
    private void luoListat() {
        int rivinumero = 1;
       
        while (lukija.hasNextLine()) {
            if (rivinumero % 2 == 1) {
                String rivi = lukija.nextLine();
                long apu = Long.parseLong(rivi);
                ajat.add(apu);
            }
            if (rivinumero % 2 == 0) {
                nimet.add(lukija.nextLine());
            }
            rivinumero++;
        }
        lukija.close();
    }
    
    private void lisaaUusiTulos(String nimi, long aika) {
        int indeksi = -1;
        for (int i = 0; i < 10; i++) {
            long apu = ajat.get(i);
            if (aika <= apu) {
                indeksi = i;
                break;
            }
        }

        ajat.add(indeksi, aika);
        nimet.add(indeksi, nimi);
        ajat.remove(10);
        nimet.remove(10);
    }
    
    private void kirjoitustiedostonLuonti() {
         try {
            kirjoittaja = new FileWriter(tiedosto);
            
        } catch (Exception e) {
            System.out.println("Tiedostoa ei löydy");
            
        }
    }
    
    /**
     * Kirjaa uuden tuloksen listaan.
     * @param nimi Uuden tuloksen nimi.
     * @param aika Uuden tuloksen aika.
     */

    public void kirjaaja(String nimi, long aika) {

        //lukutiedostonTarkistus();
        
        luoListat();
        
        lisaaUusiTulos(nimi, aika);
        
        kirjoitustiedostonLuonti();

        int rivinumero = 1;
        int i = 0;
        int j = 0;
        while (rivinumero <= 20) {
            if (rivinumero % 2 == 1) {
                try {
                    kirjoittaja.write(ajat.get(i) + "\n");
                } catch (Exception e) {
                }
                i++;
            }
            if (rivinumero % 2 == 0) {
                try {
                    kirjoittaja.write(nimet.get(j) + "\n");
                } catch (Exception e) {
                }
                j++;
            }
            rivinumero++;
        }
        try {
            kirjoittaja.close();
        } catch (Exception e) {
        }
    }

   /**
    * Tulostaa listan konstruktorille annetusta tiedostosta.
    * @return Palauttaa listan stringinä.
    */
    public String tulosta() {

        ArrayList<String> ajat = new ArrayList<String>();
        ArrayList<String> nimet = new ArrayList<String>();
        String tulostus = "";
      //KORJAAA TÄÄÄÄÄÄ  
        lukutiedostonTarkistus();
        
            
        int rivinumero = 1;
        
        while(lukija.hasNextLine()) {
            if(rivinumero % 2 == 1) {
                ajat.add(lukija.nextLine());
            }
            if(rivinumero % 2 == 0) {
                nimet.add(lukija.nextLine());
            }
            rivinumero++;
        }
        lukija.close();
        
        for (int i = 0; i < 10; i++) {
            tulostus = tulostus + ajat.get(i) + " " + nimet.get(i) + "\n";
        }

        return tulostus;
    }
}

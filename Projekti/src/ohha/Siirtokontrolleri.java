/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import Käyttöliittymä.Lautanakyma;
import Käyttöliittymä.Voittodialogi;

/**
 *
 * @author Tontsu
 */
public class Siirtokontrolleri {

    private int arvaus = 0;
    private Nappula nappi1;
    private Nappula nappi2;
    private int kaantamattomia;
    private Lautanakyma peli;
    private long aika = 0;

    public Siirtokontrolleri(Lauta pelilauta, Lautanakyma peli) {
        kaantamattomia = pelilauta.getLukuja();
        this.peli = peli;
    }

    public void setNappi(Nappula nappi) {
        
        aloitaAika();
        
        if(nappi.onKaannetty()) {
            return;
        }
        
        if (nappi1 == null) {
            nappi1 = nappi;
            
        } else if (nappi2 == null) {
            nappi2 = nappi;
            vertailearvoja();
            
        } else {
            nappi1.piilota();
            nappi2.piilota();
            nappi1 = nappi;
            nappi2 = null;
        }
        nappi.kaanna();

    }

    private void vertailearvoja() {
        if (nappi1.getArvo() == nappi2.getArvo()) {
            nollaanapit();
            kaantamattomia--;
            tarkistaVoitto();
        }


    }

    private void nollaanapit() {
        nappi1 = null;
        nappi2 = null;
    }

    private void tarkistaVoitto() {
        if (kaantamattomia == 0) {
            long suoritusaika = (System.currentTimeMillis() - aika)/1000;
            peli.setVisible(false);
            Voittodialogi voitto = new Voittodialogi(suoritusaika);
            
        }
        
    }

    private void aloitaAika() {
        if (aika == 0) {
            aika = System.currentTimeMillis();
        }
    }
}

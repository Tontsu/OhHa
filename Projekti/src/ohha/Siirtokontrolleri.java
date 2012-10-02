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
    private Lauta pelilauta;
    /**
     * Luo uuden siirtokontrollerin, joka tuntee pelilaudan ja lautanäkymän.
     * @param pelilauta Pelilauta.
     * @param peli Käyttöliittymän lautanäkymä.
     */

    public Siirtokontrolleri(Lauta pelilauta, Lautanakyma peli) {
        kaantamattomia = pelilauta.getLukuja();
        this.pelilauta = pelilauta;
        this.peli = peli;
    }
/**
 * Päättää napille tehtävät toiminnot nappia käännettäessä.
 * Aloittaa ajan laskemisen, mikäli ajan laskemista ei ole vielä aloitettu.
 * Ei tee mitään jos nappi on jo käännetty.
 * Jos arvausparin ensimmäistä arvausta ei ole tehty, nappi on arvausparin ensimmäinen arvaus.
 * Jos arvausparin ensimmäinen arvaus on tehty, nappi on arvausparin toinen arvaus ja tapahtuu arvausarvojen vertailu.
 * Jos aloitetaan uusi arvauspari, eikä edellisestä parista löytynyt samoja arvoja, piilotetaan molemmat arvausparin napit.
 * 
 * @param nappi Käsiteltävä nappula.
 */
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
    
    /**
     * Vertaillaan kahden napin arvoja. Jos arvot ovat samat, poistetaan arvausparin nappulat käytöstä.
     * Kirjaa oikeat arvaukset ja tekee voittotarkistuksen.
     */

    private void vertailearvoja() {
        if (nappi1.getArvo() == nappi2.getArvo()) {
            nollaanapit();
            kaantamattomia--;
            tarkistaVoitto();
        }

    }
    
    /**
     * Poistaa nappulat käytöstä.
     */

    private void nollaanapit() {
        nappi1 = null;
        nappi2 = null;
    }
    
    /**
     * Tarkista laudan valmiuden. Jos lauta on valmis, lopettaa ajan laskemisen, piilottaa pelinäkymän ja avaa voittodialogin.
     */

    private void tarkistaVoitto() {
        if (kaantamattomia == 0) {
            long suoritusaika = (System.currentTimeMillis() - aika)/1000;
            peli.setVisible(false);
            Voittodialogi voitto = new Voittodialogi(suoritusaika, pelilauta.getKoko());
            
        }
        
    }
    /**
     * Aloittaa ajan laskemisen, mikäli ajan laskemista ei ole vielä aloitettu.
     */

    private void aloitaAika() {
        if (aika == 0) {
            aika = System.currentTimeMillis();
        }
    }
}

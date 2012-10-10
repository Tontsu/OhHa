/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import Käyttöliittymä.Lautanakyma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tontsu
 */
public class SiirtokontrolleriTest {
    Nappula testinappi;
    Nappula testinappi2;
    Lauta pelilauta;
    Siirtokontrolleri kontrolleri;
    Lautanakyma peli;
    
    public SiirtokontrolleriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        peli = new Lautanakyma(1);
        pelilauta = new Lauta(2);
        kontrolleri = new Siirtokontrolleri(pelilauta, peli);
        testinappi = new Nappula(1, 1, pelilauta, kontrolleri);
        testinappi2 = new Nappula(2, 2, pelilauta, kontrolleri);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testaaNapinSyotto() {  
        kontrolleri.setNappi(testinappi);
         assertEquals(true, testinappi.onKaannetty());
    }
    
    @Test
    public void testaaKahdenNapinSyotto() {  
        kontrolleri.setNappi(testinappi);
        kontrolleri.setNappi(testinappi2);
         assertEquals(true, testinappi2.onKaannetty());
    }
    @Test
    public void testaaNappienPiilotus() {  
        kontrolleri.setNappi(testinappi);
        kontrolleri.setNappi(testinappi2);
        kontrolleri.setNappi(testinappi2);
        assertEquals(false, testinappi.onKaannetty());
    }
        @Test
    public void testaaAjanLaskunAloitus() {  
        kontrolleri.setNappi(testinappi);
        long aika = kontrolleri.getAika();
        boolean testi = false;
        if (aika > 0) {
            testi = true;
        }
        assertEquals(true, testi);
    }
}

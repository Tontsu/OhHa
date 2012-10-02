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
public class NappulaTest {
    
    Nappula testinappi;
    Nappula nappi;
    Lauta pelilauta;
    Siirtokontrolleri kontrolleri;
    Lautanakyma peli;

    public NappulaTest() {
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void gety0() {
        nappi = new Nappula(1, 0, pelilauta, kontrolleri);
         assertEquals(0, nappi.getY());
    }
    @Test
    public void getx0() {
        nappi = new Nappula(0, 1, pelilauta, kontrolleri);
         assertEquals(0, nappi.getX());
    }
    
    @Test
    public void getx1() {
         assertEquals(1, testinappi.getX());
    }
    
    @Test
    public void gety1() {
         assertEquals(1, testinappi.getX());
    }
    @Test
    public void getyyli() {
        nappi = new Nappula(2, 1, pelilauta, kontrolleri);
        assertEquals(2, nappi.getX());
    } 
    @Test
    public void getarvo() { 
         int n = testinappi.getArvo();
         assertTrue(n == 0 || n == 1); 
    }
     @Test
     public void getkaannosfalse() {
         assertEquals(false, testinappi.onKaannetty());
     }
     @Test
     public void getkaannostrue() {
         testinappi.kaanna();
         assertEquals(true, testinappi.onKaannetty());
     }
    
}

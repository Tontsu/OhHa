package ohha;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohha.Lauta;
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
public class LautaTest {
    ByteArrayOutputStream tulostus;
    Lauta pelilauta;
    Lauta uuslauta;
    Lautanakyma peli;
    public LautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
      pelilauta = new Lauta(2);
      
      tulostus = new ByteArrayOutputStream();
      System.setOut( new PrintStream(tulostus) );
    }

    @After
    public void tearDown() {
    }
 
    @Test
    public void laudanTulostus() {
        String odotettu = "\na a \n" +
                          "a a " ;
        pelilauta.tulostaLauta();
        
        assertEquals( odotettu, poistaKenoR(tulostus.toString()));
    }
    @Test
    public void keskeneräinenValmiustarkastus() {
        assertEquals(false, pelilauta.valmiustarkastaja());
    }
    
    @Test
     public void testaaSivu() {
        assertEquals(2, pelilauta.getSivu());
    }
    
    @Test
     public void testaaKoko() {
        assertEquals(4, pelilauta.getKoko());
    }
    
    @Test
     public void testaaLukumaara() {
        assertEquals(2, pelilauta.getLukuja());
    }
    
    @Test
    public void ylimeneväKoordinaatti() {
         assertEquals(-1, pelilauta.koordinaattitarkastaja(2, 1));
    }
    @Test
    public void alimeneväKoordinaatti() {
         assertEquals(-1, pelilauta.koordinaattitarkastaja(-1, 1));
    }   

    @Test
    public void valmiinLaudanValmiustarkastus() {
        pelilauta.arvauskäsittelijä(0, 0, 1, 0);
        pelilauta.arvauskäsittelijä(0, 0, 0, 1);
        pelilauta.arvauskäsittelijä(0, 0, 1, 1);
        pelilauta.arvauskäsittelijä(1, 0, 1, 0);
        pelilauta.arvauskäsittelijä(1, 0, 0, 1);
        pelilauta.arvauskäsittelijä(1, 0, 1, 1);
        pelilauta.arvauskäsittelijä(1, 1, 0, 1);
        pelilauta.arvauskäsittelijä(0, 1, 0, 1);
        
       assertEquals(true, pelilauta.valmiustarkastaja());
    }
    @Test
    public void luoVirheellisellaKoolla() {
        uuslauta = new Lauta(7);
        String odotettu = "Laudan syöte kerrottuna itsellään ei ole parillinen\n";
        assertEquals( odotettu, poistaKenoR(tulostus.toString()));
        
     }
    @Test
    public void satunnaisuudentestaus() {
        Logger.getLogger("Lautatest").log(Level.WARNING, pelilauta.laudanSisältö());
    }
    
    @Test
     public void testaaIsompiKoko() {
        pelilauta = new Lauta(4);
        assertEquals(16, pelilauta.getKoko());
    }
    
    @Test
     public void testaaIsompiLukumaara() {
        pelilauta = new Lauta(4);
        assertEquals(8, pelilauta.getLukuja());
    }
    @Test
     public void testaaIsompiSivu() {
        pelilauta = new Lauta(4);
        assertEquals(4, pelilauta.getSivu());
    }
    

    private String poistaKenoR(String mj) {
        mj = mj.replace("\r", "");
        return mj;
    }
}

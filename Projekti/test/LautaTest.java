/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohha.Lauta;
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
      pelilauta = new Lauta(4);
      tulostus = new ByteArrayOutputStream();
      System.setOut( new PrintStream(tulostus) );
    }

    @After
    public void tearDown() {
    }
 
//    @Test
//    public void laudanTulostus() {
//        String odotettu = "\na a \n" +
//                          "a a " ;
//        pelilauta.tulostaLauta();
//        
//        assertEquals( odotettu, poistaKenoR(tulostus.toString()));
//    }
    @Test
    public void keskeneräinenValmiustarkastus() {
        assertEquals(false, pelilauta.valmiustarkastaja());
    }

//    @Test
//    public void valmiinLaudanValmiustarkastus() {
//        pelilauta.arvauskäsittelijä(0, 0, 1, 0);
//        pelilauta.arvauskäsittelijä(0, 0, 0, 1);
//        pelilauta.arvauskäsittelijä(0, 0, 1, 1);
//        pelilauta.arvauskäsittelijä(1, 0, 1, 0);
//        pelilauta.arvauskäsittelijä(1, 0, 0, 1);
//        pelilauta.arvauskäsittelijä(1, 0, 1, 1);
//        pelilauta.arvauskäsittelijä(1, 1, 0, 1);
//        pelilauta.arvauskäsittelijä(0, 1, 0, 1);
//        
//       assertEquals(true, pelilauta.valmiustarkastaja());
//    }
    @Test
    public void satunnaisuudentestaus() {
        Logger.getLogger("Lautatest").log(Level.WARNING, pelilauta.laudanSisältö());
    }
    private String poistaKenoR(String mj) {
        mj = mj.replace("\r", "");
        return mj;
    }
}

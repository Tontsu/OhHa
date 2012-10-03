/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
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
public class TopListaTest {
    TopLista lista;
    ByteArrayOutputStream tulostus;
    
    public TopListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lista = new TopLista("testi.txt");
        tulostus = new ByteArrayOutputStream();
        System.setOut( new PrintStream(tulostus) );
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaTarkistalistalleFalse() {  
         assertEquals(false, lista.tarkista(500));
    }
    
    @Test
    public void testaaTarkistalistalleTrue() {
         assertEquals(true, lista.tarkista(1));
    }
    
    @Test
    public void testaaTulostus() {
       System.out.println(lista.tulosta());   
    }
    
    @Test
    public void testaaKirjaus() {
       lista.kirjaaja("testi", 1); 
       System.out.println(lista.tulosta());
        
    }
    @Test
    public void testaaVirhellinenTiedosto() {
       new TopLista("bloo.txt");
       String odotettu = "Tiedostoa ei löydy\n";
       assertEquals(odotettu,  poistaKenoR(tulostus.toString()));
    }
    
       private String poistaKenoR(String mj) {
        mj = mj.replace("\r", "");
        return mj;
    }
    
 
}

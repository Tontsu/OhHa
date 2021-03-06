package ohha;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.*;

/**
 * Sovelluslogiikan pääluokka, joka luo pelilaudan.
 * Tältä luokalta tehdään kyselyt pelilaudan tilasta.
 * @author Tontsu
 */
public class Lauta {

    private static int[][] lauta;
    private int laudanKoko;
    private int sivu;
    private int lukujenmaara;
   
    
/**
 * Luo annetunkokoisen laudan. Koon täytyy olla parillinen kerrottuna itsellään.
 * @param koko Laudan sivun koko.
 */
    public Lauta(int koko) {
        sivu = koko;
        laudanKoko = koko*koko;
        
        if(laudanKoko % 2 != 0) {
            System.out.println("Laudan syöte kerrottuna itsellään ei ole parillinen");
            return;
        }
        lukujenmaara = laudanKoko/2;
        lauta = luoLauta(lukujenmaara, koko);
    }

    public int koordinaattitarkastaja(int X, int Y) {

        try {
            return lauta[Y][X];

        } catch (ArrayIndexOutOfBoundsException e) {            
            return -1;
        }
    }
   
    /**
     * Palauttaa erilaisten lukujen lukumäärän.
     * @return Lukujen lukumäärä.
     */
    public int getLukuja() {
        return lukujenmaara;
    }
    
   
    public void arvauskäsittelijä(int X1, int Y1, int X2, int Y2) {

        if (lauta[Y1][X1] == lauta[Y2][X2] && !(Y1 == Y2 && X1 == X2)) {
            lauta[Y1][X1] = -1;
            lauta[Y2][X2] = -1;
        }


    }
    /**
     * Tarkastaa laudan tilan.
     * @return Palauttaa truen, jos kaikki laudan alkiot on käännetty. Muuten false.
     */

    public boolean valmiustarkastaja() {
        
        int laskuri = 0;
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[0].length; j++) {
                if(lauta[i][j] == -1) {
                    laskuri++;
                }
            }
        }
        
        return (laudanKoko == laskuri);
    }

    public void tulostaLauta() {

        for (int i = 0; i < lauta.length; i++) {
            System.out.println("");
            for (int j = 0; j < lauta[0].length; j++) {
                if (lauta[i][j] == -1) {
                    System.out.print("b ");
                } else {
                    System.out.print("a ");
                }
            }
        }

    }
    /**
     * Palauttaa laudan sivun pituuden.
     * @return Sivun pituus.
     */
    public int getSivu() {
        return sivu;
    }
    
    /**
     * Palauttaa laudan alkioiden lukumäärän.
     * @return Alkioiden lukumäärä.
     */
    public int getKoko() {
        return laudanKoko;
    }
    
    public String laudanSisältö() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lauta.length; i++) {
            sb.append("\n");
            for (int j = 0; j < lauta[0].length; j++) {
                sb.append(lauta[i][j]);
            }
        }
        return sb.toString();
    }
    
    /**
     * Luo sekoitetun kaksiulotteisen taulukon, jossa on pari jokaista parametrina annettua lukua.
     * 
     * @param lukuja Taulukkoon sijoitettavien erilaisten lukujen lukumäärä.
     * @param koko Kaksiulotteisen taulukon sivun koko.
     * @return Sekoitettu kaksiulotteinen taulukko.
     */

    private int[][] luoLauta(int lukuja, int koko) {

        //String ko = "林林材材休休体体狭狭日日曰曰臼臼己己已已巳巳巴巴色色弓弓引引弔弔弗弗弟弟";
        //String ko = "林林材材";
        //char[] lukutaulu = ko.toCharArray();
        
        
        int[] lukutaulu = alusta(lukuja*2);
        
        sekoita(lukutaulu);
        
        int[][] lauta = new int[koko][koko];
        
        int lukuindeksi = 0;
         for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[0].length; j++) {
                lauta[i][j] = lukutaulu[lukuindeksi];
                lukuindeksi++;
            }
        }    
    return lauta;

    }
    
    /**
     * Metodi alustaa taulukkoon annetun määrän lukupareja. 
     * 
     * @param lukuja lukuparien lukumäärä.
     * @return palauttaa taulukon, jossa on pari jokaista lukua.
     */
    
    private int[] alusta(int lukuja) {
        
        
        int[] lukutaulu = new int[lukuja];
        int lukulaskuri = 0;
        int apu = 0;
        
        for(int i = 0; i < lukutaulu.length; i++) {
            lukutaulu[i] = apu;
            lukulaskuri++;
            if(lukulaskuri == 2) {
                apu++;
                lukulaskuri = 0;
            }
        }
        
        return lukutaulu;
    }
    /**
     * Metodi sekoittaa annetun taulukon.
     * 
     * @param lukutaulu Sekoitettava taulukko.
     * @return Palauttaa sekoitetun taulukon.
     */
    
    private int[] sekoita(int[] lukutaulu) {
        
        Random random = new Random();
        

        for (int i = 0; i < lukutaulu.length; i++) {
            int satunnaisindeksi = random.nextInt(lukutaulu.length);
            int apu = lukutaulu[i];
            lukutaulu[i] = lukutaulu[satunnaisindeksi];
            lukutaulu[satunnaisindeksi] = apu;
            
        
    }
        return lukutaulu;
    }
}

package ohha;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.*;

/**
 *
 * @author Tontsu
 */
public class Lauta {

    private static int[][] lauta;
    private int laudanKoko;
    private int sivu;

    public Lauta(int koko) {
        sivu = koko;
        laudanKoko = koko*koko;
        lauta = luoLauta(laudanKoko/2, koko);
    }

    public int koordinaattitarkastaja(int X, int Y) {

        try {
            return lauta[Y][X];

        } catch (ArrayIndexOutOfBoundsException e) {            
            return -1;
        }
    }
    
    

    public void arvauskäsittelijä(int X1, int Y1, int X2, int Y2) {

        if (lauta[Y1][X1] == lauta[Y2][X2] && !(Y1 == Y2 && X1 == X2)) {
            lauta[Y1][X1] = -1;
            lauta[Y2][X2] = -1;
        }


    }

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
    
    public int getSivu() {
        return sivu;
    }
    
    public int getKoko() {
        return laudanKoko;
    }
    
    public int getPituus() {
        return lauta[0].length;
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
    
    

    private int[][] luoLauta(int lukuja, int koko) {

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
    
    private int[] sekoita(int[] lukutaulu) {
        
        Random random = new Random();
        

        for (int i = 0; i < lukutaulu.length; i++) {
            int satunnaisindeksi = random.nextInt(lukutaulu.length -i)+i;
            int apu = lukutaulu[i];
            lukutaulu[i] = lukutaulu[satunnaisindeksi];
            lukutaulu[satunnaisindeksi] = apu;
            
        
    }
        return lukutaulu;
    }
}

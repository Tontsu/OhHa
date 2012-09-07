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

    Lauta(int koko) {
        laudanKoko = koko*koko;
        lauta = luoLauta(laudanKoko / 2, koko);
    }

    public boolean koordinaattitarkastaja(int X, int Y) {

        try {
            int arvo;
            arvo = lauta[Y][0];
            arvo = lauta[0][X];
            System.out.println("Arvauksesi oli: " + lauta[Y][X]);
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Virheellinen koordinaatti\nSyötä koordinaatit uudestaan\n");
            return false;
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

    private int[][] luoLauta(int lukuja, int koko) {

        int[] luvut = new int[lukuja];
        Random random = new Random();
        int[][] taulu = new int[koko][koko];

        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }

        for (int i = 0; i < taulu.length; i++) {

            for (int j = 0; j < taulu[0].length; j++) {
                int apu = 0;

                while (true) {
                    apu = random.nextInt(lukuja);
                    luvut[apu]++;
                    if (luvut[apu] <= 2) {
                        break;
                    }
                }
                taulu[i][j] = apu;


            }
        }

        return taulu;


    }
}

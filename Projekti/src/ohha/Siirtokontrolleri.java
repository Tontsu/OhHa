/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha;

/**
 *
 * @author Tontsu
 */
public class Siirtokontrolleri {

    private int arvaus = 0;
    private Nappula nappi1;
    private Nappula nappi2;
    private int kaantamattomia;

    public Siirtokontrolleri(Lauta pelilauta) {
        kaantamattomia = pelilauta.getLukuja();
    }

    public void setNappi(Nappula nappi) {
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
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}

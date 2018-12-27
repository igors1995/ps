/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.conteiner.dobavljac;

import java.util.ArrayList;
import sistem.nabavke.domain.Dobavljac;

/**
 *
 * @author skiljevic
 */
public class PretragaDobavljacaCounteiner {

    private static String pib;
    private static String naziv;
    private static String adresa;
    private static Operacija operacija;
    private static ArrayList<Dobavljac> dobavljaci = new ArrayList<>();

    public static void initAzuriranje() {
        pib = "";
        naziv = "";
        adresa = "";
        operacija = Operacija.AZURIRANJE;
    }

    public static void initIzbor() {
        pib = "";
        naziv = "";
        adresa = "";
        operacija = Operacija.IZBOR;
    }

    public static Dobavljac nadjiDobavljacaPoPibu(String pib) {
        for (Dobavljac dobavljac : dobavljaci) {
            if (dobavljac.getPib().equalsIgnoreCase(pib)) {
                return dobavljac;
            }
        }
        return null;
    }

    private PretragaDobavljacaCounteiner() {
    }

    public static String getPib() {
        return pib;
    }

    public static void setPib(String pib) {
        PretragaDobavljacaCounteiner.pib = pib;
    }

    public static String getNaziv() {
        return naziv;
    }

    public static void setNaziv(String naziv) {
        PretragaDobavljacaCounteiner.naziv = naziv;
    }

    public static String getAdresa() {
        return adresa;
    }

    public static void setAdresa(String adresa) {
        PretragaDobavljacaCounteiner.adresa = adresa;
    }

    public static Operacija getOperacija() {
        return operacija;
    }

    public static void setOperacija(Operacija operacija) {
        PretragaDobavljacaCounteiner.operacija = operacija;
    }

    public static ArrayList<Dobavljac> getDobavljaci() {
        return dobavljaci;
    }

    public static void setDobavljaci(ArrayList<Dobavljac> dobavljaci) {
        PretragaDobavljacaCounteiner.dobavljaci = dobavljaci;
    }

    public static void clear() {
        pib = null;
        naziv = null;
        adresa = null;
        operacija = null;
    }

}

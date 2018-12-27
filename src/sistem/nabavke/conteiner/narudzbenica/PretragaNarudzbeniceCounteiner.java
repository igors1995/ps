/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.conteiner.narudzbenica;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import sistem.nabavke.domain.Dobavljac;
import sistem.nabavke.domain.Narudzbenica;

/**
 *
 * @author skiljevic
 */
public class PretragaNarudzbeniceCounteiner {

    private PretragaNarudzbeniceCounteiner() {
    }
    
    private static String sifra;
    private static GregorianCalendar datumOd;
    private static GregorianCalendar datumDo;
    private static double cenaOd;
    private static double cenaDo;
    private static Dobavljac dobavljac;
    private static ArrayList<Narudzbenica> narudzbenice;

    public static ArrayList<Narudzbenica> getNarudzbenice() {
        return narudzbenice;
    }

    public static void setNarudzbenice(ArrayList<Narudzbenica> narudzbenice) {
        PretragaNarudzbeniceCounteiner.narudzbenice = narudzbenice;
    }
    
    

    public static String getSifra() {
        return sifra;
    }

    public static void setSifra(String sifra) {
        PretragaNarudzbeniceCounteiner.sifra = sifra;
    }

    public static GregorianCalendar getDatumOd() {
        return datumOd;
    }

    public static void setDatumOd(GregorianCalendar datumOd) {
        PretragaNarudzbeniceCounteiner.datumOd = datumOd;
    }

    public static GregorianCalendar getDatumDo() {
        return datumDo;
    }

    public static void setDatumDo(GregorianCalendar datumDo) {
        PretragaNarudzbeniceCounteiner.datumDo = datumDo;
    }

    public static double getCenaOd() {
        return cenaOd;
    }

    public static void setCenaOd(double cenaOd) {
        PretragaNarudzbeniceCounteiner.cenaOd = cenaOd;
    }

    public static double getCenaDo() {
        return cenaDo;
    }

    public static void setCenaDo(double cenaDo) {
        PretragaNarudzbeniceCounteiner.cenaDo = cenaDo;
    }

    public static Dobavljac getDobavljac() {
        return dobavljac;
    }

    public static void setDobavljac(Dobavljac dobavljac) {
        PretragaNarudzbeniceCounteiner.dobavljac = dobavljac;
    }
    
    
    
}

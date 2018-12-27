/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.conteiner.narudzbenica;

import java.util.ArrayList;
import sistem.nabavke.conteiner.cenaObserver.CenaObserver;
import sistem.nabavke.domain.Dobavljac;
import sistem.nabavke.domain.Proizvod;

/**
 *
 * @author skiljevic
 */
public class KreiranjeNarudzbeniceCounteiner {


    private KreiranjeNarudzbeniceCounteiner() {
    }

    private static ArrayList<Proizvod> proizvodi = new ArrayList();
    private static ArrayList<Proizvod> stavkeNarudzbenice = new ArrayList();
    private static double cena = 0;
    private static ArrayList<CenaObserver> cenaObservers = new ArrayList();
    private static Dobavljac dobavljac;

    public static ArrayList<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public static void setProizvodi(ArrayList<Proizvod> proizvodi) {
        KreiranjeNarudzbeniceCounteiner.proizvodi = proizvodi;
    }

    public static double getCena() {
        return cena;
    }

    private static void setCena(double cena) {
        KreiranjeNarudzbeniceCounteiner.cena = cena;
        for (CenaObserver observer : cenaObservers) {
            observer.update(cena);
        }
    }

    public static void addObserver(CenaObserver observer) {
        cenaObservers.add(observer);
    }

    public static void removeObserver(CenaObserver observer) {
        cenaObservers.remove(observer);
    }

    public static void clearObservers() {
        cenaObservers = new ArrayList();
    }

    public static void addStavkaNarudzbenice(Proizvod stavka) {
        stavkeNarudzbenice.add(stavka);
        setCena(getCena() + stavka.getCena());
    }

    public static void addStavkaNarudzbenice(String imeProizvoda) throws Exception {
        Proizvod stavka = null;
        for (Proizvod proizvod : proizvodi) {
            if (proizvod.getNaziv().equalsIgnoreCase(imeProizvoda)) {
                stavka = proizvod;
            }
        }
        if (stavka == null) {
            throw new Exception();
        }
        addStavkaNarudzbenice(stavka);
    }

    public static void removeStavkaNarudzbenice(Proizvod stavka) {
        if (stavkeNarudzbenice.contains(stavka)){
        stavkeNarudzbenice.remove(stavka);
        setCena(getCena() - stavka.getCena());
        }
    }

    public static void removeStavkaNarudzbenice(String imeProizvoda) throws Exception {
        Proizvod stavka = null;
        for (Proizvod proizvod : proizvodi) {
            if (proizvod.getNaziv().equalsIgnoreCase(imeProizvoda)) {
                stavka = proizvod;
            }
        }
        if (stavka == null) {
            throw new Exception();
        }
        removeStavkaNarudzbenice(stavka);
    }

    public static void clearStavkeNarudzbenice() {
        stavkeNarudzbenice = new ArrayList();
    }

    public static Dobavljac getDobavljac() {
        return dobavljac;
    }

    public static void setDobavljac(Dobavljac dobavljac) {
        KreiranjeNarudzbeniceCounteiner.dobavljac = dobavljac;
    }

    public static String[] vratiFormatiraneProizvode() {
        String[] ret = new String[proizvodi.size()];
        for (int i = 0; i < proizvodi.size(); i++) {
            ret[i] = proizvodi.get(i).getNaziv() + " " + proizvodi.get(i).getCena();
        }

        return ret;
    }

    public static String narudzbeniceToTextAreaForm() {
        String ret = "";
        ArrayList<Proizvod> iskorisceniProizvodi = new ArrayList();

        for (Proizvod proizvod : proizvodi) {
            if (stavkeNarudzbenice.contains(proizvod)) {
                iskorisceniProizvodi.add(proizvod);
            }
        }

        for (Proizvod iskoriscenProizvod : iskorisceniProizvodi) {
            int brojPonavljanja = brojPonavljanjaProizvodaUNarudzbenici(iskoriscenProizvod, stavkeNarudzbenice);
            ret += iskoriscenProizvod.getNaziv() + " " + brojPonavljanja + "\n";
            brojPonavljanja = 0;
        }

//        for (Proizvod proizvod : stavkeNarudzbenice) {
//            ret += proizvod.getNaziv() + " " + proizvod.getCena() + "\n";
//        }
        return ret;
    }

    private static int brojPonavljanjaProizvodaUNarudzbenici(Proizvod koriscenProizvod, ArrayList<Proizvod> stavkeNarudzbenice) {
        int ret = 0;
        for (Proizvod proizvod : stavkeNarudzbenice) {
            if (koriscenProizvod.equals(proizvod)) {
                ret++;
            }
        }
        return ret;
    }
    
        public static void clear() {
        proizvodi = new ArrayList();
        cenaObservers = new ArrayList();
        dobavljac = null;
        stavkeNarudzbenice = new ArrayList();
        cena = 0;
    }

}

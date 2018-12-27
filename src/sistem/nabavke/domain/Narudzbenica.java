/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.domain;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author skiljevic
 */
public class Narudzbenica {

    private final String id;
    private String sifra;
    private GregorianCalendar datum;
    private ArrayList<Proizvod> proizvodi;
    private Dobavljac dobaljac;

    public Narudzbenica(String id, String sifra, GregorianCalendar datum, Dobavljac dobavljac) {
        this.id = id;
        this.datum = datum;
        this.sifra = sifra;
        this.proizvodi = new ArrayList();
        this.dobaljac = dobavljac;
    }

    public String getId() {
        return id;
    }

    public GregorianCalendar getDatum() {
        return datum;
    }

    public void setDatum(GregorianCalendar datum) {
        this.datum = datum;
    }

    public ArrayList<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void dodajProizvod(Proizvod proizvod) throws Exception {
        if (!proizvodi.contains(proizvod)) {
            this.proizvodi.add(proizvod);
        } else {
            throw new Exception("Dati proizvod postoji");
        }
    }

    public Dobavljac getDobaljac() {
        return dobaljac;
    }

    public void setDobaljac(Dobavljac dobaljac) {
        this.dobaljac = dobaljac;
    }
    
    public double getCena() {
    double cena = 0;
    
        for (Proizvod proizvod : proizvodi) {
            cena += proizvod.getCena();
        }
    return cena;
    
    }

    public String getSifra() {
        return sifra;
    }
    
    
    

}

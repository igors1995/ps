/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.domain;

/**
 *
 * @author skiljevic
 */
public class Dobavljac {

    private String id;
    private String pib;
    private String naziv;
    private String adresa;

    public Dobavljac(String id, String pib, String naziv, String adresa) {
        this.id = id;
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + pib + "] " + naziv;
    }

    
}

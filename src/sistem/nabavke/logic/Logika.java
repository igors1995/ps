/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.logic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import static javafx.scene.input.KeyCode.S;
import sistem.nabavke.assets.exceptions.PostojiDobavljacException;
import sistem.nabavke.assets.exceptions.PostojiUserException;
import sistem.nabavke.domain.Dobavljac;
import sistem.nabavke.domain.Narudzbenica;
import sistem.nabavke.domain.Proizvod;

import sistem.nabavke.domain.User;

/**
 *
 * @author skiljevic
 */
public class Logika {

    public static User checkUser(String username, String password) {
        // TODO
        return new User("Igor", "Skiljevic", Math.random() > 0.5);
    }

    public static User kreirajKorisnika(String username, String password) throws PostojiUserException {
        // TODO
        throw new PostojiUserException();
    }

    public static Dobavljac kreirajDobavljaca(String adresa, String pib, String naziv) throws PostojiDobavljacException {
        // TODO
        throw new PostojiDobavljacException();
    }

    public static ArrayList<Dobavljac> dajSveDobavljace(String pib, String naziv, String adresa) {
        // TODO
        ArrayList<Dobavljac> dobavljaci = new ArrayList();
        dobavljaci.add(new Dobavljac("1", "123", "Dobavljac 1", "adresa1"));
        dobavljaci.add(new Dobavljac("2", "222", "Dobavljac 2", "adresa2"));
        
        return dobavljaci;
    }

    public static Dobavljac obrisiDobavljaca(String pib) {
        // TODO
        return new Dobavljac("1", pib, "23", "dfdf");
    }

   

    public static ArrayList<Narudzbenica> pretraziNarudzbenice(String sifra, GregorianCalendar dOd, GregorianCalendar dDo, double cOd, double cDo, ArrayList<Dobavljac> dobavljaci) {
        // TODO
        ArrayList<Narudzbenica> narudzbenice = new ArrayList();
        Dobavljac dobavljac = new Dobavljac("1", "pib1", "Dobavljac 1", "Gandijeva 53");
        Narudzbenica n1 = new Narudzbenica("1", "sif1", new GregorianCalendar(), dobavljac);
        Narudzbenica n2 = new Narudzbenica("2", "sif2",new GregorianCalendar(), dobavljac);
        try{
        n1.dodajProizvod(new Proizvod("1", "123", 77.7));
        n1.dodajProizvod(new Proizvod("2", "222", 80.7));
        
        n1.dodajProizvod(new Proizvod("3", "333", 1177.7));
        n1.dodajProizvod(new Proizvod("4", "444", 2380.7));
        } catch (Exception e){
            System.out.println("greska");
        } 
       
        narudzbenice.add(n1);
        narudzbenice.add(n2);
        return narudzbenice;
    }
    

    public static Dobavljac azurirajDobavljaca(Dobavljac dobavljac, String pib, String naziv, String adresa) {
        return new Dobavljac(dobavljac.getId(), pib, naziv, adresa);
    }
}
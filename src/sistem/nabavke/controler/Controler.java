/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.controler;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistem.nabavke.assets.exceptions.PostojiDobavljacException;
import sistem.nabavke.assets.exceptions.PostojiUserException;
import sistem.nabavke.conteiner.narudzbenica.KreiranjeNarudzbeniceCounteiner;
import sistem.nabavke.conteiner.MainMenuConteiner;
import sistem.nabavke.conteiner.cenaObserver.CenaObserver;
import sistem.nabavke.conteiner.dobavljac.AzuriranjeDobavljacaCounteiner;
import sistem.nabavke.conteiner.dobavljac.Operacija;
import sistem.nabavke.conteiner.dobavljac.PretragaDobavljacaCounteiner;
import sistem.nabavke.conteiner.narudzbenica.PretragaNarudzbeniceCounteiner;
import sistem.nabavke.domain.Dobavljac;
import sistem.nabavke.domain.Narudzbenica;
import sistem.nabavke.domain.Proizvod;
import sistem.nabavke.domain.User;
import sistem.nabavke.gui.GuiDodajKorisnika;
import sistem.nabavke.gui.GuiLogIn;
import sistem.nabavke.gui.GuiMainMenu;
import sistem.nabavke.gui.dobavljac.GuiDobavljacKreiranje;
import sistem.nabavke.gui.dobavljac.GuiDobavljacPretraga;
import sistem.nabavke.gui.narudzbenica.GuiNarudzbenicaKreiranje;
import sistem.nabavke.gui.narudzbenica.GuiNarudzbenicaPretraga;
import sistem.nabavke.logic.Logika;
import sistem.nabavke.util.Util;

/**
 *
 * @author skiljevic
 */
public class Controler {

    private static GuiMainMenu glavniMenu;
    private static GuiLogIn logIn;
    private static GuiDodajKorisnika dodajKorisnika;
    private static GuiDobavljacKreiranje kreiranjeDobavljaca;
    private static GuiNarudzbenicaKreiranje kreiranjeNarudzbenice;
    private static GuiDobavljacPretraga pretragaDobavljaca;
    private static GuiNarudzbenicaPretraga pretragaNarudzbenice;

//    private static MainMenuConteiner mainMenuConteiner ;
    public static void main(String[] args) {
//        otvoriGlavniMenu();
        ArrayList<Proizvod> proizvodi = new ArrayList();
        proizvodi.add(new Proizvod("1", "Mleko", 66));
        proizvodi.add(new Proizvod("2", "Hleb", 30));
        KreiranjeNarudzbeniceCounteiner.setProizvodi(proizvodi);
        otvoriLogIn();
    }

    private static void otvoriGlavniMenu(String username, String password, boolean isAdmin) {

        MainMenuConteiner.setUser(username, password, isAdmin);
        glavniMenu = new GuiMainMenu();
        glavniMenu.setVisible(true);
        glavniMenu.setLblUsername(MainMenuConteiner.getUser().getUsername());
        if (isAdmin) {
            glavniMenu.setLblAdmin("Admin");
        }
        if (!isAdmin) {
            glavniMenu.hideMainMenu();
        }
    }

    public static void zatvoriGlavniMenu() {
        MainMenuConteiner.clear();
        glavniMenu.setVisible(false);
        glavniMenu = null;
        otvoriLogIn();
    }

    public static void otvoriLogIn() {
        logIn = new GuiLogIn();
        logIn.setVisible(true);
    }

    public static void sakrijLogInProzor() {
        logIn.setVisible(false);
    }

    private static void otvoriDodajKorisnikaProzor() {
        dodajKorisnika = new GuiDodajKorisnika(glavniMenu, true);
        dodajKorisnika.setVisible(true);
    }

    public static void zatvoriDodajKorisnikaProzor() {
        dodajKorisnika.setVisible(false);
        dodajKorisnika = null;
    }

    public static void otvoriProzorKreiranjeDobavljaca() {
        kreiranjeDobavljaca = new GuiDobavljacKreiranje(glavniMenu, true);
        kreiranjeDobavljaca.setVisible(true);
    }

    public static void zatvoriProzorKreiranjeDobavljaca() {
        kreiranjeDobavljaca.setVisible(false);
        kreiranjeDobavljaca = null;
        AzuriranjeDobavljacaCounteiner.setDobavljac(null);
    }

    public static void otvoriProzorAzuriranjeDobavljaca(Dobavljac dobavljac) {
        kreiranjeDobavljaca = new GuiDobavljacKreiranje(dobavljac.getPib(), dobavljac.getNaziv(), dobavljac.getAdresa(), glavniMenu, true);
        kreiranjeDobavljaca.setVisible(true);
    }

    public static void otvoriProzorKreiranjeNarudzbenice() {
        kreiranjeNarudzbenice = new GuiNarudzbenicaKreiranje();
        kreiranjeNarudzbenice.setVisible(true);
        KreiranjeNarudzbeniceCounteiner.addObserver(kreiranjeNarudzbenice);
        glavniMenu.setVisible(false);

    }
    
        public static void otvoriProzorPregledNarudzbenice() {
        kreiranjeNarudzbenice = new GuiNarudzbenicaKreiranje();
        kreiranjeNarudzbenice.setVisible(true);
        KreiranjeNarudzbeniceCounteiner.addObserver(kreiranjeNarudzbenice);
        glavniMenu.setVisible(false);

    }

    public static void zatvoriProzorKreiranjeNarudzbenice() {
        kreiranjeNarudzbenice.setVisible(false);
        kreiranjeNarudzbenice = null;
        KreiranjeNarudzbeniceCounteiner.clear();
        glavniMenu.setVisible(true);
    }

    public static void otvoriPretragaDobacljaca() {
        PretragaDobavljacaCounteiner.initAzuriranje();
        pretragaDobavljaca = new GuiDobavljacPretraga(PretragaDobavljacaCounteiner.getOperacija());
        pretragaDobavljaca.setVisible(true);
        glavniMenu.setVisible(false);
    }

    public static void zatvoriPretragaDobavljaca() {
        glavniMenu.setVisible(true);
        pretragaDobavljaca.setVisible(false);
        pretragaDobavljaca = null;
        PretragaDobavljacaCounteiner.clear();

    }

    public static void otvoriIzborDobavljaca() {
        PretragaDobavljacaCounteiner.initIzbor();
        pretragaDobavljaca = new GuiDobavljacPretraga(PretragaDobavljacaCounteiner.getOperacija());
        pretragaDobavljaca.setVisible(true);
        kreiranjeNarudzbenice.setVisible(false);
    }

    public static void zatvoriIzborDobavljaca() {
        pretragaDobavljaca.setVisible(false);
        pretragaDobavljaca = null;
        PretragaDobavljacaCounteiner.clear();
        kreiranjeNarudzbenice.setVisible(true);
    }

    public static void logInButtonPressed(String username, String password) {
        User user = Logika.checkUser(username, password);
        if (user != null) {
            sakrijLogInProzor();
            otvoriGlavniMenu(user.getUsername(), user.getPassword(), user.isAdmin());
        } else {

        }
    }

    public static void dodajKorisnikaButtonPressed() {
        otvoriDodajKorisnikaProzor();
    }

    public static void kreirajKorisnikaButtonPressed(String username, String password, String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            try {
                User user = Logika.kreirajKorisnika(username, password);
                JOptionPane.showMessageDialog(dodajKorisnika, "Uspesno kreiran korisnik " + username, "Uspesno kreiranje", JOptionPane.INFORMATION_MESSAGE);
                zatvoriDodajKorisnikaProzor();
            } catch (PostojiUserException e) {
                JOptionPane.showMessageDialog(dodajKorisnika, "Uneti korisnik vec postoji", "Greska", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri kreiranju korisnika", "Greska", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            dodajKorisnika.setLblError("Lose uneta sifra");
        }

    }

    public static void kreirajDobavljacaButtonPressed(String adresa, String pib, String naziv) {
        if (adresa.equalsIgnoreCase("") || pib.equalsIgnoreCase("") || naziv.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Svi parametri moraju biti uneti", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Dobavljac dobavljac = Logika.kreirajDobavljaca(adresa, pib, naziv);
            JOptionPane.showMessageDialog(kreiranjeDobavljaca, "Dobavljac uspesno kreiran", "Uspesno kreiranje", JOptionPane.INFORMATION_MESSAGE);
            zatvoriProzorKreiranjeDobavljaca();
        } catch (PostojiDobavljacException e) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Uneti dobavljac vec postoji", "Greska", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri kreiranju dobavljaca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void azurirajDobavljacaButtonPressed(String pib, String naziv, String adresa) {
        if (adresa.equalsIgnoreCase("") || pib.equalsIgnoreCase("") || naziv.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Svi parametri moraju biti uneti", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Dobavljac dobavljac = Logika.azurirajDobavljaca(AzuriranjeDobavljacaCounteiner.getDobavljac(), pib, naziv, adresa);
            if (dobavljac != null) {
                JOptionPane.showMessageDialog(kreiranjeDobavljaca, "Dobavljac uspesno azuriran", "Uspesno kreiranje", JOptionPane.INFORMATION_MESSAGE);
                zatvoriProzorKreiranjeDobavljaca();
            }
            JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri azuriranju dobavljaca", "Greska", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri azuriranju dobavljaca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void dodajProizvodUnarudzbenice(String selectedValue) {
        String imeProizvoda = selectedValue.substring(0, selectedValue.indexOf(" "));
//        double cena = Double.parseDouble(selectedValue.split(" ")[1]);
        try {
            KreiranjeNarudzbeniceCounteiner.addStavkaNarudzbenice(imeProizvoda);
//            String narudzbenice = Util.dodajNarudzbeniUStringFormatu(kreiranjeNarudzbenice.getNarudzbenice(), selectedValue);
            kreiranjeNarudzbenice.setNarudzbenice(KreiranjeNarudzbeniceCounteiner.narudzbeniceToTextAreaForm());
        } catch (Exception e) {
            // TODO
            System.out.println("exception");
        }

    }

    public static void izbaciProizvodIzNarudzbenice(String selectedValue) {
        String imeProizvoda = selectedValue.substring(0, selectedValue.indexOf(" "));
        try {
            KreiranjeNarudzbeniceCounteiner.removeStavkaNarudzbenice(imeProizvoda);
            kreiranjeNarudzbenice.setNarudzbenice(KreiranjeNarudzbeniceCounteiner.narudzbeniceToTextAreaForm());
        } catch (Exception ex) {
            // TODO
            System.out.println("exception");
        }
    }

    public static void pretraziDobavljaceButtonPressed(String pib, String naziv, String adresa) {
        PretragaDobavljacaCounteiner.setPib(pib);
        PretragaDobavljacaCounteiner.setNaziv(naziv);
        PretragaDobavljacaCounteiner.setAdresa(adresa);
        try {
            PretragaDobavljacaCounteiner.setDobavljaci(Logika.dajSveDobavljace(pib, naziv, adresa));
            ArrayList<Dobavljac> dobavljaci = PretragaDobavljacaCounteiner.getDobavljaci();
            Object[][] data = new Object[dobavljaci.size()][3];
            for (int i = 0; i < dobavljaci.size(); i++) {
                data[i][0] = dobavljaci.get(i).getPib();
                data[i][1] = dobavljaci.get(i).getNaziv();
                data[i][2] = dobavljaci.get(i).getAdresa();
            }
            pretragaDobavljaca.setDataDobavljaci(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri pretrazi dobavljaca", "Greska", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void obrisiDobavljacaButtonPressed(String pib) {
        try {
            Dobavljac dobavljac = Logika.obrisiDobavljaca(pib);
            if (dobavljac != null) {
                JOptionPane.showMessageDialog(kreiranjeDobavljaca, "Dobavljac uspesno obrisan", "Uspesno brisanje", JOptionPane.INFORMATION_MESSAGE);
                pretraziDobavljaceButtonPressed(PretragaDobavljacaCounteiner.getPib(), PretragaDobavljacaCounteiner.getNaziv(), PretragaDobavljacaCounteiner.getAdresa());
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            JOptionPane.showMessageDialog(dodajKorisnika, "Doslo je do greske pri brisanju dobavljaca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void pokreniAzuriranjeDobavljacaButtonPressed(String pib) {
        Dobavljac dobavljac = PretragaDobavljacaCounteiner.nadjiDobavljacaPoPibu(pib);
        AzuriranjeDobavljacaCounteiner.setDobavljac(dobavljac);
        otvoriProzorAzuriranjeDobavljaca(dobavljac);
    }

    public static void otvoriProzorPretragaNarudzbenice() {

        pretragaNarudzbenice = new GuiNarudzbenicaPretraga();
        pretragaNarudzbenice.setVisible(true);
        glavniMenu.setVisible(false);
    }

    public static void zatvoriProzorPretragaNarudzbenice() {
        pretragaNarudzbenice.setVisible(false);
        pretragaNarudzbenice = null;
        glavniMenu.setVisible(true);
    }

    public static void pretraziNarudzbeniceButtonPressed(String sifra, String datumOd, String datumDo, String cenaOd, String cenaDo) {
        GregorianCalendar dOd = Util.proveriDatum(datumOd);
        GregorianCalendar dDo = Util.proveriDatum(datumDo);
        double cOd = 0;
        double cDo = 0;

        if (dOd == null && !datumOd.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose unet  datum od", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dDo == null && !datumDo.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose unet  datum do", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (dDo != null && dOd != null && dDo.before(dOd)){
        JOptionPane.showMessageDialog(pretragaNarudzbenice, "Datum od ne sme biti veci od datuma do", "Greska", JOptionPane.ERROR_MESSAGE);
        return;
        }

        if (!cenaOd.equalsIgnoreCase("")){
        try {
            cOd = Double.parseDouble(cenaOd);
            if (cOd < 0) {
                JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose uneta cena od", "Greska", JOptionPane.ERROR_MESSAGE);
                cOd = 0;
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose uneta cena od", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        }
        if (!cenaDo.equalsIgnoreCase("")){
        try {
            cDo = Double.parseDouble(cenaDo);
            if (cDo < 0) {
                JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose uneta cena do", "Greska", JOptionPane.ERROR_MESSAGE);
                cOd = 0;
                return;
            }
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(pretragaNarudzbenice, "Lose uneta cena do", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        }
        
        PretragaNarudzbeniceCounteiner.setSifra(sifra);
        PretragaNarudzbeniceCounteiner.setDatumOd(dOd);
        PretragaNarudzbeniceCounteiner.setDatumDo(dDo);
        PretragaNarudzbeniceCounteiner.setCenaOd(cOd);
        PretragaNarudzbeniceCounteiner.setCenaDo(cDo);
        
        ArrayList<Narudzbenica> narudzbenice = Logika.pretraziNarudzbenice(sifra, dOd, dDo, cOd, cDo, PretragaDobavljacaCounteiner.getDobavljaci());
        
         Object[][] data = new Object[narudzbenice.size()][4];
            for (int i = 0; i < narudzbenice.size(); i++) {
                data[i][0] = narudzbenice.get(i).getSifra();
                data[i][1] = Util.fromGregorianToString(narudzbenice.get(i).getDatum());
                data[i][2] = narudzbenice.get(i).getCena();
                data[i][3] = narudzbenice.get(i).getDobaljac().toString();
            }
            pretragaNarudzbenice.setDataNarudzbenice(data);
    }

    public static void pregledajNarudzbenicuButtonPressed(String sifra) {
        Narudzbenica narudzbenica = PretragaNarudzbeniceCounteiner.nadjiNarudzbenicuPoSifri(sifra);
        
        String datum = Util.fromGregorianToString(narudzbenica.getDatum());
        String dobavljac = narudzbenica.getDobaljac().toString();
        String proizvodiString = "";
        for (Proizvod proizvod : narudzbenica.getProizvodi() {
            
        }
        
        otvoriProzorPregledNarudzbenice(narudzbenica.getSifra(), datum, narudzbenica.getCena(), narudzbenica.getDobaljac(), narudzbenica.getProizvodi());
    }

 

}

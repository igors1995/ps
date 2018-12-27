/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author skiljevic
 */
public class Util {

    public static GregorianCalendar proveriDatum(String datum) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = df.parse(datum);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            return cal;
        } catch (ParseException e) {
            return null;
        }
    }

//    public static String dodajNarudzbeniUStringFormatu(String narudzbenice, String selectedValue) {
//        Array povratnaVrednost = "";
//        String selectedValueIme = selectedValue.split(" ")[0];
//        double selectedValuueCena =  Double.parseDouble(selectedValue.split(" ")[1]);
//        String [] odvojeneNarudzbenice = narudzbenice.split("\n");
//        boolean dodatNoviRed = false;
//        
//        for (String nar : odvojeneNarudzbenice) {
//            String imeNarudzbenice = nar.split(" ")[0];
//            int kolicina = Integer.parseInt(nar.split(" ")[1]);
//            if(imeNarudzbenice.equalsIgnoreCase(selectedValueIme))
//            
//            dodatNoviRed = true;
//        }
//        if(!dodatNoviRed){
//        
//        }
//        return povratnaVrednost;
//    }
    public static String fromGregorianToString(GregorianCalendar datum) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MMM.yyyy");
        fmt.setCalendar(datum);
        String dateFormatted = fmt.format(datum.getTime());
        return dateFormatted;
    }
}

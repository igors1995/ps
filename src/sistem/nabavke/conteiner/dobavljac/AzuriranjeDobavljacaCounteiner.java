/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.conteiner.dobavljac;

import sistem.nabavke.domain.Dobavljac;

/**
 *
 * @author skiljevic
 */
public class AzuriranjeDobavljacaCounteiner {

    private static Dobavljac dobavljac;

    private AzuriranjeDobavljacaCounteiner() {
    }
    
    public static Dobavljac getDobavljac() {
        return dobavljac;
    }

    public static void setDobavljac(Dobavljac dobavljac) {
        dobavljac = dobavljac;
    }
    
    

}

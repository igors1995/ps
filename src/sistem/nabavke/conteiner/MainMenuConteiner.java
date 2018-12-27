/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.conteiner;

import sistem.nabavke.domain.User;

/**
 *
 * @author skiljevic
 */
public class MainMenuConteiner {

    private static User user = null;
    
    private MainMenuConteiner() {
    }
    
    public static void setUser(String username, String password, boolean isAdmin){
        user = new User(username, password, isAdmin);
    }
    
    public static User getUser(){
    return user;
    }
    
    public static void clear() {
        user = null;
    }
    
}

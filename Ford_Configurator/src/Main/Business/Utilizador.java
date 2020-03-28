/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Business;

import java.util.Objects;

/**
 *
 * @author oitenta80
 */
public class Utilizador {
    private int id_utilizador;
    private int numero;
    private String email_utilizador;
    private String usernameU;
    private String passwordU;
    
    //construtor vazio de utilizador
    public Utilizador(){
       this.email_utilizador="";
       this.numero = 0;
       this.usernameU ="";
       this.passwordU="";
    }
   
   /**
    * 
    * @param numero
    * @param email
    * @param usernameU
    * @param passwordU 
    */ 
    public Utilizador(int numero,String email, String usernameU, String passwordU){
        this.numero = numero;
        this.email_utilizador=email;
        this.usernameU = usernameU;
        this.passwordU = passwordU;
    }
    
    /**
     * Construtor de utilizador que so recebe objetos de tipo utilizador
     * @param u 
     */
    public Utilizador(Utilizador u){
        id_utilizador = u.getId_utilizador();
        numero = u.getNumero();
        email_utilizador = u.getEmail_utilizador();
        usernameU = u.getUsername();
        passwordU = u.getPassword();
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the usernameU
     */
    public String getUsername() {
        return usernameU;
    }

    /**
     * @param usernameU the nome to set
     */
    public void setUsername(String usernameU) {
        this.usernameU = usernameU;
    }

    /**
     * @return the passwordU
     */
    public String getPassword() {
        return passwordU;
    }

    /**
     * @param passwordU the email to set
     */
    public void setPassword(String passwordU) {
        this.passwordU = passwordU;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public String getEmail_utilizador() {
        return email_utilizador;
    }

    public void setEmail_utilizador(String email_utilizador) {
        this.email_utilizador = email_utilizador;
    }
    
    
    
    /**
     * Verifica se a passwordU existe
     * @param passwordU
     * @throws PasswordException 
     */
   
     public void verificarPassword(String passwordU) throws PasswordException {
        if (this.passwordU.equals(passwordU)){ 
            return;
        }
        else {
            throw new PasswordException("Password Errada!");
        }
    }

    public Utilizador clone(){
        return new Utilizador(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Utilizador other = (Utilizador) obj;
        
        if (this.id_utilizador != other.id_utilizador) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.email_utilizador, other.email_utilizador)) {
            return false;
        }
        if (!Objects.equals(this.usernameU, other.usernameU)) {
            return false;
        }
        if (!Objects.equals(this.passwordU, other.passwordU)) {
            return false;
        }
        return true;
    }
    
    
    
}

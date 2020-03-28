/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Business;

import java.util.Objects;

/**
 *
 * @author Nuno
 */
public class Cliente {
    
    private int nif_cl;
    private String morada_cl;
    private String email_cl;
    private String nome_cl;
    
    public Cliente(){
        this.nome_cl = "";
        this.nif_cl=0;
        this.morada_cl="";
        this.email_cl="";
        
    }
    
    public Cliente(int nif, String morada, String email, String nome_cl){
        this.nif_cl=nif;
        this.morada_cl=morada;
        this.email_cl=email;
        this.nome_cl=nome_cl;
    }
    
    public Cliente(Cliente c){
        nif_cl=c.getNif_cl();
        morada_cl=c.getMorada_cl();
        email_cl=c.getEmail_cl();
        nome_cl=c.getNome_cl();
    }

    public int getNif_cl() {
        return nif_cl;
    }

    public void setNif_cl(int nif_cl) {
        this.nif_cl = nif_cl;
    }

    public String getMorada_cl() {
        return morada_cl;
    }

    public void setMorada_cl(String morada_cl) {
        this.morada_cl = morada_cl;
    }

    public String getEmail_cl() {
        return email_cl;
    }

    public void setEmail_cl(String email_cl) {
        this.email_cl = email_cl;
    }

    public String getNome_cl() {
        return nome_cl;
    }

    public void setNome_cl(String nome_cl) {
        this.nome_cl = nome_cl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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
        final Cliente other = (Cliente) obj;
        if (this.nif_cl != other.nif_cl) {
            return false;
        }
        if (!Objects.equals(this.morada_cl, other.morada_cl)) {
            return false;
        }
        if (!Objects.equals(this.email_cl, other.email_cl)) {
            return false;
        }
        if (!Objects.equals(this.nome_cl, other.nome_cl)) {
            return false;
        }
        return true;
    }
    
    
    
}

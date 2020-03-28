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
public class Configuracao {
    private int idC;
    private String nomeC;
    private int idF;
    private int nifCl;
    
    public Configuracao(){
        this.idC = 0;
        this.nomeC="";
        this.idF=0;
        this.nifCl=0;
    }
    
    public Configuracao(int idC, String nome, int idF, int nif){
        this.idC = idC;
        this.nomeC=nome;
        this.idF=idF;
        this.nifCl=nif;
    }
    
    public Configuracao(Configuracao c){
        idC = c.getidC();
        nomeC = c.getNomeC();
        idF = c.getIdF();
        nifCl = c.getNifCl();
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public int getNifCl() {
        return nifCl;
    }

    public void setNifCl(int nifCl) {
        this.nifCl = nifCl;
    }

    
    
    /**
     * @return the idC
     */
    public int getidC() {
        return idC;
    }
    
    public Configuracao clone(){
        return new Configuracao(this);        
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Configuracao other = (Configuracao) obj;
        if (this.idC != other.idC) {
            return false;
        }
        if (this.idF != other.idF) {
            return false;
        }
        if (this.nifCl != other.nifCl) {
            return false;
        }
        if (!Objects.equals(this.nomeC, other.nomeC)) {
            return false;
        }
        return true;
    }


    
    double calculaPrecoConfig(Configuracao c){
        return 0.0;
    }
    
    double calculaPrecoPacote(Pacote p){
        return 0.0;
    }
}

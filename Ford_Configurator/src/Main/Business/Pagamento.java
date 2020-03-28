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
public class Pagamento {
    
    private double montante;
    private String referencia_Cl;
    private String email_Cl;
    private int telefone_Cl;
    private float mensalidade;
    
    
    public Pagamento(){
        this.email_Cl="";
        this.referencia_Cl="";
        this.mensalidade=0;
        this.montante=0;
        this.telefone_Cl=0; 
    }
    
    public Pagamento(double montante){
        this.montante=montante;
    }
    
    public Pagamento(Pagamento p){
        this.email_Cl=p.getEmail_Cl();
        this.referencia_Cl=p.getReferencia_Cl();
        this.mensalidade=p.getMensalidade();
        this.montante=p.getMontante();
        this.telefone_Cl=p.getTelefone_Cl();  
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public String getReferencia_Cl() {
        return referencia_Cl;
    }

    public void setReferencia_Cl(String referencia_Cl) {
        this.referencia_Cl = referencia_Cl;
    }

    public String getEmail_Cl() {
        return email_Cl;
    }

    public void setEmail_Cl(String email_Cl) {
        this.email_Cl = email_Cl;
    }

    public int getTelefone_Cl() {
        return telefone_Cl;
    }

    public void setTelefone_Cl(int telefone_Cl) {
        this.telefone_Cl = telefone_Cl;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
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
        final Pagamento other = (Pagamento) obj;
        if (Double.doubleToLongBits(this.montante) != Double.doubleToLongBits(other.montante)) {
            return false;
        }
        if (this.telefone_Cl != other.telefone_Cl) {
            return false;
        }
        if (Float.floatToIntBits(this.mensalidade) != Float.floatToIntBits(other.mensalidade)) {
            return false;
        }
        if (!Objects.equals(this.referencia_Cl, other.referencia_Cl)) {
            return false;
        }
        if (!Objects.equals(this.email_Cl, other.email_Cl)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public Pagamento clone(){
        return new Pagamento();
    }
    
    
    
}

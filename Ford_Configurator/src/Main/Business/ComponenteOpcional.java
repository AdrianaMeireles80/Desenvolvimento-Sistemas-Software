/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Business;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Nuno
 */
public class ComponenteOpcional{
    
    private int id_opc;
    private String nome_opc;
    private double preco_opc;
    private int stock_opc;
    private String compInComp;

    public ComponenteOpcional(String nome_opc, double preco_opc, int stock_opc, String compIncomp) {
        this.nome_opc = nome_opc;
        this.preco_opc = preco_opc;
        this.stock_opc=stock_opc;
        this.compInComp=compIncomp;
    }

    public ComponenteOpcional(){
        this.nome_opc="";
        this.preco_opc=0;
        this.stock_opc=0;
        this.compInComp="";
    }
    
    public ComponenteOpcional(ComponenteOpcional c){
        this.nome_opc=c.getNome();
        this.preco_opc=c.getPreco();
        this.stock_opc=c.getStock();
        this.compInComp=c.getCompInComp();        
    }
    
    public int getId() {
        return id_opc;
    }

    public void setId(int id_opc) {
        this.id_opc = id_opc;
    }

    public String getNome() {
        return nome_opc;
    }

    public void setNome(String nome_opc) {
        this.nome_opc = nome_opc;
    }

    public double getPreco() {
        return preco_opc;
    }

    public void setPreco(double preco_opc) {
        this.preco_opc = preco_opc;
    }

    public int getStock() {
        return stock_opc;
    }

    public void setStock(int stock_opc) {
        this.stock_opc = stock_opc;
    }

    public String getCompInComp() {
        return compInComp;
    }

    public void setCompInComp(String compInComp) {
        this.compInComp = compInComp;
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
        final ComponenteOpcional other = (ComponenteOpcional) obj;
        if (this.id_opc != other.id_opc) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco_opc) != Double.doubleToLongBits(other.preco_opc)) {
            return false;
        }
        if (this.stock_opc != other.stock_opc) {
            return false;
        }
        if (!Objects.equals(this.nome_opc, other.nome_opc)) {
            return false;
        }
        if (!Objects.equals(this.compInComp, other.compInComp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComponenteOpcional{" + "id_opc=" + id_opc + ", nome_opc=" + nome_opc + ", preco_opc=" + preco_opc + ", stock_opc=" + stock_opc + ", compInComp=" + compInComp + '}';
    }
    
    public ComponenteOpcional clone() {
        return new ComponenteOpcional(this) ;
        
    }
    
}

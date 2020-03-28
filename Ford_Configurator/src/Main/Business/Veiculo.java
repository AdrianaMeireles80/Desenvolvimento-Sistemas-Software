/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Main.Business;

/**
 *
 * @author oitenta80
 */

import java.util.Objects;

public class Veiculo {
    private int id_V;
    private String modelo;
    private int preco;
    
       
    public Veiculo() {
        
        id_V=0;
        modelo="";
        preco = 0;
    }
    
    public Veiculo(int id_V, String modelo, int preco) {
        this.id_V=id_V;
        this.modelo = modelo;
        this.preco = preco;
        
    }
    
    public Veiculo(Veiculo v){
        id_V = v.getid_V();
        modelo = v.getModelo();
        preco = v.getPreco();
    }

    /**
     * @return the id_V
     */
    public int getid_V() {
        return id_V;
    }

     /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }
    
     /**
     * @return the preco
     */
    public int getPreco() {
        return preco;
    }
    
    public Veiculo clone() {
        return new Veiculo(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public void setId_V(int id_V) {
        this.id_V = id_V;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco(int preco) {
        this.preco = preco;
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
        final Veiculo other = (Veiculo) obj;
        if (this.id_V != other.id_V) {
            return false;
        }
        if (this.preco != other.preco) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }

  
    
}

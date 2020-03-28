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
public class ComponenteObrigatoria {
    private int id_obg;
    private String nome_obg;
    private double preco_obg;
    private int stock_obg;

    public ComponenteObrigatoria() {
        nome_obg = "";
        preco_obg = 0.0;
        stock_obg = 0;   
    }
    
    public ComponenteObrigatoria(String nome_obg, double preco_obg, int stock_obg) {
        this.nome_obg=nome_obg;
        this.preco_obg = preco_obg;
        this.stock_obg = stock_obg;       
    }
    
    public ComponenteObrigatoria(ComponenteObrigatoria cO){
        id_obg = cO.getId();
        nome_obg=cO.getNome();
        preco_obg = cO.getPreco();
        stock_obg = cO.getStock();
    }

    /**
     * @return the id_obg
     */
    public int getId() {
        return id_obg;
    }

    /**
     * @return the preco_obg
     */
    public double getPreco() {
        return preco_obg;
    }

    /**
     * @param preco_obg the preco_obg to set
     */
    public void setPreco(double preco_obg) {
        this.preco_obg = preco_obg;
    }

    /**
     * @return the stock_obg
     */
    public int getStock() {
        return stock_obg;
    }

    /**
     * @param stock_obg the stock_obg to set
     */
    public void setStock(int stock_obg) {
        this.stock_obg = stock_obg;
    }

    /**
     * 
     * @return 
     */
    public String getNome() {
        return nome_obg;
    }

    /**
     * 
     * @param nome_obg 
     */
    public void setNome(String nome_obg) {
        this.nome_obg = nome_obg;
    }
   
    
    
    public ComponenteObrigatoria clone() {
        return new ComponenteObrigatoria(this) ;
        
    }
       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponenteObrigatoria comp = (ComponenteObrigatoria) o;

       return this.id_obg == comp.getId()
            && this.preco_obg== comp.getPreco()
            && this.stock_obg==comp.getStock();
         
    }
   
}
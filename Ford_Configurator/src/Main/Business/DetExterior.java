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
public class DetExterior extends Configuracao {
    private int id_Ext;
    private String designacao_ext;
    private double preco_ext;
    private int stock_ext;
    
    public DetExterior(){
        this.id_Ext =0;
        this.designacao_ext="";
        this.preco_ext = 0.0;
        this.stock_ext = 0;
    }
    
    public DetExterior(String designacao_ext, double preco_ext,int stock_ext){
        this.id_Ext = id_Ext;
        this.designacao_ext=designacao_ext;
        this.preco_ext = preco_ext;
        this.stock_ext = stock_ext;
    }

    public DetExterior(DetExterior de){
        id_Ext = de.getId();
        designacao_ext=de.getDesignacao();
        preco_ext = de.getPreco();
        stock_ext = de.getStock();
    }
    
    /**
     * @return the id_Ext
     */
    public int getId() {
        return id_Ext;
    }

    /**
     * @return the preco_ext
     */
    public double getPreco() {
        return preco_ext;
    }

    /**
     * @param preco_ext the preco_ext to set
     */
    public void setPreco(double preco_ext) {
        this.preco_ext = preco_ext;
    }

    /**
     * @return the stock_ext
     */
    public int getStock() {
        return stock_ext;
    }
    
    public String getDesignacao(){
        return designacao_ext;
    }

    /**
     * @param stock_ext the stock_ext to set
     */
    public void setStock(int stock_ext) {
        this.stock_ext = stock_ext;
    }
    
    public DetExterior clone(){
        return new DetExterior(this);
    }
      
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetExterior de = (DetExterior) o;

       return this.id_Ext == de.getId()
            && this.preco_ext== de.getPreco()
            && this.stock_ext==de.getStock();
         
    }
}

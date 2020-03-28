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
public class DetInterior{
    private int id_Int;
    private double preco_Int;
    private String designacao_Int;
    private int stock_int;
    
    public DetInterior(){
        this.id_Int =0;
        this.preco_Int = 0.0;
        this.designacao_Int="";
        this.stock_int = 0;
    }
    
    public DetInterior(double preco_Int, String designacao_Int, int stock_int){
        this.preco_Int = preco_Int;
        this.designacao_Int=designacao_Int;
        this.stock_int = stock_int;
    }

    public DetInterior(DetInterior di){
        id_Int = di.getId();
        preco_Int = di.getPreco();
        designacao_Int = di.getDesignacao();
        stock_int = di.getStock();
    }
    
    
    /**
     * @return the id_Int
     */
    public int getId() {
        return id_Int;
    }

    /**
     * @return the preco_Int
     */
    public double getPreco() {
        return preco_Int;
    }

    /**
     * @param preco_Int the preco_Int to set
     */
    public void setPreco(double preco_Int) {
        this.preco_Int = preco_Int;
    }

    /**
     * @return the stock_int
     */
    public int getStock() {
        return stock_int;
    }
    
    public String getDesignacao(){
        return designacao_Int;
    }

    /**
     * @param stock_int the stock_int to set
     */
    public void setStock(int stock_int) {
        this.stock_int = stock_int;
    }
    public DetInterior clone(){
        return new DetInterior(this);
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetInterior di = (DetInterior) o;

       return this.id_Int == di.getId()
            && this.preco_Int== di.getPreco()
            && this.stock_int==di.getStock();
         
    }
    
}

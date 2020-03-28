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
public class Fabrica {
    private int id;
    private int stock;
    
    public Fabrica(){
        this.id = 0;
        this.stock = 0;        
    }
    
    public Fabrica(int id,int stock){
        this.id = id;
        this.stock = stock;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
    public Fabrica clone(){
        return new Fabrica(this);
    }
    */
    
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fabrica f = (Fabrica) o;

       return this.id == f.getId()
            && this.stock== f.getStock();
         
}
    
}

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
public class Pacote {
   private int id;
   private String nome;
   private double preco;
   private double desconto;
   
    public Pacote(){
       this.id = 0;
       this.nome=null;
       this.preco= 0.0;
       this.desconto = 0.0;
    }
    
    public Pacote(int id,String nome,double preco,double desconto){
       this.id = id;
       this.nome = nome;
       this.preco = preco;
       this.desconto = desconto;
    }

    public Pacote(Pacote p){
        id = p.getId();
        nome = p.getNome();
        preco = p.getPreco();
        desconto = p.getDesconto();
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    public Pacote clone(){
        return new Pacote(this);
    }
    
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pacote pac = (Pacote) o;

       return this.id == pac.getId()
            && this.preco== pac.getPreco()
            && this.nome.equals(pac.getNome())
            && this.desconto==pac.getDesconto();
         
}
   
}

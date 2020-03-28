/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Business;

/**
 *
 * @author Nuno
 */
public class NumeroException extends Exception{
    
    public NumeroException(String erro){
        System.out.println(erro);
    }
}

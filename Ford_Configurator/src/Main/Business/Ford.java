/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Business;

import Main.Data.ComponenteObrigatoriaDAO;
import Main.Data.ComponenteOpcionalDAO;
import Main.Data.Connect;
import Main.Data.DetExteriorDAO;
import Main.Data.DetInteriorDAO;
import Main.Data.UtilizadorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nuno
 */
public class Ford {
 
    //pessoa que ira iniciar a sessao
    private Utilizador user;
    private Connection conn;
    private UtilizadorDAO userDAO;

     /**
     * Construtor vazio de ford
     */
    public Ford(){
        user = null;
        userDAO = new UtilizadorDAO();
    }
    
    public Utilizador getSessao(){
        return user;
    }
    

    /**
     * Vai iniciar a sessao de um utilizador
     * @param username
     * @param password
     * @throws NumeroException 
     */
    public void iniciarSessao(String username, String password) throws UsernameException{
        Utilizador u = null;
        try{
            if(userDAO.containsKey(username)){
                u = userDAO.get(username);
                if(u.getPassword().equals(password)){
                    user=u;
                }
            }
        }catch(Exception e){
            throw new UsernameException(e.getMessage());
        }
    }
    
    /**
     * Vai adicionar um novo utilizador
     * @param numero
     * @param email
     * @param username
     * @param password 
     */
    public void adcionaUtilizador(String numero, String email, String username, String password){
        Utilizador u = new Utilizador(Integer.parseInt(numero), email, username, password);
        userDAO.put(u.getUsername(),u);
    }
    
    /**
     * Vai remover um utlizador
     * @param numero 
     */
    public void removerUtilizador(String numero){
        userDAO.remove(numero);
    }

    /**
     * Vai retornar todos os utilizadores presentes na base dados
     * @return 
     */
    public Collection<Utilizador> getUtilizadores(){
        return userDAO.values();
    }
    
    /**
     * 
     * @param coDAO
     * @param copDAO
     * @param dextDAO
     * @param dintDAO
     * @return 
     */
    public HashMap<String,Integer> listaPecas(ComponenteObrigatoriaDAO coDAO, ComponenteOpcionalDAO copDAO,
            DetExteriorDAO dextDAO, DetInteriorDAO dintDAO){
        
        HashMap<String,Integer> pecas = new HashMap<>();
        
        pecas.putAll(coDAO.getPecaCOB());
        pecas.putAll(copDAO.getPecaCOP());
        pecas.putAll(dextDAO.getPecaDEXT());
        pecas.putAll(dintDAO.getPecaDINT());
        
        return pecas;
    }
    
    
     /**
     * Vai dar um update a base dados caso haja uma alteracao ao preco
     * @param key
     * @param value
     * @param novoPreco 
     */
    public void updatePrecoCOB(String key, ComponenteObrigatoriaDAO value, int novoPreco){
	try{
		conn = Connect.connect();
		PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteObrigatoria\n" +
                "VALUES (?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE nome=VALUES(nome), "
                    + " preco=VALUES(preco), stock=VALUES(stock))"
                    , Statement.RETURN_GENERATED_KEYS);
		stm.setString(1,key);
		stm.setInt(2, novoPreco);
		stm.setInt(3,value.get(key).getStock());
		stm.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		Connect.close(conn);
	}
    }    

    /**
     * Vai dar um update a base dados caso haja uma alteracao ao preco
     * @param key
     * @param value
     * @param novoPreco 
     */
    public void updatePrecoCOP(String key, ComponenteOpcionalDAO value, int novoPreco){
	try{
		conn = Connect.connect();
		PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteOpcional\n" +
                "VALUES (?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE nome=VALUES(nome), "
                    + " preco=VALUES(preco), stock=VALUES(stock))"
                    , Statement.RETURN_GENERATED_KEYS);
		stm.setString(1,key);
		stm.setInt(2, novoPreco);
		stm.setInt(3,value.get(key).getStock());
		stm.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		Connect.close(conn);
	}
    }

    /**
     * Vai dar um update a base dados caso haja uma alteracao ao preco
     * @param key
     * @param value
     * @param novoPreco 
     */
    public void updatePrecoDEXT(String key, DetExteriorDAO value, int novoPreco){
	try{
		conn = Connect.connect();
		PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteOpcional\n" +
                "VALUES (?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE designacao=VALUES(designacao), "
                    + " preco=VALUES(preco), stock=VALUES(stock))"
                    , Statement.RETURN_GENERATED_KEYS);
		stm.setString(1,key);
		stm.setInt(2, novoPreco);
		stm.setInt(3,value.get(key).getStock());
		stm.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		Connect.close(conn);
	}
    }

    /**
     * Vai dar um update a base dados caso haja uma alteracao ao preco
     * @param key
     * @param value
     * @param novoPreco 
     */
    public void updatePrecoDINT(String key, DetInteriorDAO value, int novoPreco){
	try{
		conn = Connect.connect();
		PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteOpcional\n" +
                "VALUES (?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE preco=VALUES(preco),"
                    + " designacao=VALUES(designacao), stock=VALUES(stock))"
                    , Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, novoPreco);
 		stm.setString(2,key);               
		stm.setInt(3,value.get(key).getStock());
		stm.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		Connect.close(conn);
	}
    }
}

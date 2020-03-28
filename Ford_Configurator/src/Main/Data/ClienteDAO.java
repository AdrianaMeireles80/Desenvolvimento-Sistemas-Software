/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.Cliente;
import Main.Business.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nuno
 */
public class ClienteDAO implements Map<Integer,Cliente> {

    private Connection conn;
    
    //Apagar todos os utilizadores
    @Override
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM cliente WHERE nif_cl>0");
            
        } catch (Exception e) {
            //runtime exception
            throw new NullPointerException(e.getMessage());
        }finally{
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se cliente existe
     * @key
     * @return
     * @throws NullPointerException
     */
    public boolean  containsKey(Object key) throws NullPointerException{
        boolean r = false;
        
        try{ 
            conn = Connect.connect();
            String sql = ("SELECT * FROM cliente  WHERE nif_cl = ?");
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,Integer.toString((Integer)key));
            ResultSet rs = stm.executeQuery();
            r=rs.next();
            
        }catch(Exception e){
            throw new NullPointerException(e.getMessage());
        }finally{
            Connect.close(conn);
        }
        
        return r;
    }
    
    /**
     * Verifica se um cliente existe na base de dados
     * 
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(Object value){
        Cliente a = (Cliente) value;
        return containsKey(a.getNif_cl());
    }
    
    @Override
    public Set<Map.Entry<Integer,Cliente>> entrySet(){
        throw new NullPointerException("public Set<Map.Entry<Integer,Cliente>> is not implemented!");
    }
    
    @Override
    public boolean equals(Object o){
        throw new NullPointerException("public boolean equals(Object o) is not implemented!");
    }
    
    /**
     * Obter um utilizador, dado o seu username
     * @param key
     * @return
     */
    public Cliente get(Object key){
        Cliente ad = new Cliente();
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM cliente WHERE nif_cl=?;");
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ad.setNif_cl(rs.getInt("nif_cl"));
                ad.setEmail_cl(rs.getString("email_cl"));
                ad.setEmail_cl(rs.getString("morada_cl"));
                ad.setEmail_cl(rs.getString("nome_cl"));
            }
        }catch(Exception e){
            e.printStackTrace();            
        }finally{
            Connect.close(conn);
        }
       
        return ad;
    }
      
    @Override
    public int hashCode() {
        return this.conn.hashCode();
    }
    
    /**
     * Verifica se existem entradas
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public Set<Integer> keySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    /**
     * Insere um cliente na base de dados
     * @param key
     * @param value
     * @return 
     */
    public Cliente put(Integer key, Cliente value) {
        Cliente al = null;
        try {
            conn = Connect.connect();
            
            //Insert em cliente
            PreparedStatement stm = conn.prepareStatement("INSERT INTO cliente\n" +
                "VALUES (?, ?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE nif_cl=VALUES(nif_cl), "
                    + "email_cl=VALUES(email_cl),"
                    + " morada_cl=VALUES(morada_cl), nome_cl=VALUES(nome_cl))"
                    , Statement.RETURN_GENERATED_KEYS);            
            stm.setInt(1, value.getNif_cl());
            stm.setString(2, value.getEmail_cl());
            stm.setString(3, value.getMorada_cl());
            stm.setString(4, value.getNome_cl());
            stm.executeUpdate();
            
            //update na tabela configuracao
            PreparedStatement stmConf = conn.prepareStatement("UPDATE configuracao "
                    + "SET nif_cl=VALUES(nif_cl) WHERE nif_cl=0;");
            stmConf.executeUpdate();
            
            
            al = value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return al;
    }

    /**
     * Por um conjunto de utilizadors na base de dados
     * @param t 
     */
    @Override
    public void putAll(Map<? extends Integer,? extends Cliente> t) {
        for(Cliente a : t.values()) {
            put(a.getNif_cl(), a);
        }
    }
    
    /**
     * Remover um cliente, dado o seu username
     * @param key
     * @return 
     */
    @Override
    public Cliente remove(Object key) {
        Cliente al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM cliente WHERE nif_cl=?;");
            stm.setString(1,Integer.toString((Integer)key));
            stm.executeUpdate();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
        return al;
    }
    
    /**
     * Retorna o número de entradas na base de dados
     * @return 
     */
  @Override
    public int size() {
        int size = -1;

        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) from cliente WHERE nif_cl>0");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size = rs.getInt(1);
            }
        }
        catch(SQLException e){
             System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                 System.out.printf(e.getMessage());
            }
        }
        return size;
}
    
    /**
     * Obtém todos os utilizadors da base de dados
     * @return 
     */
    @Override
    public Collection<Cliente> values() {
        Collection<Cliente> col = new HashSet<Cliente>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                Cliente al = new Cliente(rs.getInt("nif_cl"),rs.getString("morada_cl"), 
                        rs.getString("email_cl"), rs.getString("nome_cl")); 
                col.add(al);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Connect.close(conn);
        }
        return col;
    }         
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuno
 */
public class UtilizadorDAO implements Map<String,Utilizador>{

    private Connection conn;
    
    //Apagar todos os utilizadores
    @Override
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM utilizador WHERE numero>0");
            
        } catch (Exception e) {
            //runtime exception
            throw new NullPointerException(e.getMessage());
        }finally{
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se utilizador existe
     * @key
     * @return
     * @throws NullPointerException
     */
    public boolean  containsKey(Object key) throws NullPointerException{
        boolean r = false;
        
        try{ 
            conn = Connect.connect();
            String sql = ("SELECT * FROM utilizador  WHERE usernameU = ?");
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,(String)key);
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
     * Verifica se um utilizador existe na base de dados
     * 
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(Object value){
        Utilizador a = (Utilizador) value;
        return containsKey(a.getUsername());
    }
    
    @Override
    public Set<Map.Entry<String,Utilizador>> entrySet(){
        throw new NullPointerException("public Set<Map.Entry<Integer,Utilizador>> is not implemented!");
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
    public Utilizador get(Object key){
        Utilizador ad = new Utilizador();
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM utilizador WHERE usernameU=?;");
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ad.setNumero(rs.getInt("numero"));
                ad.setEmail_utilizador(rs.getString("email_utilizador"));
                ad.setUsername(rs.getString("usernameU")); 
                ad.setPassword(rs.getString("passwordU"));  
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
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    /**
     * Insere um utilizador na base de dados
     * @param key
     * @param value
     * @return 
     */
    public Utilizador put(String key, Utilizador value) {
        Utilizador al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO utilizador\n" +
                "VALUES (?, ?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE numero=VALUES(numero), "
                    + "email_utilizador=VALUES(email_utilizador),"
                    + " usernameU=VALUES(usernameU), passwordU=VALUES(passwordU))"
                    , Statement.RETURN_GENERATED_KEYS);            
            stm.setInt(1, value.getNumero());
            stm.setString(2, value.getEmail_utilizador());
            stm.setString(3, value.getUsername());
            stm.setString(4, value.getPassword());
            stm.executeUpdate();
            
            al = value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return al;
    }
    
    /**
     * Vai dar inicio a uma configuracao
     * @param value 
     */
    public void iniciaConf(Utilizador value){
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Configuracao\n" +
                "VALUES (?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE nome=VALUES(nomeU), utilizador_id_utilizador=VALUES(id_utilizador),"
                    + "cliente_nif_cl=VALUES(nif_cl)", Statement.RETURN_GENERATED_KEYS);            
            stm.setString(1, "vazio");
            stm.setInt(2, value.getId_utilizador());
            stm.setInt(3, 0);
            stm.executeUpdate();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
    }
    
    /**
     * Por um conjunto de utilizadors na base de dados
     * @param t 
     */
    @Override
    public void putAll(Map<? extends String,? extends Utilizador> t) {
        for(Utilizador a : t.values()) {
            put(a.getUsername(), a);
        }
    }
    
    /**
     * Remover um utilizador, dado o seu username
     * @param key
     * @return 
     */
    @Override
    public Utilizador remove(Object key) {
        Utilizador al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM utilizador WHERE usernameU REGEXP('?')");
            stm.setString(1, (String)key);
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
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) from utilizador WHERE numero = '?'");
            ps.setString(1,"1");
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
    public Collection<Utilizador> values() {
        Collection<Utilizador> col = new HashSet<Utilizador>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM utilizador");
            while (rs.next()) {
                Utilizador al = new Utilizador(rs.getInt("numero"),rs.getString("email_utilizador"), 
                        rs.getString("usernameU"), rs.getString("passwordU")); 
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
    
/**
 * retorna uma arraylist com os username dos utilizadores do tipo Funcionario
 * @return
 * @throws SQLException 
 */   
    public ArrayList<String> getFuncionario() throws SQLException{
        ArrayList<String> lista = new ArrayList<String>();
        
        try{
            conn = Connect.connect();
            String sql = ("SELECT * FROM utilizador WHERE numero=1;");
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               Utilizador al = new Utilizador(rs.getInt("numero"),rs.getString("email_utilizador"), 
                        rs.getString("usernameU"), rs.getString("passwordU")); 
                lista.add(al.getUsername()); 
            }        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Connect.close(conn);
        }
        
        return lista;
    }

/**
 * retorna uma arraylist com os username dos utilizadores do tipo Administrador
 * @return
 * @throws SQLException 
 */   
    public ArrayList<String> getAdministrador() throws SQLException{
        ArrayList<String> lista = new ArrayList<String>();
        
        try{
            conn = Connect.connect();
            String sql = ("SELECT * FROM utilizador WHERE numero=2;");
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               Utilizador al = new Utilizador(rs.getInt("numero"),rs.getString("email_utilizador"), 
                        rs.getString("usernameU"), rs.getString("passwordU")); 
                
               lista.add(al.getUsername()); 
            }        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Connect.close(conn);
        }
        
        return lista;
    } 

/**
 * retorna uma arraylist com os username dos utilizadores do tipo Fabricante
 * @return
 * @throws SQLException 
 */
    public ArrayList<String> getFabricante() throws SQLException{
        ArrayList<String> lista = new ArrayList<String>();
        
        try{
            conn = Connect.connect();
            String sql = ("SELECT * FROM utilizador WHERE numero=3;");
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               Utilizador al = new Utilizador(rs.getInt("numero"),rs.getString("email_utilizador"), 
                        rs.getString("usernameU"), rs.getString("passwordU")); 
                lista.add(al.getUsername()); 
            }        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Connect.close(conn);
        }
        
        return lista;
    }    
}

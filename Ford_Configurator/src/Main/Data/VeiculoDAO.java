/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nuno
 */
public class VeiculoDAO implements Map<Integer,Veiculo> {

    private Connection conn;
    
    //Apagar todos os veiculos
    @Override
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM veiculo WHERE idV>0");
            
        } catch (Exception e) {
            //runtime exception
            throw new NullPointerException(e.getMessage());
        }finally{
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se veiculo existe
     * @key
     * @return
     * @throws NullPointerException
     */
    public boolean  containsKey(Object key) throws NullPointerException{
        boolean r = false;
        
        try{ 
            conn = Connect.connect();
            String sql = ("SELECT * FROM veiculo  WHERE modelo = ?");
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
     * Verifica se um veiculo existe na base de dados
     * 
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(Object value){
        Veiculo a = (Veiculo) value;
        return containsKey(a.getid_V());
    }
    
    @Override
    public Set<Map.Entry<Integer,Veiculo>> entrySet(){
        throw new NullPointerException("public Set<Map.Entry<Integer,Veiculo>> is not implemented!");
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
    public Veiculo get(Object key){
        Veiculo ad = new Veiculo();
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM veiculo WHERE modelo=?;");
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ad.setId_V(rs.getInt("Id_V"));
                ad.setModelo(rs.getString("modelo"));
                ad.setPreco(rs.getInt("precoV"));
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
     * Insere um veiculo na base de dados
     * @param key
     * @param value
     * @return 
     */
    public Veiculo put(Integer key, Veiculo value) {
        Veiculo al = null;
        try {
            conn = Connect.connect();
            
            //Insert em veiculo
            PreparedStatement stm = conn.prepareStatement("INSERT INTO veiculo\n" +
                "VALUES (?, ?,0)\n" +
                "ON DUPLICATE KEY UPDATE modeloV=VALUES(modeloV), "
                    + "precoV=VALUES(precoV), Configuracao_idC=VALUES(Configuracao_idC)"
                    , Statement.RETURN_GENERATED_KEYS);            
            stm.setString(1, value.getModelo());
            stm.setInt(2, value.getPreco());
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
    public void putAll(Map<? extends Integer,? extends Veiculo> t) {
        for(Veiculo a : t.values()) {
            put(a.getid_V(), a);
        }
    }
    
    /**
     * Remover um veiculo, dado o seu username
     * @param key
     * @return 
     */
    @Override
    public Veiculo remove(Object key) {
        Veiculo al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM veiculo WHERE modeloV=?;");
            stm.setString(1,al.getModelo());
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
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) from veiculo WHERE id_V>0");
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
    public Collection<Veiculo> values() {
        Collection<Veiculo> col = new HashSet<Veiculo>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM veiculo");
            while (rs.next()) {
                Veiculo al = new Veiculo(rs.getInt("id_V"), rs.getString("modeloV"), rs.getInt("precoV")); 
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.DetExterior;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nuno
 */
public class DetExteriorDAO implements Map<Integer,DetExterior>{
    
    private Connection conn; //objeto da classe connect
    
    /**
     * Apagar todos os detalhes 
     */
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM detExterior WHERE id_Ext>0");
        }catch(Exception e){
            //runtime exception!
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se um nome de detExterior existe na base de dados
     * @param key
     * @return
     * @throws NullPointerException 
     */
    
    public boolean containsKey(Object key) throws NullPointerException{
       boolean r = false;
       
       try{
           conn = Connect.connect();
           String sql = "SELECT 'designacao_ext' FROM 'detExterior' WHERE REGEXP(?);";
           PreparedStatement stm = conn.prepareStatement(sql);
           stm.setString(1, key.toString());
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
     * Verifica se um detExterior existe na base de dados
     * 
     * Esta implementação é provisória. Devia testar todo o objecto e não apenas a chave.
     * 
     * @param value
     * @return 
     */
    @Override
    public boolean containsValue(Object value) {
        DetExterior a = (DetExterior) value;
        return containsKey(a.getId());
    }
    
    @Override
    public Set<Map.Entry<Integer,DetExterior>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<Integer,DetExterior>> entrySet() not implemented!");
    }
    
    @Override
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }
    
    
    
               
    /**
     * Obter um detExterior, dado o seu número
     * @param key
     * @return 
     */
    @Override
    public DetExterior get(Object key) {
        DetExterior al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM detExterior WHERE REGEXP(?)");
            stm.setString(1,key.toString());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                al = new DetExterior(rs.getString("designacao_ext"), 
                        rs.getDouble("preco_ext"), rs.getInt("stock_ext"));
            }       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return al;
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
     * Insere um detExterior na base de dados
     * @param key
     * @param value
     * @return 
     */
    public DetExterior put(String key, DetExterior value) {
        DetExterior al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO detExterior\n" +
                "VALUES (?, ?, ?)\n" +
                "(designacao_ext=VALUES(designacao_ext), preco_ext=VALUES(preco_ext), stock_ext=VALUES(stock_ext))", Statement.RETURN_GENERATED_KEYS);            
            stm.setString(1, value.getDesignacao());
            stm.setDouble(2, value.getPreco());
            stm.setInt(3,value.getStock());
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
     * Por um conjunto de funcionarios na base de dados
     * @param t 
     */
    @Override
    public void putAll(Map<? extends Integer,? extends DetExterior> t) {
        for(DetExterior a : t.values()) {
            put(a.getId(), a);
        }
    }
    
    /**
     * Remover um detExterior, dado o seu nome
     * @param key
     * @return 
     */
    @Override
    public DetExterior remove(Object key) {
        DetExterior al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM detExterior WHERE REGEXP(?)");
            stm.setString(1, key.toString());
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
        int i = 0;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM detExterior");
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
        finally {
            Connect.close(conn);
        }
        return i;
    }
    
    /**
     * Obtém todos os funcionarios da base de dados
     * @return 
     */
    @Override
    public Collection<DetExterior> values() {
        Collection<DetExterior> col = new HashSet<DetExterior>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM detExterior");
            while (rs.next()) {
                DetExterior al = new DetExterior(rs.getString("designacao_ext"), 
                        rs.getDouble("preco_ext"), rs.getInt("stock_ext"));  
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
     * vai obter todas as pecas e o seu respetivo stock_ext
     * @return 
     */
    public HashMap<String,Integer> getPecaDEXT(){
        HashMap<String,Integer> lista = new HashMap<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM detExterior");
            while (rs.next()) {
                DetExterior al = new DetExterior(rs.getString("designacao_ext"), 
                        rs.getDouble("preco_ext"), rs.getInt("stock_ext"));
                lista.put(al.getDesignacao(),al.getStock());    
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            Connect.close(conn);
        }
        return lista;
    }
    
    @Override
    public DetExterior put(Integer key, DetExterior value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

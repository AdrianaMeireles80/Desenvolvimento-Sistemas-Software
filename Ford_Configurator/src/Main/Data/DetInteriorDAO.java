/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.DetInterior;
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
public class DetInteriorDAO implements Map<Integer,DetInterior>{
    
    private Connection conn; //objeto da classe connect
    
    /**
     * Apagar todos os detalhes 
     */
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM detInterior WHERE id_Int>0");
        }catch(Exception e){
            //runtime exception!
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se um nome de detInterior existe na base de dados
     * @param key
     * @return
     * @throws NullPointerException 
     */
    
    public boolean containsKey(Object key) throws NullPointerException{
       boolean r = false;
       
       try{
           conn = Connect.connect();
           String sql = "SELECT 'designacao_Int' FROM 'detInterior' WHERE REGEXP(?);";
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
     * Verifica se um detInterior existe na base de dados
     * 
     * Esta implementação é provisória. Devia testar todo o objecto e não apenas a chave.
     * 
     * @param value
     * @return 
     */
    
    public boolean containsValue(Object value) {
        DetInterior a = (DetInterior) value;
        return containsKey(a.getId());
    }
    
    public Set<Map.Entry<Integer,DetInterior>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<Integer,DetInterior>> entrySet() not implemented!");
    }
    
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }
    
    
    
               
    /**
     * Obter um detInterior, dado o seu número
     * @param key
     * @return 
     */
    public DetInterior get(Object key) {
        DetInterior al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM detInterior WHERE REGEXP(?)");
            stm.setString(1,(String)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                al = new DetInterior(rs.getDouble("preco_Int"), rs.getString("designacao_Int"), rs.getInt("stock_int"));  
            }       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return al;
    }
    
    public int hashCode() {
        return this.conn.hashCode();
    }
    
    /**
     * Verifica se existem entradas
     * @return 
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public Set<Integer> keySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    /**
     * Insere um detInterior na base de dados
     * @param key
     * @param value
     * @return 
     */
    public DetInterior put(String key, DetInterior value) {
        DetInterior al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO detInterior\n" +
                "VALUES (?, ?, ?)\n" +
                "(designacao_Int=VALUES(designacao_Int), preco_Int=VALUES(preco_Int), stock_int=VALUES(stock_int))", Statement.RETURN_GENERATED_KEYS);            
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
    public void putAll(Map<? extends Integer,? extends DetInterior> t) {
        for(DetInterior a : t.values()) {
            put(a.getId(), a);
        }
    }
    
    /**
     * Remover um detInterior, dado o seu nome
     * @param key
     * @return 
     */
    public DetInterior remove(Object key) {
        DetInterior al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM detInterior WHERE REGEXP(?)");
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
    public int size() {
        int i = 0;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM detInterior");
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
    public Collection<DetInterior> values() {
        Collection<DetInterior> col = new HashSet<DetInterior>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM detInterior");
            while (rs.next()) {
                DetInterior al = new DetInterior(rs.getDouble("preco_Int"), 
                        rs.getString("designacao_Int"), rs.getInt("stock_int"));      
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
     * vai obter todas as pecas e o seu respetivo stock_int
     * @return 
     */
    public HashMap<String,Integer> getPecaDINT(){
        HashMap<String,Integer> lista = new HashMap<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM detInterior");
            while (rs.next()) {
                DetInterior al = new DetInterior(rs.getDouble("preco_Int"), 
                        rs.getString("designacao_Int"), rs.getInt("stock_int"));  
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
    public DetInterior put(Integer key, DetInterior value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.ComponenteObrigatoria;
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
public class ComponenteObrigatoriaDAO implements Map<Integer,ComponenteObrigatoria>{
    
    private Connection conn; //objeto da classe connect
    
    /**
     * Apagar todos os componentes obrigatorias 
     */
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM componenteObrigatoria WHERE id_obg>0");
        }catch(Exception e){
            //runtime exception!
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se um id_obg de componenteObrigatoria existe na base de dados
     * @param key
     * @return
     * @throws NullPointerException 
     */
    
    public boolean containsKey(Object key) throws NullPointerException{
       boolean r = false;
       
       try{
           conn = Connect.connect();
           String sql = "SELECT 'id_obg' FROM 'componenteObrigatoria' WHERE id_obg=?;";
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
     * Verifica se um componenteObrigatoria existe na base de dados
     * 
     * Esta implementação é provisória. Devia testar todo o objecto e não apenas a chave.
     * 
     * @param value
     * @return 
     */
    @Override
    public boolean containsValue(Object value) {
        ComponenteObrigatoria a = (ComponenteObrigatoria) value;
        return containsKey(a.getId());
    }
    
    @Override
    public Set<Map.Entry<Integer,ComponenteObrigatoria>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<Integer,ComponenteObrigatoria>> entrySet() not implemented!");
    }
    
    @Override
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }
    
    
    
               
    /**
     * Obter um componenteObrigatoria, dado o seu id_obg
     * @param key
     * @return 
     */
    @Override
    public ComponenteObrigatoria get(Object key) {
        ComponenteObrigatoria al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM componenteObrigatoria WHERE id_obg=?");
            stm.setString(1,key.toString());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                al = new ComponenteObrigatoria(rs.getString("nome_obg"), rs.getDouble("preco_obg"), rs.getInt("stock_obg"));  
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
     * Insere um componenteObrigatoria na base de dados
     * @param key
     * @param value
     * @return 
     */
    public ComponenteObrigatoria put(String key, ComponenteObrigatoria value) {
        ComponenteObrigatoria al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteObrigatoria\n" +
                "VALUES (?, ?, ?)\n" +
                "(nome_obg=VALUES(nome_obg), preco_obg=VALUES(preco_obg), stock_obg=VALUES(stock_obg)", Statement.RETURN_GENERATED_KEYS);            
            stm.setString(1, value.getNome());
            stm.setDouble(2, value.getPreco());
            stm.setDouble(3, value.getStock());
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
     * Por um conjunto de componentes obrigatorias na base de dados
     * @param t 
     */
    @Override
    public void putAll(Map<? extends Integer,? extends ComponenteObrigatoria> t) {
        for(ComponenteObrigatoria a : t.values()) {
            put(a.getId(), a);
        }
    }
    
    /**
     * Remover um componenteObrigatoria, dado o seu id_obg
     * @param key
     * @return 
     */
    @Override
    public ComponenteObrigatoria remove(Object key) {
        ComponenteObrigatoria al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM componenteObrigatoria WHERE id_obg=?");
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
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM componenteObrigatoria");
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
     * Obtém todos os componentes obrigatorias da base de dados
     * @return 
     */
    @Override
    public Collection<ComponenteObrigatoria> values() {
        Collection<ComponenteObrigatoria> col = new HashSet<ComponenteObrigatoria>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM componenteObrigatoria");
            while (rs.next()) {
                ComponenteObrigatoria al = new ComponenteObrigatoria(rs.getString("nome_obg"), 
                        rs.getDouble("preco_obg"), rs.getInt("stock_obg"));  
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
     * vai obter todas as pecas e o seu respetivo stock_obg
     * @return 
     */
    public HashMap<String,Integer> getPecaCOB(){
        HashMap<String,Integer> lista = new HashMap<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM componenteObrigatoria");
            while (rs.next()) {
                ComponenteObrigatoria al = new ComponenteObrigatoria(rs.getString("nome_obg"), 
                        rs.getDouble("preco_obg"), rs.getInt("stock_obg"));
                lista.put(al.getNome(),al.getStock());    
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            Connect.close(conn);
        }
        return lista;
    }


    public HashMap<Integer,String> getComponente(Object nome){
        HashMap<Integer,String> lista = new HashMap<>();
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM componenteObrigatoria WHERE nome_obg REGEXP(?)");
            stm.setString(1,nome.toString());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ComponenteObrigatoria al = new ComponenteObrigatoria(rs.getString("nome_obg"), rs.getDouble("preco_obg"), rs.getInt("stock_obg"));  
                
                lista.put(al.getId(),al.getNome());
            }       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return lista;
    }
    
    @Override
    public ComponenteObrigatoria put(Integer key, ComponenteObrigatoria value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

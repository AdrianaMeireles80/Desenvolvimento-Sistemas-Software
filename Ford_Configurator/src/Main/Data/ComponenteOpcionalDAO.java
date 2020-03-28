/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.ComponenteOpcional;
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
public class ComponenteOpcionalDAO implements Map<Integer,ComponenteOpcional>{
    
    private Connection conn; //objeto da classe connect
    
    /**
     * Apagar todos os funcionarios 
     */
    public void clear(){
        try{
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM componenteOpcional WHERE id_opc>0");
        }catch(Exception e){
            //runtime exception!
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
    }
    
    /**
     * Verifica se um id_opc de componenteOpcional existe na base de dados
     * @param key
     * @return
     * @throws NullPointerException 
     */
    
    public boolean containsKey(Object key) throws NullPointerException{
       boolean r = false;
       
       try{
           conn = Connect.connect();
           String sql = "SELECT 'id_opc' FROM 'componenteOpcional' WHERE id_opc=?;";
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
     * Verifica se um componenteOpcional existe na base de dados
     * 
     * Esta implementação é provisória. Devia testar todo o objecto e não apenas a chave.
     * 
     * @param value
     * @return 
     */
    @Override
    public boolean containsValue(Object value) {
        ComponenteOpcional a = (ComponenteOpcional) value;
        return containsKey(a.getId());
    }
    
    @Override
    public Set<Map.Entry<Integer,ComponenteOpcional>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<Integer,ComponenteOpcional>> entrySet() not implemented!");
    }
    
    @Override
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }
    
    
    
               
    /**
     * Obter um componenteOpcional, dado o seu id_opc
     * @param key
     * @return 
     */
    @Override
    public ComponenteOpcional get(Object key) {
        ComponenteOpcional al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM componenteOpcional WHERE id_opc=?");
            stm.setString(1,key.toString());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                al = new ComponenteOpcional(rs.getString("nome_opc"), 
                        rs.getDouble("preco_opc"), rs.getInt("stock_opc"), rs.getString("compIncomp"));  
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
     * Insere um componenteOpcional na base de dados
     * @param key
     * @param value
     * @return 
     */
    public ComponenteOpcional put(String key, ComponenteOpcional value) {
        ComponenteOpcional al = null;
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO componenteOpcional\n" +
                "VALUES (?, ?, ?)\n" +
                "(nome_opc=VALUES(nome_opc), preco_opc=VALUES(preco_opc), "
                    + "stock_opc=VALUES(stock_opc), compIncomp=VALUES(compIncomp)", Statement.RETURN_GENERATED_KEYS);            
            stm.setString(1, value.getNome());
            stm.setDouble(2, value.getPreco());
            stm.setDouble(3, value.getStock());
            stm.setString(4, value.getCompInComp());
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
    public void putAll(Map<? extends Integer,? extends ComponenteOpcional> t) {
        for(ComponenteOpcional a : t.values()) {
            put(a.getId(), a);
        }
    }
    
    /**
     * Remover um componenteOpcional, dado o seu id_opc
     * @param key
     * @return 
     */
    @Override
    public ComponenteOpcional remove(Object key) {
        ComponenteOpcional al = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM componenteOpcional WHERE id_opc=?");
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
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM componenteOpcional");
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
    public Collection<ComponenteOpcional> values() {
        Collection<ComponenteOpcional> col = new HashSet<ComponenteOpcional>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM componenteOpcional");
            while (rs.next()) {
                ComponenteOpcional al = new ComponenteOpcional(rs.getString("nome_opc"), 
                        rs.getDouble("preco_opc"), rs.getInt("stock_opc"), rs.getString("compIncomp"));  
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
     * vai obter todas as pecas e o seu respetivo stock_opc
     * @return 
     */
    public HashMap<String,Integer> getPecaCOP(){
        HashMap<String,Integer> lista = new HashMap<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM componenteOpcional");
            while (rs.next()) {
                ComponenteOpcional al = new ComponenteOpcional(rs.getString("nome_opc"), 
                        rs.getDouble("preco_opc"), rs.getInt("stock_opc"), rs.getString("compIncomp"));  
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
    
    @Override
    public ComponenteOpcional put(Integer key, ComponenteOpcional value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Data;

import Main.Business.Cliente;
import Main.Business.Configuracao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nuno
 */
public class ConfiguracaoDAO implements Map<Integer,Configuracao>{

    private Connection conn;
    
    @Override
    public int size() {
        int size = -1;

        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM Configuracao WHERE id>0");
            ResultSet rs = ps.executeQuery();
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
     * Verifica se existem entradas
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Verifica se existe uma configuracao
     * @param key
     * @return
     * @throws NullPointerException 
     */
    @Override
    public boolean containsKey(Object key) throws NullPointerException {
                boolean res = false;
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Configuracao WHERE id=?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs = ps.executeQuery();
            res = rs.next();   
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
        return res;
    }

    @Override
    public boolean containsValue(Object value) {

    }

    @Override
    public Configuracao get(Object key) {
        Configuracao conf = null;
        
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Configuracao WHERE nif=?");
            stm.setString(1,(String) key);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                al = new Configuracao(rs.getInt("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Connect.close(conn);
        }
        
        return conf;
    }

       /**
     * Insere um cliente na base de dados
     * @param key
     * @param value
     * @return 
     */
    public Configuracao put(Integer key, Configuracao value) {
        Configuracao al = null;
        try {
            conn = Connect.connect();
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
            
            al = value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.close(conn);
        }
        return al;
    }

    @Override
    public Configuracao remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Configuracao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Configuracao> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Configuracao>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Vai dar um update a tabela veiculo, 
     * para fazer a ligacao entre o veiculo pretendido e a nova configuracao que esta a ser agora criada
     * @param key 
     */
    public void atribuiConf(Object key){
        try{    
            //update na tabela Veiculo
            conn = Connect.connect();
            PreparedStatement stmV = conn.prepareStatement("UPDATE veiculo "
                    + "SET Configuracao_idC=VALUES(Configuracao_idC) WHERE (idV=? AND "
                    + "Configuracao_idC=(SELECT idC FROM Configuracao ORDER BY idC DESC LIMIT 1);");
            stmV.setString(1,(String) key);
            stmV.executeUpdate();
        }catch(Exception e){
            e.getStackTrace();
        }finally {
            Connect.close(conn);
        }
    }
    
    
    /**
     * Vai dar um update a ultima linha criada da tabela configuracao, atribuindo lhe ja as componentes
     * @param key 
     */
    public void pacoteDesportivo(Object key){
        try{    
            //update na tabela Veiculo
            conn = Connect.connect();
            PreparedStatement stmV = conn.prepareStatement("UPDATE configuracao "
                    + "SET nomeConf=? ORDER BY idC DESC LIMIT 1;");
            stmV.setString(1,(String) key);
            stmV.executeUpdate();
        }catch(Exception e){
            e.getStackTrace();
        }finally {
            Connect.close(conn);
        }        ATUALIZAR ISTO PARA LHE JA ATRIBUIR AS CENAS DOS PACOTES PRE FEITOS
    }
    
    
    /**
     * Vai dar um update a ultima linha criada da tabela configuracao, atribuindo lhe ja as componentes
     * @param key 
     */
    public void pacoteCitadino(Object key){
        try{    
            //update na tabela Veiculo
            conn = Connect.connect();
            PreparedStatement stmV = conn.prepareStatement("UPDATE configuracao "
                    + "SET nomeConf=? ORDER BY idC DESC LIMIT 1;");
            stmV.setString(1,(String) key);
            stmV.executeUpdate();
        }catch(Exception e){
            e.getStackTrace();
        }finally {
            Connect.close(conn);
        }        ATUALIZAR ISTO PARA LHE JA ATRIBUIR AS CENAS DOS PACOTES PRE FEITOS
    }
    
    /**
     * Vai dar um update a ultima linha criada da tabela configuracao, atribuindo lhe ja as componentes
     * @param key 
     */
    public void pacotePersonalizado(Object key){
        try{    
            //update na tabela Veiculo
            conn = Connect.connect();
            PreparedStatement stmV = conn.prepareStatement("UPDATE configuracao "
                    + "SET nomeConf=? ORDER BY idC DESC LIMIT 1;");
            stmV.setString(1,(String) key);
            stmV.executeUpdate();
        }catch(Exception e){
            e.getStackTrace();
        }finally {
            Connect.close(conn);
        }
    }
    
}

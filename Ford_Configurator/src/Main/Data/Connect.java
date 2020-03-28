/*
 * Connect
 * ruicouto in 10/dez/2015
 */
package Main.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que gere ligações à base de dados
 * @author ruicouto
 */
public class Connect {   
    
    private static final String URL = "localhost:3306";
    private static final String DB = "mydb";
    private static final String USERNAME = "root"; //TODO: alterar
    private static final String PASSWORD = "root"; //TODO: alterar
    
    /**
     * Estabelece ligação à base de dados
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");   
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return DriverManager.getConnection("jdbc:mysql://"+URL+"/"+DB+"?autoReconnect=true&useSSL=false",USERNAME,PASSWORD);
}
    
    /**
     * Fecha a ligação à base de dados, se aberta.
     * @param c 
     */
    public static void close(Connection c) {
        try {
            if(c!=null && !c.isClosed()) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

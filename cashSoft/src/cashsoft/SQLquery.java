/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cashsoft;
import java.sql.*;


/**
 *
 * @author Rango
 */
public class SQLquery {
    protected Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    
    public void conectar (String servidor, String basedatos, String usuario, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+basedatos,usuario,password); 
    }
    public void desconectar() throws SQLException {
        this.conn.close();
        this.consulta.close();
    }
    public void desconectar(ResultSet rs) throws SQLException{
        this.desconectar();
        rs.close();
    }
            
}

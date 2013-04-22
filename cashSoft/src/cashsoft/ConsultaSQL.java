/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cashsoft;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandra
 */
public class ConsultaSQL extends SQLquery {
    
    public String realizarConsulta(String userID) throws SQLException, ClassNotFoundException{
        
        String query;
        String resultado = "";
        
        query = "SELECT U.INGRESO, IFNULL(SUM(G.MONTO),0) GASTOS, U.NIVEL_ALERTA ";
        query += "FROM USUARIOS U LEFT OUTER JOIN GASTOS G ON U.USER_ID = G.USER_ID ";
        query += "WHERE U.USER_ID = '" + userID + "'";
        query += " GROUP BY G.USER_ID";

        
        try {
            
            this.conectar("127.0.0.1", "cashsoft", "cashsoft", "cashsoft");
            this.consulta = this.conn.prepareStatement(query);
            this.datos = this.consulta.executeQuery();
            while(this.datos.next()){
                resultado = this.datos.getString("INGRESO")+","+this.datos.getString("GASTOS")+","+this.datos.getString("NIVEL_ALERTA");
            }
            
            this.desconectar();
            
        } catch (SQLException ex) {
                
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
                            
        }
        
        return resultado;
        
    }
   
}   

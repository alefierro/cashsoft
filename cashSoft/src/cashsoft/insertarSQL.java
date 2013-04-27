/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cashsoft;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandra
 */
public class insertarSQL extends SQLquery{
    
    public String actualizarRegistro(String userID, Double ingreso, Integer nivelAlerta) throws ClassNotFoundException{
        
        String query;
        
        query = "UPDATE USUARIOS ";
        query += "SET ingreso = " + ingreso;
        query += ",nivel_alerta = " + nivelAlerta;
        query += " WHERE user_id = '" + userID + "'";

        
        try {
            
            this.conectar("127.0.0.1", "cashsoft", "cashsoft", "cashsoft");
            this.consulta = this.conn.prepareStatement(query);
            this.consulta.execute();

            this.desconectar();
            
            return "Actualización exitosa";
            
        } catch (SQLException ex) {
                
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return "Error, intente de nuevo";
                            
        }
        
    }
    
    public String actualizarContrasenia(String userID, String contraseniaActual, String contraseniaNueva) throws ClassNotFoundException{
        
        String query1;
        String query2;
        String contActual;
        
        query1 = "SELECT password ";
        query1 += "FROM usuarios ";
        query1 += " WHERE user_id = '" + userID + "'";
        
        query2 = "UPDATE usuarios ";
        query2 += "SET password = '" + contraseniaNueva + "'";
        query2 += " WHERE user_id = '" + userID + "'";

        
        try {
            
            this.conectar("127.0.0.1", "cashsoft", "cashsoft", "cashsoft");
            this.consulta = this.conn.prepareStatement(query1);
            this.datos = this.consulta.executeQuery();
            
            this.datos.absolute(1);
            
            contActual = this.datos.getString("password");
            
            if (contActual.equals(contraseniaActual))  {
            
                this.consulta = this.conn.prepareStatement(query2);
                this.consulta.execute();
                this.desconectar();
                
                return "Actualización exitosa";
            
            } else {
                
                this.desconectar();
                return "Contraseña incorrecta";
                
            }

        } catch (SQLException ex) {
                
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return "Error, intente de nuevo";
                            
        }
        
    }
    
    public String insertarUsuario(String usuario, String contrasenia, Double ingreso) throws ClassNotFoundException{
        
       String query;
       Integer nivel = 75;
        
        query = "INSERT INTO usuarios(user_id, password, ingreso, nivel_alerta) ";
        query += "VALUES ('" + usuario + "','" + contrasenia + "'," + ingreso + "," + nivel + ")";

        
        try {
            
            this.conectar("127.0.0.1", "cashsoft", "cashsoft", "cashsoft");
            this.consulta = this.conn.prepareStatement(query);
            this.consulta.execute();

            this.desconectar();
            
            return "Usuario creado";
            
        } catch (SQLException ex) {
                
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return "Error, intente de nuevo";
                            
        } 
        
    }
    
    public String insertarGasto(String descripcion, Integer tipoPago, Double monto, String fecha, String usuario) throws ClassNotFoundException{
        
       String query;
        
        query = "INSERT INTO gastos(descripcion, tipo_pago, monto, fecha_gasto, user_id) ";
        query += "VALUES ('" + descripcion + "'," + tipoPago + "," + monto + ",'" + fecha + "','" + usuario + "')";
        
        try {
            
            this.conectar("127.0.0.1", "cashsoft", "cashsoft", "cashsoft");
            this.consulta = this.conn.prepareStatement(query);
            this.consulta.execute();

            this.desconectar();
            
            return "Gasto guardado";
            
        } catch (SQLException ex) {
                
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return "Error, intente de nuevo";
                            
        } 
        
    }
    
}

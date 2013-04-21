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
 * @author Rango
 */
public class Servicio extends SQLquery{
    public void vertodos(){
        try {
            this.conectar("127.0.0.1", "cashsoft", "root", "Legnar01!");
            this.consulta = this.conn.prepareStatement ("SELECT * FROM usuarios");
            this.datos = this.consulta.executeQuery();
            while(this.datos.next()){
                System.out.println("usuario: "+this.datos.getString("user_id")+" password: "+this.datos.getString("password"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public boolean checausuario(String _usuario, String _pass){
        boolean a = false;
        try {
            this.conectar("127.0.0.1", "cashsoft", "root", "Legnar01!");
            this.consulta = this.conn.prepareStatement ("SELECT * FROM usuarios");
            this.datos = this.consulta.executeQuery();
            while(this.datos.next()){
                if ( _usuario.equals(this.datos.getString("user_id")) && 
                     (_pass.equals(this.datos.getString("password")))){
                    a = true;
                }
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

        
    }
}

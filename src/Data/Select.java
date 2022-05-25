/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ANONYME
 */
public class Select {
     public static ResultSet getData(String query){
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
      try{
          
          conn = connex.ConnexionDB();
           st= conn.createStatement();
           rs = st.executeQuery(query);
           return rs;
           
         }catch(SQLException e){
          JOptionPane.showMessageDialog(null, e);
          return null;
         }
        
    }
}

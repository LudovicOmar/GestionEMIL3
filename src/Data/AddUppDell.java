/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ANONYME
 */
public class AddUppDell {
     public static void setData(String query,String msg){
    Connection conn = null;
    Statement st=null;
    
    try{
           conn = connex .ConnexionDB();
           st=conn.createStatement();
           st.executeUpdate(query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
           
       }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(null, e);
       }finally{
            try{
        
               }catch(Exception e){
          
               }
    }
}
}

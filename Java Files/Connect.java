/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Apple
 */
public class Connect {
    
    Connection create_connection()
    {
        Connection con=null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@Apple-PC:1521:XE","system","shanker");
         
            return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return con;
    }

    void close_connection(Connection con)
    {
        try
        {
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

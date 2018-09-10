/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Apple
 */
public class Details {
    
    public void execute(int unique_id)
    {
        JFrame jfrm = new JFrame("Details Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int sbi=0,hdfc=0,icici=0,sbi_acc=0,hdfc_acc=0,icici_acc=0;

        JLabel headerLabel = new JLabel("Here are your accounts ", JLabel.CENTER);
        jfrm.add(headerLabel);
        try 
        {
            Connect obj1=new Connect();
            Connection con=obj1.create_connection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from sbi");

            while (rs.next()) 
            {
                if (unique_id == rs.getInt(6)) 
                {
                    sbi = 1;
                    sbi_acc=rs.getInt(1);
                   //System.out.println(sbi_acc);
                    break;
                }

            }
            if(sbi==0)
            {
                JLabel jlab=new JLabel("<html><br>No sbi accounts</html>");
                jfrm.add(jlab);
                JButton Enter = new JButton("<html><br>Open a new SBI account</html>");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    SBI obj=new SBI();
                    obj.open_acc();

                    } });
                jfrm.add(Enter);
            }
                    
            rs = stmt.executeQuery("select * from hdfc");

            while (rs.next()) 
            {
                if (unique_id == rs.getInt(6)) 
                {
                    hdfc = 1;
                    hdfc_acc=rs.getInt(1);
                    break;
                }
            }
            if(hdfc==0)
            {
                JLabel jlab=new JLabel("<html><br>No hdfc accounts</html>");
                jfrm.add(jlab);
                JButton Enter = new JButton("<html><br>Open a new HDFC account</html>");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    HDFC obj=new HDFC();
                    obj.open_acc();

                    } });
                jfrm.add(Enter);
            }
             
            rs = stmt.executeQuery("select * from icici");

            while (rs.next()) 
            {
                if (unique_id == rs.getInt(6)) 
                {
                    icici = 1;
                    icici_acc=rs.getInt(1);
                    break;
                }

            }
            if(icici==0)
            {
                JLabel jlab=new JLabel("<html><br>No icici accounts</html>");
                jfrm.add(jlab);
                JButton Enter = new JButton("<html><br>Open a new ICICI account</html>");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    ICICI obj=new ICICI();
                    obj.open_acc();

                    } });
                jfrm.add(Enter);
                
            }
                    
            if(sbi==1)
            {
                JLabel jlab=new JLabel("<html><br>You hold an account in sbi with acc_no " + Integer.toString(sbi_acc)+"</html>"); 
                jfrm.add(jlab);
                
                JButton Enter = new JButton("Modify SBI account");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    SBI obj=new SBI();
                    obj.options();

                    } });
                jfrm.add(Enter);
            }
            if(hdfc==1)
            {
                JLabel jlab=new JLabel("<html><br>You hold an account in hdfc with acc_no " + Integer.toString(hdfc_acc)+"</html>"); 
                jfrm.add(jlab);
                JButton Enter = new JButton("Modify HDFC account");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    HDFC obj=new HDFC();
                    obj.options();

                    } });
                jfrm.add(Enter);
            }
            if(icici==1)
            {
                JLabel jlab=new JLabel("<html><br>You hold an account in icici with acc_no " + Integer.toString(icici_acc)+"</html>"); 
                jfrm.add(jlab);
                JButton Enter = new JButton("Modify ICICI account");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                    ICICI obj=new ICICI();
                    obj.options();

                    } });
                jfrm.add(Enter);
            }
                    
            obj1.close_connection(con);
        }
  
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        jfrm.setVisible(true);
    }
    
}
        


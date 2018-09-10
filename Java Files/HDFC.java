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
import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Apple
 */
public class HDFC implements RBI {
 
    //Scanner s=new Scanner(System.in);
    public void open_acc()
    {
        JFrame jfrm = new JFrame("Open HDFC account Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlab1=new JLabel("Enter account no : ");
        jfrm.add(jlab1);
        JTextField jtf1=new JTextField();
        jtf1.setSize(100, 50);
        jtf1.setLocation(200, 50);
        jtf1.setVisible(true);
        jfrm.add(jtf1);
        int acc_no=Integer.parseInt(jtf1.getText());
        
        JLabel jlab2=new JLabel("Enter name : ");
        jfrm.add(jlab2);
        JTextField jtf2=new JTextField();
        jtf2.setSize(100, 50);
        jtf2.setLocation(200, 50);
        jtf2.setVisible(true);
        jfrm.add(jtf2);
        String name=jtf2.getText();
        
        JLabel jlab3=new JLabel("Enter age : ");
        jfrm.add(jlab3);
        JTextField jtf3=new JTextField();
        jtf3.setSize(100, 50);
        jtf3.setLocation(200, 50);
        jtf3.setVisible(true);
        jfrm.add(jtf3);
        int age=Integer.parseInt(jtf3.getText());
        
        JLabel jlab4=new JLabel("Enter loan : ");
        jfrm.add(jlab4);
        JTextField jtf4=new JTextField();
        jtf4.setSize(100, 50);
        jtf4.setLocation(200, 50);
        jtf4.setVisible(true);
        jfrm.add(jtf4);
        int loan=Integer.parseInt(jtf4.getText());
        
        JLabel jlab5=new JLabel("Enter tax : ");
        jfrm.add(jlab5);
        JTextField jtf5=new JTextField();
        jtf5.setSize(100, 50);
        jtf5.setLocation(200, 50);
        jtf5.setVisible(true);
        jfrm.add(jtf5);
        int tax=Integer.parseInt(jtf5.getText());
        
        JLabel jlab6=new JLabel("Enter unique_id : ");
        jfrm.add(jlab6);
        JTextField jtf6=new JTextField();
        jtf6.setSize(100, 50);
        jtf6.setLocation(200, 50);
        jtf6.setVisible(true);
        jfrm.add(jtf6);
        int unique_id=Integer.parseInt(jtf6.getText());
        
        
        try
        {
            Connect obj=new Connect();
            Connection con=obj.create_connection();
            
            PreparedStatement stmt=con.prepareStatement("insert into hdfc values(?,?,?,?,?,?)");
            stmt.setInt(1, acc_no);
            stmt.setString(2,name);
            stmt.setInt(3, age);
            stmt.setInt(4,loan);
            stmt.setInt(5, tax);
            stmt.setInt(6,unique_id);
            
            stmt.executeUpdate();
            
            obj.close_connection(con);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jfrm.setVisible(true);
    }
    public void delete_acc()
    {
        JFrame jfrm = new JFrame("Account deletion Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlab=new JLabel("Enter your account no: ",JLabel.CENTER);
        jfrm.add(jlab);
        JTextField jtf1=new JTextField();
        jtf1.setSize(100, 50);
        jtf1.setLocation(200, 50);
        jtf1.setVisible(true);
        jfrm.add(jtf1);
         
        try
        {
            int flag=0;
            Connect obj1=new Connect();
            Connection con=obj1.create_connection();
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select acc_no from hdfc");
            
            String s=jtf1.getText(); 
            int acc_no=Integer.parseInt(s);
            while(rs.next())
            {
                if(rs.getInt(1)==acc_no)
                {
                    flag=1;
                    JLabel statusLabel=new JLabel("You hold a valid account",JLabel.CENTER);
                    jfrm.add(statusLabel);
                    break;
                }
            }
            if(flag==0)
            {
                JLabel statusLabel=new JLabel("you must open an account first",JLabel.CENTER);
                jfrm.add(statusLabel);
            }
            else if (flag==1)
            {
                JLabel statusLabel=new JLabel("Are you sure you want to delete all info about this account: ",JLabel.CENTER);
                jfrm.add(statusLabel);
                JTextField jtf2=new JTextField();
                jtf2.setSize(100, 50);
                jtf2.setLocation(200, 50);
                jtf2.setVisible(true);
                jfrm.add(jtf2);
                
                if(jtf2.getText().equals("yes"))
                {
                    try
                    {
                        PreparedStatement ptst=con.prepareStatement("delete from hdfc where acc_no=?");
                
                        ptst.setInt(1,acc_no);
                        ptst.executeUpdate();
               
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("Account"+acc_no+"not deleted");
                }
            }
            obj1.close_connection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jfrm.setVisible(true);
        
    }
    public void update_acc()
    {
        JFrame jfrm = new JFrame("HDFC Updation Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
        {
            Connect obj=new Connect();
            Connection con=obj.create_connection();
            
            JLabel jlab1=new JLabel("Enter account no : ");
            jfrm.add(jlab1);
            JTextField jtf1=new JTextField();
            jtf1.setSize(100, 50);
            jtf1.setLocation(200, 50);
            jtf1.setVisible(true);
            jfrm.add(jtf1);
            int acc=Integer.parseInt(jtf1.getText());

            JLabel jlab2=new JLabel("Enter new name : ");
            jfrm.add(jlab2);
            JTextField jtf2=new JTextField();
            jtf2.setSize(100, 50);
            jtf2.setLocation(200, 50);
            jtf2.setVisible(true);
            jfrm.add(jtf2);
            String new_name=jtf2.getText();
        
            JLabel jlab3=new JLabel("Enter newage : ");
            jfrm.add(jlab3);
            JTextField jtf3=new JTextField();
            jtf3.setSize(100, 50);
            jtf3.setLocation(200, 50);
            jtf3.setVisible(true);
            jfrm.add(jtf3);
            int new_age=Integer.parseInt(jtf3.getText());

            JLabel jlab4=new JLabel("Enter new loan : ");
            jfrm.add(jlab4);
            JTextField jtf4=new JTextField();
            jtf4.setSize(100, 50);
            jtf4.setLocation(200, 50);
            jtf4.setVisible(true);
            jfrm.add(jtf4);
            int new_loan=Integer.parseInt(jtf4.getText());

            JLabel jlab5=new JLabel("Enter new tax : ");
            jfrm.add(jlab5);
            JTextField jtf5=new JTextField();
            jtf5.setSize(100, 50);
            jtf5.setLocation(200, 50);
            jtf5.setVisible(true);
            jfrm.add(jtf5);
            int new_tax=Integer.parseInt(jtf5.getText());
        
           PreparedStatement stmt=con.prepareStatement("update hdfc set name=?, age=?,loan=?,tax=? where acc_no=?");
           stmt.setString(1, new_name);
           stmt.setInt(2, new_age);
           stmt.setInt(3,new_loan);
           stmt.setInt(4, new_tax);
           stmt.setInt(5, acc);
           
           stmt.executeUpdate();
           
           obj.close_connection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jfrm.setVisible(true);
    }
    
    public void pay_tax()
    {
        JFrame jfrm = new JFrame("HDFC TAX Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlab1=new JLabel("Enter your account no",JLabel.CENTER);
        jfrm.add(jlab1);
        
        JTextField jtf1 = new JTextField(15);
        jtf1.setSize(100, 50);
        jtf1.setLocation(200, 50);
        jtf1.setVisible(true);
        jfrm.add(jtf1);
         
        try
        {
            int flag=0;
            Connect obj1=new Connect();
            Connection con=obj1.create_connection();
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select acc_no from hdfc");
            
            int acc_no=Integer.parseInt(jtf1.getText());
            System.out.println("hello" + acc_no);
    
            while(rs.next())
            {
                if(rs.getInt(1)==acc_no)
                {
                    flag=1;
                    JLabel statusLabel=new JLabel("You hold a valid account",JLabel.CENTER);
                    jfrm.add(statusLabel);
                    break;
                }
            }
            if(flag==0)
            {
                JLabel statusLabel=new JLabel("you must open an account first",JLabel.CENTER);
                jfrm.add(statusLabel);
            }
            else if (flag==1)
            {
                JLabel jlab2=new JLabel("Enter the amount of tax:",JLabel.CENTER);
                jfrm.add(jlab2);
                JTextField jtf2 = new JTextField(15);
                jtf2.setSize(100, 50);
                jtf2.setLocation(300, 50);
                jtf2.setVisible(true);
                jfrm.add(jtf2);
                
                int tax=Integer.parseInt(jtf2.getText());
                System.out.println(tax);
                PreparedStatement ptst=con.prepareStatement("update hdfc set tax=? where acc_no=?");
                ptst.setInt(1, tax);
                ptst.setInt(2, acc_no);
           
                ptst.executeUpdate();
            }
           
                obj1.close_connection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
        jfrm.setVisible(true);
    }
        
    public void take_loan()
    {
        JFrame jfrm = new JFrame("HDFC Loan Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlab=new JLabel("Enter your account no",JLabel.CENTER);
        jfrm.add(jlab);
        
        JTextField jtf = new JTextField(15);
        jtf.setSize(100, 50);
        jtf.setLocation(200, 50);
        jtf.setVisible(true);
        jfrm.add(jtf);
               
        try
        {
            int flag=0;
            Connect obj1=new Connect();
            Connection con=obj1.create_connection();
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select acc_no from hdfc");
            
            String s=jtf.getText(); 
            int acc_no=Integer.parseInt(s);
            while(rs.next())
            {
                if(rs.getInt(1)==acc_no)
                {
                    flag=1;
                    JLabel statusLabel=new JLabel("You hold a valid account",JLabel.CENTER);
                    jfrm.add(statusLabel);
                    break;
                }
            }
            if(flag==0)
            {
                JLabel statusLabel=new JLabel("you must open an account first",JLabel.CENTER);
                jfrm.add(statusLabel);
            }
            else if (flag==1)
            {
                JLabel jlab1=new JLabel("Enter the amount of loan:",JLabel.CENTER);
                jfrm.add(jlab1);
                JTextField jtf1 = new JTextField(15);
                jtf1.setSize(100, 50);
                jtf1.setLocation(300, 50);
                jtf1.setVisible(true);
                jfrm.add(jtf1);
                s=jtf1.getText();
                int amount=Integer.parseInt(s);
        
                try
                {
                    check(amount,acc_no);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            
                PreparedStatement ptst=con.prepareStatement("update hdfc set loan=? where acc_no=?");

                ptst.setInt(1,amount);
                ptst.setInt(2,acc_no);
		
                ptst.executeUpdate();
                
                rs=stmt.executeQuery("select * from hdfc");
                
                
                while(rs.next())
                {   
                    if(rs.getInt(1)==acc_no)
                    {
                        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+rs.getInt(6));
                        JLabel statusLabel=new JLabel("The loan has been granted",JLabel.CENTER);
                        break;
                    }
                }
            }
                
            obj1.close_connection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
           
        jfrm.setVisible(true);
    }
    
    void check(int amount,int acc_no) throws Myexp
    {
        if(amount>5000)
        {
            throw new Myexp("An amount greater than 5000 is not allowed.");
        }
        else
        {
            return;
        }
        
    }
    
    public void options()
    {
        JFrame jfrm = new JFrame("HDFC Options Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int flag=0,acc_no;
        
        JLabel jlab=new JLabel("<html><br>What do you want to do?<br>Take loan<br>Pay tax<br>Delete account<br>Update account</html>");
        jfrm.add(jlab);
        JButton Button1 = new JButton("<html><br>Take loan</html>");
               
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                take_loan();
        } });
        jfrm.add(Button1);
        
        JButton Button2 = new JButton("<html><br>Pay tax</html>");
               
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                pay_tax();
        } });
        jfrm.add(Button2);
        
        JButton Button3 = new JButton("<html><br>Delete account</html>");
               
        Button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                delete_acc();
        } });
        jfrm.add(Button3);
        
        JButton Button4 = new JButton("<html><br>Update account</html>");
               
        Button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                update_acc();
        } });
        jfrm.add(Button4);
        jfrm.setVisible(true);
    }
}

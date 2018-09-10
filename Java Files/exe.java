/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class exe {

    /**
     * @param args the command line arguments
     */
    JLabel jlab;
    
    exe(){
        JFrame jfrm=new JFrame("Home Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLUE);
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton user=new JButton("User");
        JButton admin=new JButton("Admin");
        
        user.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jlab.setText("You selected user");
                User obj=new User();
                obj.execute();
            }
        });
        
        admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jlab.setText("You selected admin");
                Admin obj=new Admin();
                obj.execute();
            }
        });
        
        jfrm.add(user);
        jfrm.add(admin);
        
        jlab=new JLabel("Press a button");
        jfrm.add(jlab);
        
        jfrm.setVisible(true);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new exe();
            }
        });
        
      }
        
    }
    

    
    


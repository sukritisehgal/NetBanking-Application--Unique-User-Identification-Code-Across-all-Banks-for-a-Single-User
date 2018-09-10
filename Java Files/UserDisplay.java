/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Apple
 */
public class UserDisplay {
    
    public void execute()
    {
        JFrame jfrm = new JFrame("Details Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        JLabel jlab1=new JLabel("Your request has been recorded");
        jfrm.add(jlab1);
        jfrm.setVisible(true);
    }

}

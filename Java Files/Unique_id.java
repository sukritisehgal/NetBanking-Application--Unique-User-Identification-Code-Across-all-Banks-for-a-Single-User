/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

/**
 *
 * @author Apple
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Unique_id extends JApplet {

    int sbi = 0, hdfc = 0, icici = 0,sbi_acc,hdfc_acc,icici_acc;
    String msg = " ";

          public void execute() {
        // TODO code application logic here

        JFrame jfrm = new JFrame("Id Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.YELLOW);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Enter Unique_id ", JLabel.CENTER);
        jfrm.add(headerLabel);

        JTextField jtf = new JTextField(15);
        jtf.setSize(100, 50);
        jtf.setLocation(200, 50);
        jtf.setVisible(true);
        
        JLabel statusLabel = new JLabel("<html><br><br>Hello</html>", JLabel.LEFT);

        statusLabel.setSize(350, 100);

        jtf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                statusLabel.setText("Id is " + jtf.getText());
                
            }
        });

                JButton Enter = new JButton("Enter");
               
                Enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        statusLabel.setText("Enter pressed");
                        Details obj=new Details();
                        obj.execute(Integer.parseInt(jtf.getText()));

                    }

                });
                jfrm.add(jtf);

                jfrm.add(Enter);
                jfrm.add(statusLabel);

                jfrm.setVisible(true);

        
    }
}

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Apple
 */
public class User {
    public void execute()
    {
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
                        UserRequest obj=new UserRequest();
                        obj.execute(Integer.parseInt(jtf.getText()));

                    }

                });
                jfrm.add(jtf);

                jfrm.add(Enter);
                jfrm.add(statusLabel);

                jfrm.setVisible(true);

        
    }
    
}


package banking_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Apple
 */
public class Admin extends JApplet {

    JLabel jlab1, jlab2, headerLabel, statusLabel;
    JTextField jtf1;
    JPasswordField jpf;
    int flag = 0;

    Admin() {
        prepareGUI();
    }

    public void prepareGUI() {

        JFrame jfrm = new JFrame("Login Page");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBackground(Color.cyan);
        jfrm.setForeground(Color.BLACK);
        jfrm.setSize(500, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerLabel = new JLabel("Enter your details ", JLabel.CENTER);
        statusLabel = new JLabel("No entries yet", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        jfrm.add(headerLabel);

        jlab1 = new JLabel("<html><br><br><br>Enter your username</html>", JLabel.LEFT);
        jfrm.add(jlab1);

        jtf1 = new JTextField(15);
        jtf1.setSize(100, 50);
        jtf1.setLocation(200, 50);
        jtf1.setVisible(true);

        jtf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                statusLabel.setText("Username is " + jtf1.getText());
            }
        });

        jlab2 = new JLabel("<html><br><br><br>Enter your password</html>", JLabel.RIGHT);
        jfrm.add(jlab2);

        jpf = new JPasswordField(15);
        jpf.setSize(100, 50);
        jpf.setLocation(400, 50);
        jpf.setVisible(true);

        jpf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                statusLabel.setText("password entered is " + new String(jpf.getPassword()));
            }
        });

        JButton Login = new JButton("Login");

        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                statusLabel.setText("Login pressed");
                try {

                    Connect obj1=new Connect();
                    Connection con=obj1.create_connection();
                    Statement stmt = con.createStatement();
                    
                    
                    ResultSet rs = stmt.executeQuery("select * from admin");
                    int id = Integer.parseInt(jtf1.getText());

                   System.out.println(id);
                    while (rs.next()) {
                       System.out.println(rs.getString(2));
                        if ((id == rs.getInt(1)) && (new String(jpf.getPassword()).equals(rs.getString(2)))) {
                            flag = 1;
                            System.out.println("you are a valid admin");
                            statusLabel.setText("You are a valid admin");
                            break;
                        }

                    }
                    if (flag == 0) {
                        System.out.println("You are not a valid admin");
                        statusLabel.setText("You are not a valid admin");
                    }

                   obj1.close_connection(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (flag == 1) {
                   Unique_id obj = new Unique_id();
                    obj.execute();
                    
                }

            }
        });

        jfrm.add(jtf1);
        jfrm.add(jpf);
        jfrm.add(Login);
        jfrm.add(statusLabel);

        jfrm.setVisible(true);

    }

    public void execute() {
        // TODO code application logic here

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Admin();
            }
        });
    }
}

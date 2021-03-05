package restaurant;
import java.awt.LayoutManager;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.*;
import javax.swing.JOptionPane;
public class Restaurant  extends JFrame implements ActionListener{
    JLabel start;
    JLabel username;
    JLabel password;
    JTextField user;
    JPasswordField pass;
    JButton sb;
    JPanel inputpart;
    Font f;
    Restaurant()
    {
        setVisible(true);
        setSize(400,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        f=new Font("Sans-Serif",Font.BOLD,30);
        start=new JLabel("LOGIN",JLabel.CENTER);
        start.setBounds(100, 20, 200, 60);
        start.setFont(f);
        add(start);

        Color ff=new Color(90,90,90);
        getContentPane().setBackground(ff);

        // inputpart=new JPanel();
        // inputpart.setLayout(null);
        username=new JLabel("UserName :");
        username.setBounds(10,100,100,30);
        add(username);
        user=new JTextField(20);
        user.setBounds(120,100,165,30);
        add(user);
        password=new JLabel("Password :");
        password.setBounds(10,140,100,30);
        add(password);
        pass=new JPasswordField(20);
        pass.setBounds(120,140,165,30);
        add(pass);
        //add(inputpart);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        sb=new JButton("Submit");
        sb.setBounds(150, 220, 100, 30);
        add(sb);
        sb.addActionListener(this);
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()->new Restaurant());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        String uid=user.getText();
        String pwd=pass.getText();
        if(uid.isEmpty()||pwd.isEmpty()||!pwd.matches(regex))
        {              
            if(uid.isEmpty()||pwd.isEmpty())
            JOptionPane.showMessageDialog(this,"All the Fields are required.Please Check","Error",JOptionPane.WARNING_MESSAGE);
            else
            JOptionPane.showMessageDialog(this,"Password should contain atleast 1 letter,1 digit and 1 special character","Try Another Password",JOptionPane.DEFAULT_OPTION);
        }
        else{
        try{
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
            Statement st=c.createStatement();
            String query="Select * from employee_details where name='"+uid+"' and password='"+pwd+"';";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                new LandingPage(uid);
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Wrong Username or Password Entered.\n Please check.","Wrong Username or Password",JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            st.close();
            c.close();
            
        }
         catch(Exception et){
             System.out.println(et);
         }
        }
    }
}

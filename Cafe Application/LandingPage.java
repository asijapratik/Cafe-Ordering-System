package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LandingPage extends JFrame 
{
    JLabel label1;
    JLabel imgl1;
    JButton button1;
    JButton button2,button3;
    ImageIcon img;
    Font font1;
    Font font2;
    String username;
    LandingPage(String username)
    {
        this.username=username;
        setVisible(true);
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
        label1=new JLabel("Select your item");
        button1=new JButton("Start Order");
        button2=new JButton("View Previous Orders");
        button3=new JButton("Logout");
        img=new ImageIcon(getClass().getResource("main.jpg"));
        img=new ImageIcon(img.getImage().getScaledInstance(1000,600, Image.SCALE_DEFAULT));
        imgl1=new JLabel(img);
        font1=new Font("Sans",Font.BOLD,40);
        font2=new Font("Sans",Font.BOLD,20);
        
        imgl1.setBounds(0,0,1000,600);
        label1.setBounds(0,0,400,50);
        button1.setBounds(100,430,150,50);
        button2.setBounds(300,430,250,50);
        button3.setBounds(800,20,120,50);
        
        label1.setFont(font1);
        label1.setOpaque(true);
        button1.setFont(font2);
        button1.setBackground(Color.WHITE);
        button2.setFont(font2);
//        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button3.setFont(font2);
        
        add(imgl1);
        add(label1);
        add(button1);
        add(button2);
        add(button3);
        button1.addActionListener((ActionEvent e)->{
            new Personinfo(username);
            try{
             Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
                    Statement st=c.createStatement();
                    String query="Update order_items set quantity=0";
                    st.executeUpdate(query);
                    st.close();
                    c.close();
            }
            catch(Exception er){
                System.out.println(er);
            }
                    
        });
        button2.addActionListener((ActionEvent e)->new PreviousOrders());
        button3.addActionListener((ActionEvent e)->{
            new Restaurant();
            setVisible(false);
        });
    }
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(()->{
            new LandingPage("");
        });
    }    
}

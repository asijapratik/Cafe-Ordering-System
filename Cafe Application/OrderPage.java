package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OrderPage extends JFrame{
    
    JLabel head,img,option;
    JButton jb1,jb2,jb3,jb4,jb5;
    Font f,ff;
    ButtonGroup bg;
    String username,name,phno,order;
    OrderPage(String username,String name,String phno,String order)
    {
        this.username=username;
        this.name=name;
        this.phno=phno;
        this.order=order;
        setVisible(true);
        setSize(600,600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Order Details");
//        Color cl=new Color(90,90,90);
//        getContentPane().setBackground(cl);
        
        Color color=new Color(0,60,250);
        f=new Font("Sans-Serif",Font.BOLD,30);
        head=new JLabel("Order Details",JLabel.CENTER);
        add(head);
        head.setFont(f);
        head.setOpaque(true);
        head.setBackground(color);
        head.setBounds(20,20,540,80);
        
        Color color1=new Color(255,255,255);
        Color color2=new Color(0,0,0);
        ff=new Font("Sans-Serif",Font.BOLD,15);
        option=new JLabel("Menu Types :");
        option.setFont(ff);
        option.setBounds(30,120,120,30);
        add(option);
        
        jb1=new JButton("Beverages");
        jb1.setBounds(50,170,150,30);
        add(jb1);
        jb1.setForeground(color1);
        jb1.setOpaque(true);
        jb1.setBackground(color2);
        jb1.addActionListener((ActionEvent e)->new Beverages());
        
        jb2=new JButton("Snacks");
        jb2.setBounds(50,220,150,30);
        add(jb2);
        jb2.setForeground(color1);
        jb2.setOpaque(true);
        jb2.setBackground(color2);
        jb2.addActionListener((ActionEvent e)->new Snacks());
        
        jb3=new JButton("Desserts");
        jb3.setBounds(50,270,150,30);
        add(jb3);
        jb3.setForeground(color1);
        jb3.setOpaque(true);
        jb3.setBackground(color2);
        jb3.addActionListener((ActionEvent e)->new Desserts());
////        jb4=new JButton("Desserts");
////        jb4.setBounds(50,320,150,30);
////        add(jb4);
////        jb4.setForeground(color1);
////        jb4.setOpaque(true);
////        jb4.setBackground(color2);
   
        jb5=new JButton("View Cart");
        jb5.setBounds(50,400,150,30);
        add(jb5);
        jb5.setForeground(color1);
        jb5.setOpaque(true);
        jb5.setBackground(Color.red);
        jb5.addActionListener((ActionEvent e)->{
            try {
                new finalorder(username,name,phno,order,this);
            } catch (SQLException ex) {
                Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ImageIcon ic=new ImageIcon(getClass().getResource("food1.png"));
        ic=new ImageIcon(ic.getImage().getScaledInstance(280, 400, Image.SCALE_DEFAULT));
        img=new JLabel(ic);
        img.setBounds(280,120,280,400);
        add(img);
        
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()->new OrderPage("","","",""));
    }
}
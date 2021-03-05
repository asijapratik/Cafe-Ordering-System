package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Personinfo extends JFrame implements ActionListener{
    
    JLabel head,name,phno,type,img;
    JTextField f1,f2;
    JRadioButton jrb1,jrb2,jrb3;
    JButton jb;
    Font f,ff;
    ButtonGroup bg;
    String username;
    Personinfo(String username)
    {
        this.username=username;
        setVisible(true);
        setSize(600,600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Customer Details");
//        Color cl=new Color(90,90,90);
//        getContentPane().setBackground(cl);
        
        Color color=new Color(0,60,250);
        f=new Font("Sans-Serif",Font.BOLD,30);
        head=new JLabel("Customer Details",JLabel.CENTER);
        add(head);
        head.setFont(f);
        head.setOpaque(true);
        head.setBackground(color);
        head.setBounds(20,20,540,80);
        
        ff=new Font("Sans-Serif",Font.BOLD,15);
        name=new JLabel("Name: ");
        name.setBounds(30,120,80,30);
        name.setFont(ff);
        f1=new JTextField(10);
        f1.setBounds(30,150,200,30);
        add(name);
        add(f1);
        
        phno=new JLabel("Phone Number: ");
        phno.setBounds(30,220,150,30);
        phno.setFont(ff);
        f2=new JTextField(10);
        f2.setBounds(30,250,200,30);
        
        add(phno);
        add(f2);
        
        bg=new ButtonGroup();
        type=new JLabel("Order Type: ");
        type.setFont(ff);
        type.setBounds(30,320,100,30);
        jrb1=new JRadioButton("Eat In");
        jrb1.setBounds(50,360,100,30);
        jrb2=new JRadioButton("TakeAway");
        jrb2.setBounds(50,390, 100, 30);
        jrb3=new JRadioButton("Delivery");
        jrb3.setBounds(50,420,100,30);
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        add(type);
        add(jrb1);
        add(jrb2);
        add(jrb3);
        
        jb=new JButton("Continue ");
        jb.setBounds(80,500,100,30);
        add(jb);
        jb.addActionListener(this);
        
        ImageIcon ic=new ImageIcon(getClass().getResource("food.png"));
        ic=new ImageIcon(ic.getImage().getScaledInstance(280, 400, Image.SCALE_DEFAULT));
        img=new JLabel(ic);
        img.setBounds(280,120,280,400);
        add(img);
        
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()->new Personinfo(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String regex="^\\d{10}$";
        String n=f1.getText();
        String p=f2.getText();
        String t="";
        if(jrb1.isSelected())
            t=jrb1.getText();
        else if(jrb2.isSelected())
            t=jrb2.getText();
        else if(jrb3.isSelected())
            t=jrb3.getText();
        if(n.isEmpty()||p.isEmpty()||t.isEmpty())
            JOptionPane.showMessageDialog(this,"All fields are required","No empty Fields",JOptionPane.DEFAULT_OPTION);
        else
        {
            if(!p.matches(regex))
                JOptionPane.showMessageDialog(this,"Phone Number Should be 10 digits","Wrong Phone Number",JOptionPane.INFORMATION_MESSAGE);
            else
            {
                new OrderPage(username,n,p,t);
                setVisible(false);
            }
        }
    }
}
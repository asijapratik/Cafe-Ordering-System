package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Snacks extends JFrame implements ActionListener
{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel color1;
    JLabel color2;
    JLabel color3;
    JLabel color4;
    JLabel color5;
    JLabel imgl1;
    JLabel imgl2;
    JLabel imgl3;
    JLabel imgl4;
    JLabel imgl5;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JButton d1;
    JButton i1;
    JButton d2;
    JButton i2;
    JButton d3;
    JButton i3;
    JButton d4;
    JButton i4;
    JButton d5;
    JButton i5;
    JButton done;
    ImageIcon img1;
    ImageIcon img2;
    ImageIcon img3;
    ImageIcon img4;
    ImageIcon img5;
    Font font1;
    Font font2;
    Font font3;
    Font font4;
    int a1,a2,a3,a4,a5;
    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    Snacks()
    {
        setVisible(true);
        setSize(400,650);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Select Snacks");
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
        Color color=new Color(0,60,250);
        label1=new JLabel("Snacks",JLabel.CENTER);
        label1.setOpaque(true);
        label1.setBackground(color);
        label2=new JLabel("Pasta");
        label2.setToolTipText("Pasta");
        label3=new JLabel("Cheese Burger");
        label3.setToolTipText("Cheese Burger");
        label4=new JLabel("Grilled Sandwich");
        label4.setToolTipText("Grilled Sandwich");
        label5=new JLabel("Tacos");
        label5.setToolTipText("Tacos");
        label6=new JLabel("Onion Rings");
        label6.setToolTipText("Onion Rings");
        label7=new JLabel("Rs 140");
        label8=new JLabel("Rs 60");
        label9=new JLabel("Rs 80");
        label10=new JLabel("Rs 100");
        label11=new JLabel("Rs 70");
        color1=new JLabel();
        color2=new JLabel();
        color3=new JLabel();
        color4=new JLabel();
        color5=new JLabel();
        imgl1=new JLabel(img1);
        imgl2=new JLabel(img2);
        imgl3=new JLabel(img3);
        imgl4=new JLabel(img4);
        imgl5=new JLabel(img5);
        t1=new JTextField("0",JTextField.CENTER);
        t2=new JTextField("0",JTextField.CENTER);
        t3=new JTextField("0",JTextField.CENTER);
        t4=new JTextField("0",JTextField.CENTER);
        t5=new JTextField("0",JTextField.CENTER);
        d1=new JButton("-");
        i1=new JButton("+");
        d2=new JButton("-");
        i2=new JButton("+");
        d3=new JButton("-");
        i3=new JButton("+");
        d4=new JButton("-");
        i4=new JButton("+");
        d5=new JButton("-");
        i5=new JButton("+");
        done=new JButton("Add to cart");
        img1=new ImageIcon(getClass().getResource("Food Items\\Pasta.jpg"));
        img1=new ImageIcon(img1.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        imgl1=new JLabel(img1);
        img2=new ImageIcon(getClass().getResource("Food Items\\CheeseBurger.jpg"));
        img2=new ImageIcon(img2.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        imgl2=new JLabel(img2);
        img3=new ImageIcon(getClass().getResource("Food Items\\Grilled Sandwich.jpg"));
        img3=new ImageIcon(img3.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        imgl3=new JLabel(img3);
        img4=new ImageIcon(getClass().getResource("Food Items\\Tacos.jpg"));
        img4=new ImageIcon(img4.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        imgl4=new JLabel(img4);
        img5=new ImageIcon(getClass().getResource("Food Items\\Onion Rings.jpg"));
        img5=new ImageIcon(img5.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        imgl5=new JLabel(img5);
        font1=new Font("Sans",Font.BOLD,40);
        font2=new Font("Sans",Font.BOLD,20);
        font3=new Font("Sans",Font.BOLD,15);
        font4=new Font("Sans",Font.BOLD,10);
        
        color1.setBounds(0,60,400,80);
        //color1.setOpaque(true);
        color2.setBounds(0,150,400,80);
        //color2.setOpaque(true);
        color3.setBounds(0,240,400,80);
        //color3.setOpaque(true);
        color4.setBounds(0,330,400,80);
        //color4.setOpaque(true);
        color5.setBounds(0,420,400,80);
        //color5.setOpaque(true);
        label1.setBounds(0,0,400,50);
        label2.setBounds(90,100,200,25);
        label3.setBounds(90,190,200,25);
        label4.setBounds(90,280,200,25);
        label5.setBounds(90,370,200,25);
        label6.setBounds(90,460,200,25);
        label7.setBounds(90,130,100,25);
        label8.setBounds(90,220,100,25);
        label9.setBounds(90,310,100,25);
        label10.setBounds(90,400,100,25);
        label11.setBounds(90,490,100,25);
        imgl1.setBounds(0,85,80,80);
        imgl2.setBounds(0,175,80,80);
        imgl3.setBounds(0,265,80,80);
        imgl4.setBounds(0,355,80,80);
        imgl5.setBounds(0,445,80,80);
        t1.setBounds(310,110,30,30);
        t2.setBounds(310,200,30,30);
        t3.setBounds(310,280,30,30);
        t4.setBounds(310,380,30,30);
        t5.setBounds(310,470,30,30);
        d1.setBounds(280,110,30,30);
        i1.setBounds(340,110,30,30);
        d2.setBounds(280,200,30,30);
        i2.setBounds(340,200,30,30);
        d3.setBounds(280,280,30,30);
        i3.setBounds(340,280,30,30);
        d4.setBounds(280,380,30,30);
        i4.setBounds(340,380,30,30);
        d5.setBounds(280,470,30,30);
        i5.setBounds(340,470,30,30);
        done.setBounds(130,545,140,50);
        label1.setFont(font1);
        label2.setFont(font2);
        label3.setFont(font2);
        label4.setFont(font2);
        label5.setFont(font2);
        label6.setFont(font2);
        label7.setFont(font3);
        label8.setFont(font3);
        label9.setFont(font3);
        label10.setFont(font3);
        label11.setFont(font3);
        t1.setFont(font3);
        t2.setFont(font3);
        t3.setFont(font3);
        t4.setFont(font3);
        t5.setFont(font3);
        i1.setFont(font3);
        i2.setFont(font3);
        i3.setFont(font3);
        i4.setFont(font3);
        i5.setFont(font3);
        d1.setFont(font3);
        d2.setFont(font3);
        d3.setFont(font3);
        d4.setFont(font3);
        d5.setFont(font3);
        done.setFont(font3);
        color1.setBackground(Color.GRAY);
        color2.setBackground(Color.GRAY);
        color3.setBackground(Color.GRAY);
        color4.setBackground(Color.GRAY);
        color5.setBackground(Color.GRAY);
        
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.getHSBColor(212,175,55));
        label3.setForeground(Color.getHSBColor(212,175,55));
        label4.setForeground(Color.getHSBColor(212,175,55));
        label5.setForeground(Color.getHSBColor(212,175,55));
        label6.setForeground(Color.getHSBColor(212,175,55));
        label7.setForeground(Color.getHSBColor(212,175,55));
        label8.setForeground(Color.getHSBColor(212,175,55));
        label9.setForeground(Color.getHSBColor(212,175,55));
        label10.setForeground(Color.getHSBColor(212,175,55));
        label11.setForeground(Color.getHSBColor(212,175,55));
        done.setBackground(Color.GREEN);
        done.setForeground(Color.WHITE);
        
        i1.setMargin(new Insets(1,1,1,1));
        d1.setMargin(new Insets(1,1,1,1));
        i2.setMargin(new Insets(1,1,1,1));
        d2.setMargin(new Insets(1,1,1,1));
        i3.setMargin(new Insets(1,1,1,1));
        d3.setMargin(new Insets(1,1,1,1));
        i4.setMargin(new Insets(1,1,1,1));
        d4.setMargin(new Insets(1,1,1,1));
        i5.setMargin(new Insets(1,1,1,1));
        d5.setMargin(new Insets(1,1,1,1));
        done.setMargin(new Insets(1,1,1,1));
        
        add(color1);
        add(color2);
        add(color3);
        add(color4);
        add(color5);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(label9);
        add(label10);
        add(label11);
        add(imgl1);
        add(imgl2);
        add(imgl3);
        add(imgl4);
        add(imgl5);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(d1);
        add(i1);
        add(d2);
        add(i2);
        add(d3);
        add(i3);
        add(d4);
        add(i4);
        add(d5);
        add(i5);
        add(done);
        
        d1.addActionListener(this);
        i1.addActionListener(this);
        d2.addActionListener(this);
        i2.addActionListener(this);
        d3.addActionListener(this);
        i3.addActionListener(this);
        d4.addActionListener(this);
        i4.addActionListener(this);
        d5.addActionListener(this);
        i5.addActionListener(this);
        done.addActionListener((ActionEvent e)->{
            hm.put("Pasta",a1);
            hm.put("Burger", a2);
            hm.put("Grilled Sandwich", a3);
            hm.put("Tacos", a4);
            hm.put("Onion Rings",a5);
            //System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5);
            try{
                 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
                 String query="Update order_items set quantity=? where item=?;";
                 PreparedStatement ps=c.prepareStatement(query);
                 for(Map.Entry s:hm.entrySet())
                 {
                     String key=(String)s.getKey();
                     int value=(int)s.getValue();
                     ps.setInt(1,value);
                     ps.setString(2,key);
                     ps.addBatch();
                     //System.out.println(value+" "+key);
                 }
                 ps.executeBatch();
                 ps.close();
                 c.close();
            }
            catch(Exception es)
            {
                System.out.println(es);
            }
            setVisible(false);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s1=t1.getText();
        a1=Integer.parseInt(s1);
        String s2=t2.getText();
        a2=Integer.parseInt(s2);
        String s3=t3.getText();
        a3=Integer.parseInt(s3);
        String s4=t4.getText();
        a4=Integer.parseInt(s4);
        String s5=t5.getText();
        a5=Integer.parseInt(s5);
        if(e.getSource()==d1)
        {
            if(a1>0)
            {
                a1--;
                String s=String.valueOf(a1);
                t1.setText(s);
            }
        }
        else if(e.getSource()==i1)
        {
            a1++;
            String s=String.valueOf(a1);
            t1.setText(s);
        }
        else if(e.getSource()==d2)
        {
            if(a2>0)
            {
                a2--;
                String s=String.valueOf(a2);
                t2.setText(s);
            }
        }
        else if(e.getSource()==i2)
        {
            a2++;
            String s=String.valueOf(a2);
            t2.setText(s);
        }
        else if(e.getSource()==d3)
        {
            if(a3>0)
            {
                a3--;
                String s=String.valueOf(a3);
                t3.setText(s);
            }
        }
        else if(e.getSource()==i3)
        {
            a3++;
            String s=String.valueOf(a3);
            t3.setText(s);
        }
        else if(e.getSource()==d4)
        {
            if(a4>0)
            {
                a4--;
                String s=String.valueOf(a4);
                t4.setText(s);
            }
        }
        else if(e.getSource()==i4)
        {
            a4++;
            String s=String.valueOf(a4);
            t4.setText(s);
        }
        else if(e.getSource()==d5)
        {
            if(a5>0)
            {
                a5--;
                String s=String.valueOf(a5);
                t5.setText(s);
            }
        }
        else if(e.getSource()==i5)
        {
            a5++;
            String s=String.valueOf(a5);
            t5.setText(s);
        }
    }
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(()->{
            new Snacks();
        });
    }
}

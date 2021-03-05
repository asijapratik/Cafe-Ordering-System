package restaurant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class bill extends JFrame
{
    String named;
    String phno;
    JLabel name,cafe,phone,dateTime,total,payment,balance,thanks;
    ArrayList<JLabel> al;
    JLabel it,quan,price,tprice;
    JPanel jp;
    String pay;
    
    bill(String named,String phno,String pay)
    {
        this.named=named;
        this.phno=phno;
        this.pay=pay;
        setVisible(true);
        //setSize(600,700);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bill");
        
        setLayout(null);
        
        jp=new JPanel();
        jp.setLayout(null);
        jp.setOpaque(true);
        jp.setBackground(Color.black);
        al=new ArrayList<>();
        cafe=new JLabel("Old Town Cafe");
        name=new JLabel("Name: "+named);
        phone=new JLabel("Phone Number: "+phno);
        dateTime=new JLabel("Date and Time: "+LocalDateTime.now());
        it=new JLabel("Items",JLabel.CENTER);
        price=new JLabel("Price",JLabel.CENTER);
        quan=new JLabel("Quantity",JLabel.CENTER);
        tprice=new JLabel("Total Price",JLabel.CENTER);
        
        total=new JLabel("Total: Rs. ");
        payment=new JLabel("Payment : Rs. ");
        balance=new JLabel("Balance : Rs. ");
        thanks=new JLabel("Thanks for visiting");
        Font font1=new Font("Sans",Font.BOLD,40);
        Font font2=new Font("Sans",Font.BOLD,30);
        Font font3=new Font("Sans",Font.BOLD,20);
        Font font4=new Font("Sans",Font.BOLD,10);
        
        Font font5=it.getFont();
        Map attributes=font5.getAttributes();
        attributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        attributes.put(TextAttribute.SIZE,20);
        attributes.put(TextAttribute.WEIGHT,TextAttribute.WEIGHT_BOLD);
        attributes.put(TextAttribute.KERNING,TextAttribute.KERNING_ON);
        it.setFont(font5.deriveFont(attributes));
        price.setFont(font5.deriveFont(attributes));
        quan.setFont(font5.deriveFont(attributes));
        tprice.setFont(font5.deriveFont(attributes));
        
        
        
        cafe.setBounds(80,0,520,50);
        name.setBounds(0,70,400,40);
        phone.setBounds(0,120,400,40);
        dateTime.setBounds(0,170,500,40);
        it.setBounds(20,230,100,40);
        price.setBounds(170,230,100,40);
        quan.setBounds(280,230,100,40);
        tprice.setBounds(390,230,150,40);
        total.setBounds(360,580,400,40);
        thanks.setBounds(50,620,400,40);
        
        cafe.setFont(font1);
        name.setFont(font3);
        phone.setFont(font3);
        dateTime.setFont(font3);
        total.setFont(font3);
        payment.setFont(font3);
        balance.setFont(font3);
        thanks.setFont(font2);
        
        cafe.setForeground(Color.getHSBColor(212,175,55));
        name.setForeground(Color.WHITE);
        phone.setForeground(Color.WHITE);
        dateTime.setForeground(Color.WHITE);
        it.setForeground(Color.WHITE);
        price.setForeground(Color.WHITE);
        quan.setForeground(Color.WHITE);
        tprice.setForeground(Color.WHITE);
        total.setForeground(Color.WHITE);
        payment.setForeground(Color.WHITE);
        balance.setForeground(Color.WHITE);
        thanks.setForeground(Color.getHSBColor(212,175,55));
        
        jp.add(cafe);
        jp.add(name);
        jp.add(phone);
        jp.add(dateTime);
        jp.add(total);
        jp.add(thanks);
        jp.add(it);
        jp.add(price);
        jp.add(quan);
        jp.add(balance);
        jp.add(payment);
        jp.add(tprice);
        try{
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
            Statement st=c.createStatement();
            String query="Select * from order_items where quantity>=1;";
            ResultSet rs=st.executeQuery(query);
            Double totalPrice=0.0;
            int titems=0;
            while(rs.next())
            {
                //String p1=items.getText();
                String it1=rs.getString(1);
                double p2=rs.getDouble(2);
                String it2=Double.toString(p2);
                int p3=rs.getInt(3);
                String it3=Integer.toString(p3);
                double p4=p2*p3;
                totalPrice+=p4;
                String it4=Double.toString(p4);
                String fina=it1+" "+it2+" "+it3+" "+it4;
                al.add(new JLabel(fina));
                titems++;
            }
            rs.close();
            st.close();
            c.close();
            Font f=new Font("Sans",Font.ITALIC,20);
            Color cl=new Color(240,255,240);
            int x=20,height=30,y=270;
            JLabel jl1,jl2,jl3,jl4;
            for(JLabel jl:al)
            {
                String[] a=jl.getText().split(" ");
                if(a.length==5)
                {
                    jl1=new JLabel(a[0]+" "+a[1]);
                    jl2=new JLabel(a[2],JLabel.RIGHT);
                    jl3=new JLabel(a[3],JLabel.RIGHT);
                    jl4=new JLabel(a[4],JLabel.RIGHT);
                }
                else
                {
                    jl1=new JLabel(a[0]);
                    jl2=new JLabel(a[1],JLabel.RIGHT);
                    jl3=new JLabel(a[2],JLabel.RIGHT);
                    jl4=new JLabel(a[3],JLabel.RIGHT);
                }
                jl1.setFont(f);
                jl2.setFont(f);
                jl3.setFont(f);
                jl4.setFont(f);
                jl1.setForeground(cl);
                jl2.setForeground(cl);
                jl3.setForeground(cl);
                jl4.setForeground(cl);
                jl1.setBounds(20,y,200,height);
                jl2.setBounds(170,y,80,height);
                jl3.setBounds(290,y,40,height);
                jl4.setBounds(380,y,100,height);
                y+=30;
                jp.add(jl1);
                jp.add(jl2);
                jp.add(jl3);
                jp.add(jl4);
            }
            //items.setText(items.getText()+Integer.toString(titems));
            total.setText(total.getText()+Double.toString(totalPrice));
            payment.setText(payment.getText()+pay);
            balance.setText(balance.getText()+Double.toString(0.0-totalPrice+Double.parseDouble(pay)));
            total.setBounds(360,y+50,400,40);
            payment.setBounds(360,y+90,400,40);
            balance.setBounds(360,y+130,400,40);
            thanks.setBounds(120,y+170,400,40);
            setSize(600,y+280);
            jp.setBounds(0,0,600,y+280);
            setLocationRelativeTo(null);
            add(jp);
            
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Bill");
            
            job.setPrintable(new Printable(){
                @Override
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.24,0.24);
                
                jp.paint(g2);
//          
               
                return Printable.PAGE_EXISTS;
                }
            });
         
            boolean ok = job.printDialog();
            if(ok){
                try{
                    job.print();
                }
                catch (PrinterException ex){}
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(()->{
            new bill("Pratik","9849887424","4000");
        });
    }
}

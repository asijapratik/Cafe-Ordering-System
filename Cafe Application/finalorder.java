package restaurant;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
public class finalorder extends JFrame implements KeyListener,ActionListener{
    
    JTable jt;
    JLabel head,l1,l2,l3;
    JTextField t1,t2,t3;
    Font f;
    JButton b1,b2;
    Connection c;
    DefaultTableModel dm;
    OrderPage pg;
    String username,name,phno,order;
    public finalorder(String username,String name,String phno,String order,OrderPage pg) throws SQLException {
        
        this.username=username;
        this.name=name;
        this.phno=phno;
        this.order=order;
        this.pg=pg;
        
        setVisible(true);
        setSize(600,600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Final Order Items");
        
        Color color=new Color(0,60,250);
        f=new Font("Sans-Serif",Font.BOLD,30);
        head=new JLabel("Final Order Items",JLabel.CENTER);
        add(head);
        head.setFont(f);
        head.setOpaque(true);
        head.setBackground(color);
        head.setBounds(20,20,540,80);
        
        String[] columnnames={"Item","Price","Quantity","Total"};
        dm=new DefaultTableModel(columnnames,0);
        
        
        l1=new JLabel("Total");
        l1.setBounds(400,120,100,30);
        add(l1);
        t1=new JTextField(20);
        t1.setBounds(400,150,100,30);
        t1.setEditable(false);
        add(t1);
        t1.setText("0.00");
        
        l2=new JLabel("Payment");
        l2.setBounds(400,200,100,30);
        add(l2);
        t2=new JTextField(20);
        t2.setBounds(400,230,100,30);
        t2.addKeyListener(this);
        add(t2);
        
        l3=new JLabel("Balance");
        l3.setBounds(400,280,100,30);
        add(l3);
        t3=new JTextField();
        
        
        t3.setBounds(400,310,100,30);
        t3.setEditable(false);
        add(t3);
        
        b1=new JButton("Remove");
        b1.setBounds(420,390,100,30);
        add(b1);
        b1.addActionListener(this);
        
        
        b2=new JButton("Print Receipt");
        b2.setBounds(395,450,150,30);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBackground(Color.red);
        add(b2);
        b2.addActionListener(this);
        
        
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
        Statement st=c.createStatement();
        String query="Select * from order_items where quantity>=1";
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            String item=rs.getString(1);
            String price=Double.toString(rs.getDouble(2));
            String quantity=Integer.toString(rs.getInt(3));
            String total=Double.toString(Double.parseDouble(price)*Integer.parseInt(quantity));
            dm.addRow(new String[]{item,price,quantity,total});
            t1.setText(Double.toString(Double.parseDouble(t1.getText())+Double.parseDouble(total)));
        }
        rs.close();
        st.close();

        jt=new JTable(dm);
        JScrollPane js=new JScrollPane(jt);
        js.setBounds(10,120,350,400);
        add(js);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jt.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jt.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jt.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(()->{
            try {
                new finalorder("","","","",new OrderPage("","","",""));
            } catch (SQLException ex) {
                Logger.getLogger(finalorder.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String a=t1.getText();
        String b=t2.getText().isEmpty()?"0.0":t2.getText();
       if(e.getKeyCode()==KeyEvent.VK_ENTER)
           if(Double.parseDouble(b)-Double.parseDouble(a)<0)
               JOptionPane.showMessageDialog(this,"Please Enter a valid amount","Incorrect",JOptionPane.WARNING_MESSAGE);
           else
           t3.setText(Double.toString(Double.parseDouble(t2.getText())-Double.parseDouble(t1.getText())));           
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1)
            {
                String query="Update order_items set quantity=0 where item=?";
                PreparedStatement ps=c.prepareStatement(query);
                int[] indexes=jt.getSelectedRows();
                for(int i:indexes)
                {
                    String a=(String)jt.getModel().getValueAt(i,0);
                    ps.setString(1,a);
                    ps.addBatch();
                    String x=(String) jt.getModel().getValueAt(i,3);
                    double y=Double.parseDouble(x);
                    double z=Double.parseDouble(t1.getText());
                    t1.setText(Double.toString(z-y));
                    dm.removeRow(i);
                }
                ps.executeBatch();
                ps.close();
                if(!t2.getText().isEmpty()&&!t2.getText().equals("0.0"))
                    t3.setText(Double.toString((Double.parseDouble(t2.getText())-Double.parseDouble(t1.getText()))));
            }
            if(e.getSource()==b2)
            {
                if(t2.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this,"Please Enter a payment amount","Amount Not Entered",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Double.parseDouble(t2.getText())<Double.parseDouble(t1.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Please Enter a valid amount","Incorrect",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    Statement st=c.createStatement();
                    //System.out.print(name+"!"+phno+"!"+order+"!"+t1.getText()+"!"+username);
                    String query="Insert into previous_orders (name,phone_number,order_type,Billing_Date,Total_Price,Billed_By) values('"+name+"','"+phno+"','"+order+"',curDate(),"+t1.getText()+",'"+username+"');";                
                    st.executeUpdate(query);
                    st.close();
                    String p=t2.getText();
                    new bill(name,phno,p);
                    pg.setVisible(false);
                    setVisible(false);
                }
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(finalorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

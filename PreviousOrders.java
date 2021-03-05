package restaurant;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class PreviousOrders extends JFrame{

    JLabel head;
    Font f;
    JTable jt;
    PreviousOrders() {
        setVisible(true);
        setSize(600,600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Previous Orders");
        
        Color color=new Color(0,60,250);
        f=new Font("Sans-Serif",Font.BOLD,30);
        head=new JLabel("Previous Orders",JLabel.CENTER);
        add(head);
        head.setFont(f);
        head.setOpaque(true);
        head.setBackground(color);
        head.setBounds(20,20,540,80);
        
        String[] columnnames={"Id","Name","Phone Number","Order_Type","Billing Date","Total_Price","Billed_By"};
        DefaultTableModel dm=new DefaultTableModel(columnnames,0);
        try{
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
        Statement st=c.createStatement();
        String query="Select * from previous_orders";
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            String id=Integer.toString(rs.getInt(1));
            String name=rs.getString(2);
            String number=rs.getString(3);
            String order_type=rs.getString(4);
            Date billing=rs.getDate(5);
            String date=billing.toString();
            String price=Double.toString(rs.getDouble(6));
            String employee=rs.getString(7);
            dm.addRow(new String[]{id,name,number,order_type,date,price,employee});
        }
        rs.close();
        st.close();
        c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        jt=new JTable(dm);
        JScrollPane js=new JScrollPane(jt);
        js.setBounds(10,120,560,400);
        add(js);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jt.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        jt.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jt.getColumnModel().getColumn(0).setPreferredWidth(20);
        jt.getColumnModel().getColumn(2).setPreferredWidth(80);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()->new PreviousOrders());
    }
}


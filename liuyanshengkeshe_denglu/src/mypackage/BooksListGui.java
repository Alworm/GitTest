/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author lenovo
 */
public class BooksListGui extends JFrame implements ItemListener{
    String[] booksnumber = new String[200];
    String[] booksname = new String[200];
    String[] booksmoney = new String[200];
    JComboBox box;
    Container con;
    JButton buttonConfirm,buttonCancel;
    MyPanel_BooksList imgPanel;
    /*存储添加的书籍的名字*/
    String addbookname;
    public BooksListGui(){
        super("选择图书");
        imgPanel = new MyPanel_BooksList();
        imgPanel.setLayout(null);
        con = getContentPane();
//        con.setLayout(new BorderLayout());
//        JPanel buttonPanel = new JPanel();
        buttonConfirm = new JButton("确定");

        buttonCancel = new JButton("取消");
        buttonCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
//                dispose();
//                System.exit(0);
            }
        });
//        buttonPanel.add(buttonConfirm);
//        buttonPanel.add(buttonCancel);
        /*连接数据库，初始化书籍列表*/
        box = new JComboBox();
        
        int i=0;
        String str = "select booknumber,bookname,bookmoney from books";
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
        String userName = "sa";
        String userPwd = "123456789";
        Statement stmt = null;
        ResultSet rs = null;
        // 加载与SQLserver数据库连接的驱动
        try {
           Class.forName(driverName);
           System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            // 与数据库连接
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");
            String SQL = str;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            box.addItem("无");
            while(rs.next()) {
                booksnumber[i]=rs.getString("booknumber");
                booksname[i]=rs.getString("bookname");
                booksmoney[i]=rs.getString("bookmoney");
                box.addItem(booksname[i]);
//                text.append(rs.getString("booknumber")+"   "
//                        +rs.getString("bookname")+rs.getString("bookmoney")+"\n");
           }
            
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        buttonConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                MyLibrary myli = new MyLibrary("");
//                myli.addNewBooks(addbookname);
                /*在原来的图书页面加一个新的书籍，是static*/
                Management m = new Management("");
                m.myli.addNewBooks(addbookname);
                setVisible(false);
                
                
            }
        });
        
        
        
        box.addItemListener(this);
        box.setEditable(false);
        
        
        imgPanel.add(box);
//        imgPanel.add(buttonPanel);
        imgPanel.add(buttonConfirm);
        imgPanel.add(buttonCancel);
        box.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        box.setSize(180,31);
        box.setLocation(70,70);
        buttonConfirm.setSize(60,30);
        buttonConfirm.setFont(new Font("微软雅黑",Font.PLAIN,13));
        buttonCancel.setSize(60,30);
        buttonConfirm.setLocation(70,153);
        buttonCancel.setLocation(180,153);
        buttonCancel.setFont(new Font("微软雅黑",Font.PLAIN,13));
        
//        buttonPanel.setSize(200,50);
//        buttonPanel.setLocation(100,200);
        con.add(imgPanel);
//        con.add(box,BorderLayout.NORTH);
//        con.add(buttonPanel,BorderLayout.CENTER);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(328,362);
        setLocation(location(getSize()));
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getItemSelectable() instanceof JComboBox){
            String s =(String)(box.getSelectedItem());
            System.out.println("itemStateChanged"+s);
            this.addbookname = s;
        }
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    
    
}

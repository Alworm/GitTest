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
public class SelectBook extends JFrame implements ActionListener{
    private String str = "select booknumber,bookname,bookmoney from books";
    Container con;
    JLabel numberLabel,nameLabel,moneyLabel;
    JTextArea text;
    JScrollPane scroll;
    public SelectBook(){
        super("图书查询界面");
        con = getContentPane();
        con.setLayout(new BorderLayout());
        
        
        text = new JTextArea();
        text.setEditable(false);
        scroll = new JScrollPane(text);
        
        numberLabel = new JLabel("书籍的编号");
        nameLabel = new JLabel("书籍的名字");
        moneyLabel = new JLabel("书籍的价格");

        JPanel top  = new JPanel();
        top.add(numberLabel);
        top.add(nameLabel);
        top.add(moneyLabel);
        con.add(top,BorderLayout.NORTH);
        con.add(scroll,BorderLayout.CENTER);
        /*位置居中*/
//        setLocation(location(getSize()));
        setLocation(550,250);
//        pack();
        setSize(400,250);
        setVisible(true);
        /*不能有这个，否则关闭查询界面会关闭整个*/
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        selectBookInformation();
        
        
    }
    public JPanel getCenterTop(){
        numberLabel = new JLabel("书籍的编号");
        numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nameLabel = new JLabel("书籍的名字");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        moneyLabel = new JLabel("书籍的价格");
        moneyLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        JPanel top  = new JPanel();
        top.add(numberLabel);
        top.add(Box.createHorizontalStrut(120));
        top.add(nameLabel);
        top.add(Box.createHorizontalStrut(120));
        top.add(moneyLabel);
        return top;
    }
    public JTextArea getTextInformation(){/*返回查询的数据*/
        text = new JTextArea();
        text.setEditable(false);
        selectBookInformation();
        return text;
    }
    public String getSelectStr(){
        return this.str;
    }
    public void setSelectStr(String str){
        this.str = str;
    }
    public void selectBookInformation(){
        
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
            while(rs.next()) {
                text.append(rs.getString("booknumber")+"   "
                        +rs.getString("bookname")+rs.getString("bookmoney")+"\n");
           }
            
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        
    }
    
    public void actionPerformed(ActionEvent e){
//        text.setText(str);
        
        
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    
    
}

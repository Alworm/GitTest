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
public class SelectBookLabel extends JFrame implements ActionListener{
    private String str = "select booknumber,bookname,bookmoney from books";
    Container con;
    JLabel numberLabel,nameLabel,moneyLabel;
    JScrollPane scroll;
    JLabel[] lab1 = new JLabel[200];
    JLabel[] lab2 = new JLabel[200];
    JLabel[] lab3 = new JLabel[200];
//    JPanel[] panelarr = new JPanel[200];
    JPanel panelCenter = new JPanel();
    JPanel left,center,right,top;
    public SelectBookLabel(){
        super("图书查询界面");
        con = getContentPane();
        con.setLayout(new BorderLayout());
        
        numberLabel = new JLabel("书籍的编号");
        numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        nameLabel = new JLabel("书籍的名字");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        moneyLabel = new JLabel("书籍的价格");
        moneyLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        
        top = new JPanel();
        top.setLayout(new BoxLayout(top,BoxLayout.X_AXIS));
        top.add(Box.createHorizontalStrut(20));
        top.add(numberLabel);
        top.add(Box.createHorizontalStrut(50));
        top.add(nameLabel);
        top.add(Box.createHorizontalStrut(50));
        top.add(moneyLabel);
        top.add(Box.createHorizontalStrut(20));
        
        con.add(top,BorderLayout.NORTH);
        left  = new JPanel();
        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
//        left.add(numberLabel);
        
        center = new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
//        center.add(nameLabel);
        
        right = new JPanel();
        right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
//        right.add(moneyLabel);
        /*添加滚动面板和文字输出区域*/
//        con.add(scroll,BorderLayout.CENTER);
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
            int k=0;
            while(rs.next()) {
                lab1[k] = new JLabel(rs.getString("booknumber"));
                lab1[k].setFont(new Font("微软雅黑", Font.PLAIN, 20));
                lab2[k] = new JLabel(rs.getString("bookname"));
                lab2[k].setFont(new Font("微软雅黑", Font.PLAIN, 20));
                lab3[k] = new JLabel(rs.getString("bookmoney"));
                lab3[k].setFont(new Font("微软雅黑", Font.PLAIN, 20));
                left.add(lab1[k]);
                center.add(lab2[k]);
                right.add(lab3[k]);
                panelCenter = new JPanel();
                panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.X_AXIS));
                k++;
           }
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        /*调用使用label*/
//        selectBookInformation();
        panelCenter.add(Box.createHorizontalStrut(45));
        panelCenter.add(left);
        panelCenter.add(Box.createHorizontalStrut(65));
        panelCenter.add(center);
        panelCenter.add(Box.createHorizontalStrut(25));
        panelCenter.add(right);
        panelCenter.add(Box.createHorizontalStrut(30));
        scroll = new JScrollPane(panelCenter);
        con.add(scroll,BorderLayout.CENTER);
         /*位置居中*/
//        setLocation(location(getSize()));
        setLocation(550,250);
        setSize(540,477);
        setVisible(true);
        /*不能有这个，否则关闭查询界面会关闭整个*/
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
    public String getSelectStr(){
        return this.str;
    }
    public void setSelectStr(String str){
        this.str = str;
    }
    public void selectBookInformation(){
        /*
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
            int k=0;
            while(rs.next()) {
                lab1[k] = new JLabel(rs.getString("booknumber"));
                lab2[k] = new JLabel(rs.getString("bookname"));
                lab3[k] = new JLabel(rs.getString("bookmoney"));
                k++;
           }
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        */
        
    }
    public void actionPerformed(ActionEvent e){
        
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    
}

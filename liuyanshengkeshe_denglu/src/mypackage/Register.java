/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mydatastructure.*;

public class Register extends JFrame implements ActionListener{
    JLabel label1,label2,label3,label4;
    JTextField tf1,tf2;
    JPasswordField tp1,tp2;
    Container con;
    JButton button1,button2;
    
    public UserData data;//public 方便检查
    
    private String usename;
    private String password;
    private String qpassword;
    private String email;
    
    /*背景gif*/
    MyPanel_Register gifpanel;
    JPanel mypanel;
    public Register(){
        super("用户注册");
        
        gifpanel = new MyPanel_Register();
        gifpanel.setLayout(null);
        mypanel = new JPanel(new BoxLayout(mypanel,BoxLayout.PAGE_AXIS));
        
        con = getContentPane();
//        con.setLayout(new BoxLayout(con,BoxLayout.PAGE_AXIS));
        
        /*用户名面板*/
        label1 = new JLabel("用  户  名：");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf1 = new JTextField(10);

        gifpanel.add(label1);
        gifpanel.add(tf1);
        
        
        /*输入密码面板*/
        label2 = new JLabel("输入密码：");
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tp1 = new JPasswordField(10);

        gifpanel.add(label2);
        gifpanel.add(tp1);
        
        /*确认密码面板*/
        label3 = new JLabel("确认密码：");
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tp2 = new JPasswordField(10);

        gifpanel.add(label3);
        gifpanel.add(tp2);
        
        /*电子邮箱面板*/
        label4 = new JLabel("电子邮箱：");
        label4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf2 = new JTextField(10);

        gifpanel.add(label4);
        gifpanel.add(tf2);
        
        /*按钮面板*/
        button1 = new JButton("确定");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String new_name = tf1.getText();
                String new_password =tp1.getText();
                String new_email = tf2.getText();
//                
                data = new UserData();//把数据保存好
                data.pushData(new_name, new_password, new_email);
                data.pushDataToDataBase(new_name, new_password, new_email);
            }
        });
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               usename = tf1.getText();
               password = tp1.getText();
               qpassword = tp2.getText();
               email = tf2.getText();
               if (usename.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "密码不能为空！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if (qpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请再次输入密码！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "电子邮箱不能为空！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if(!password.equals(qpassword)){
                    JOptionPane.showMessageDialog(null, "两次输入的密码不一致！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if (!usename.matches("\\w{5,15}")) {
                    JOptionPane.showMessageDialog(null, "用户名不合法！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }else if (!email.matches("\\w+@\\w+\\.\\w+")) {
                    JOptionPane.showMessageDialog(null, "请输入合法的电子邮箱！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "注册成功", "注册成功", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
           }
        });
        button2 = new JButton("取消");
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
            }
        });

        gifpanel.add(button1);
        gifpanel.add(button2);
        con.add(gifpanel);
//        pack();
        /*设置按钮的位置*/
        /*用户名位置*/
        label1.setSize(220,120);
        label1. setLocation(140,100);
        tf1.setSize(140,26);
        tf1.setLocation(250,150);
        /*密码的位置*/
        label2.setSize(220,120);
        label2.setLocation(140,150);
        tp1.setSize(140,26);
        tp1.setLocation(250,200);
        /*再次输入密码的位置*/
        label3.setSize(220,120);
        label3.setLocation(140,200);
        tp2.setSize(140,26);
        tp2.setLocation(250,250);
        /*电子邮箱的位置*/
        label4.setSize(220,120);
        label4.setLocation(140,250);
        tf2.setSize(140,26);
        tf2.setLocation(250,300);
        /*按钮的位置*/
        button1.setSize(80,28);
        button1.setLocation(140,360);
        button2.setSize(80,28);
        button2.setLocation(300,360);

        setSize(547,594);
        setVisible(true);
        setLocation(location(getSize()));
        /*此处不能有这个，否则在用此类的时候会把Login一起关掉(点差的话)*/
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

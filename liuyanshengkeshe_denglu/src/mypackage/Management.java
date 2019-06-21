/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import mypackage.*;
/**
 *
 * @author lenovo
 */
public class Management extends JFrame implements ActionListener{
    
    JButton button1,button2,button3,button4;
    JScrollPane scroll;
    Container con;
    JTextArea text;
    JPanel centertop,center,passCenter;
    public static MyLibrary myli;
    /*背景*/
    MyPanel_Management imgpanel;
    public Management(){
        super("图书管理");
        imgpanel = new MyPanel_Management();
        
        con = getContentPane();
//        con.setLayout(new BoxLayout(con,BoxLayout.PAGE_AXIS));
        JPanel top = new JPanel();
        button1 = new JButton("图书查询");
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                /*在当前页面返回数据*/
                /*
                centertop = new JPanel();
               SelectBook stb =  new SelectBook();
               centertop = stb.getCenterTop();
               text = new JTextArea();
               text = stb.getTextInformation();
               scroll = new JScrollPane(text);
               
               center = new JPanel();
               center.setLayout(new BorderLayout());
               center.add(centertop,BorderLayout.NORTH);
               center.add(scroll,BorderLayout.CENTER);
               
               imgpanel.add(center);
               setVisible(true);
               */
                /*产生一个新的页面*/
                SelectBookLabel stb = new SelectBookLabel();
            }
        });
        /*把图书查询添加到图片panel中*/
        imgpanel.add(button1);
        
        
        button2 = new JButton("个人图书");
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myli = new MyLibrary();
                
            }
        
        });
        /*把个人图书添加图片panel中*/
        imgpanel.add(button2);
        
        button3 = new JButton("修改密码");
        button3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button3.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                ChangePassword pass = new ChangePassword();
                /*
                ChangePassword pass = new ChangePassword();
                passCenter = new JPanel();
                passCenter = pass.getPasswordPane();
                con.add(passCenter);
                setVisible(true);
                */
            }
        
        });
        /*把修改密码添加到panel中*/
        imgpanel.add(button3);
        
        button4 = new JButton("退出系统");
        button4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        /*把退出系统button 添加到panel中*/
        imgpanel.add(button4);
        
        /*
        top.add(button1);
        top.add(Box.createHorizontalStrut(100));
        top.add(button2);
        top.add(Box.createHorizontalStrut(100));
        top.add(button3);
        top.add(Box.createHorizontalStrut(100));
        top.add(button4);
        
        con.add(top);
        */
        getContentPane().add(imgpanel);
//        setLocation(Location(getSize()));
        setSize(1160,650);
        setLocation(location(getSize()));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
        
    }
    public Management(String str){
        
        
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

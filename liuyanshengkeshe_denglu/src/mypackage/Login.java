/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import mydatastructure.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Login extends JFrame implements ActionListener{
    JLabel label1,label2,label3;
    JTextField tf1,tf3;
    JPasswordField tp1;
    JButton button1,button2,button3;
    Container container;
    JPanel panel1,panel2;
    public static UserData data;
    ImageIcon dengbutton;
    ImageIcon zhucebutton;
    public static Management manage;
    /*背景图片*/
    MyPanel myimgpanel;
    /*存储登录成功的用户的名字,static使每一个对象都能调用相同的当前用户名字*/
    public static String storeusername;
    public Login(){
        super("登陆界面");
        container = getContentPane();
        myimgpanel = new MyPanel();
        /*初始化数据库中的用户信息*/
        data = new UserData();
        data.upDateMap();
        
        /*第一个面板*/
        label1 = new JLabel("用户名：");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf1 = new JTextField(10);
        myimgpanel.add(label1);
        myimgpanel.add(tf1);
        
        /*第二个面板*/
        label2 = new JLabel("密    码：");
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tp1 = new JPasswordField(10);
        myimgpanel.add(label2);
        myimgpanel.add(tp1);
        /*第三个面板*/
        Random random = new Random();
        int t = random.nextInt(9999)+1000;
        String st = String.valueOf(t);
        label3 = new JLabel("验证码：   ");
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf3 = new JTextField(5);
        
        String randomText = st;
        ColorVerificationCode colorlabel = new ColorVerificationCode(st);
        colorlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        myimgpanel.add(label3);
        myimgpanel.add(tf3);
        myimgpanel.add(colorlabel);
        /*第四个面板*/
        dengbutton = new ImageIcon("denglubutton.png");
        button1 = new JButton(dengbutton);
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                data = new UserData();
                String get_name = tf1.getText();
                String get_password = tp1.getText();
                String get_code = tf3.getText();
                ColorVerificationCode code = new ColorVerificationCode();
                String truecode = code.getVerificationCode();
                //如果验证码和用户名和密码都正确，那么可以登录系统
                if(truecode.equals(get_code)){
                    if(data.checkPassword(get_name,get_password)){
                        //保存登录的用户名，便于修改密码时，检验是否正确
                        storeusername = tf1.getText();
                        manage = new Management();
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "用户名或密码不正确！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "验证码不正确！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }
                
                
            }
        });
        /*
        button2 = new JButton("退出");
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);//关闭Java虚拟机
            }
        });
         */
        button3 = new JButton();
        zhucebutton = new ImageIcon("zhucebutton.png");
        button3 = new JButton(zhucebutton);
        button3.setFocusPainted(false);//去掉聚焦线
        button3.setOpaque(false);//设定透明效果
        button3.setContentAreaFilled(false);//去掉背景点击效果
        button3.setBorder(null);//去掉边框
        JLabel meilabel = new JLabel("还没注册？");
        meilabel.setFont(new Font("楷体", Font.PLAIN, 18));
        button3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               Register r = new Register();
               
           }
            
        });
        myimgpanel.add(button1);
        myimgpanel.add(meilabel);
        myimgpanel.add(button3);
        /*设置面板位置*/
        myimgpanel.setLayout(null);
        /*用户名位置*/
        label1.setSize(200,100);
        label1. setLocation(920,240);
        tf1.setSize(160,28);
        tf1.setLocation(1000,280);
        /*密码的位置*/
        label2.setSize(200,100);
        label2.setLocation(920,325);
        tp1.setSize(160,28);
        tp1.setLocation(1000,365);
        /*验证码的位置*/
        label3.setSize(200, 100);
        label3.setLocation(920, 410);
        tf3.setSize(80, 28);
        tf3.setLocation(1000,445);
        colorlabel.setSize(80,28);
        colorlabel.setLocation(1100,440);
        /*按钮的位置*/
        button1.setSize(300,35);
        button1.setLocation(920,520);
        meilabel.setSize(90,28);
        meilabel.setLocation(920,554);
        button3.setSize(75,28);
        button3.setLocation(1000,554);
        getContentPane().add(myimgpanel);
//        pack();
        /*设置窗口的大小不能改变*/
        setResizable(false);
        setSize(1400,750);
        setLocation(100,100);
//        setLocation(location(getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public Login(String str){
        
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import mydatastructure.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ResourceBundle;
import javax.swing.event.*;
/**
 *
 * @author Administrator
 */
public class ChangePassword extends JFrame implements ActionListener{
    Container con;
    JButton button1,button2;
    JLabel passLabel, repassLabel,newpassLabel;
    JPasswordField passText,repassText,newpassText;
    JPanel center;
    String currentusername;
    public ChangePassword(){
        con =getContentPane();
        center = new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.PAGE_AXIS));
        passLabel = new JLabel("输入原始密码:        ");
        passLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        passText = new JPasswordField(10);
        JPanel p1 = new JPanel();
        p1.add(passLabel);
        p1.add(passText);
        
        newpassLabel = new JLabel("输入新密码：         ");
        newpassLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        newpassText = new JPasswordField(10);
        JPanel p2 = new JPanel();
        p2.add(newpassLabel);
        p2.add(newpassText);
        
        repassLabel = new JLabel("重新输入新密码：  ");
        repassLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        repassText = new JPasswordField(10);
        JPanel p3 = new JPanel();
        p3.add(repassLabel);
        p3.add(repassText);
        
        button1 = new JButton("确定");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login currentuser = new Login("");
                currentusername = currentuser.storeusername;
                System.out.println(currentusername);
                String currentpassword = passText.getText();
                String newcurrentpassword = newpassText.getText();
                String recurrentpassword = repassText.getText();
                
                UserData data = new UserData();
                //原始密码正确，并且两次输入的密码一致，那么可以修改密码。
                if(data.checkPassword(currentusername, currentpassword)){
                    if(newcurrentpassword.equals(recurrentpassword)){
                        data.removeKeyAndValue(currentusername);
                        data.pushUserAndPassword(currentusername, newcurrentpassword);
                        JOptionPane.showMessageDialog(null, "修改密码成功请重新登录", "修改密码成功", 
                            JOptionPane.INFORMATION_MESSAGE);
                        data.printNameAndPassword();
                        /*关闭管理界面，修改密码界面，打开新的登录界面*/
                        Login l = new Login("");
                        l.manage.setVisible(false);
                        setVisible(false);
                        new Login();
                        
                    }
                    
                }else{
                     JOptionPane.showMessageDialog(null, "原始密码不正确！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }
                
                
            }
        
        });
        
        
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2 = new JButton("取消");
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
            }
        });
        
        JPanel p4 = new JPanel();
        p4.add(button1);
        p4.add(Box.createHorizontalStrut(50));
        p4.add(button2);
        
        center.add(p1);
        center.add(p2);
        center.add(p3);
        center.add(p4);
        
        con.add(center);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,213);
        setLocation(location(getSize()));
        
    }
    public JPanel getPasswordPane(){
        /*
        center = new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.PAGE_AXIS));
        passLabel = new JLabel("输入原始密码:        ");
        passLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        passText = new JPasswordField(10);
        JPanel p1 = new JPanel();
        p1.add(passLabel);
        p1.add(passText);
        
        newpassLabel = new JLabel("输入新密码：         ");
        newpassLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        newpassText = new JPasswordField(10);
        JPanel p2 = new JPanel();
        p2.add(newpassLabel);
        p2.add(newpassText);
        
        repassLabel = new JLabel("重新输入新密码：  ");
        repassLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        repassText = new JPasswordField(10);
        JPanel p3 = new JPanel();
        p3.add(repassLabel);
        p3.add(repassText);
        
        button1 = new JButton("确定");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login currentuser = new Login("");
                currentusername = currentuser.storeusername;
                System.out.println(currentusername);
                String currentpassword = passText.getText();
                String newcurrentpassword = newpassText.getText();
                String recurrentpassword = repassText.getText();
                
                UserData data = new UserData();
                //原始密码正确，并且两次输入的密码一致，那么可以修改密码。
                if(data.checkPassword(currentusername, currentpassword)){
                    if(newcurrentpassword.equals(recurrentpassword)){
                        data.removeKeyAndValue(currentusername);
                        data.pushUserAndPassword(currentusername, newcurrentpassword);
                        JOptionPane.showMessageDialog(null, "修改密码成功请重新登录", "修改密码成功", 
                            JOptionPane.INFORMATION_MESSAGE);
                        data.printNameAndPassword();
                        new Login();
                        
                    }
                    
                }else{
                     JOptionPane.showMessageDialog(null, "原始密码不正确！", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
                }
                
                
            }
        
        });
        
        
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button2 = new JButton("取消");
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        JPanel p4 = new JPanel();
        p4.add(button1);
        p4.add(Box.createHorizontalStrut(50));
        p4.add(button2);
        
        center.add(p1);
        center.add(p2);
        center.add(p3);
        center.add(p4);*/
        
        return center;
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

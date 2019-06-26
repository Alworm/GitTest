/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author lenovo
 */
public class MyBooksButton extends JButton{
    JButton addbutton;
    ImageIcon addimg;
    public MyBooksButton(){
        addbutton = new JButton();
        addbutton.setSize(80,80);
        addimg = new ImageIcon("addhao.png");
        Image temp = addimg.getImage().getScaledInstance(addbutton.getWidth(), 
                addbutton.getHeight(), addimg.getImage().SCALE_DEFAULT);
        addimg = new ImageIcon(temp);
        addbutton.setIcon(addimg);
        
        addbutton.setFocusPainted(false);//去掉聚焦线
        addbutton.setOpaque(false);//设定透明效果
        addbutton.setContentAreaFilled(false);//去掉背景点击效果
        addbutton.setBorder(null);//去掉边框
        addbutton.setLocation(40,120);
    }
    
}

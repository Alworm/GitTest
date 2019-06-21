/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author lenovo
 */
public class MyPanel_MyBooks extends JPanel{
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        //绘制一张背景图片  view.jpg是图片的路径  lz自己设定为自己想要添加的图片
        Image image = new ImageIcon("bookscan.png").getImage();
        g.drawImage(image, 0, 0,  this.getWidth(), 
                this.getHeight(),null);//一开始添加的是this,图片不能随着变化而变化
                                        //修改成getWidth,Height就好了
        
    }
}

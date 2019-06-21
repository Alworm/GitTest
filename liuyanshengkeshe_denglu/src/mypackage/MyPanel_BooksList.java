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
public class MyPanel_BooksList extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //绘制一张背景图片  view.jpg是图片的路径  lz自己设定为自己想要添加的图片
        Image image = new ImageIcon("bookslistimg.png").getImage();
        g.drawImage(image, 0, 0, this.getHeight(),this.getWidth(),null);
    }
    
    
}

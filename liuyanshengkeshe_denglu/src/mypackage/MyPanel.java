/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author lenovo
 */
public class MyPanel extends JPanel{
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        //绘制一张背景图片  view.jpg是图片的路径  lz自己设定为自己想要添加的图片
        Image image = new ImageIcon("denglu2.jpg").getImage();
        g.drawImage(image, 0, 0, this);
    }
}
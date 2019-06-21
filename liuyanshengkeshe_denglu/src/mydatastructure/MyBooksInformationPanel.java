/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatastructure;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author lenovo
 */
public class MyBooksInformationPanel extends JFrame{
    JTextField number_text;
    JTextField bookname_text;
    JTextField price_text;
    public MyBooksInformationPanel(){
        number_text = new JTextField(8);
        bookname_text = new JTextField(8);
        price_text = new JTextField(8);
    }
    public void setNumberText(JTextField number_text){
        this.number_text = number_text;
    }
    public void setBookNameText(JTextField bookname_text){
        this.bookname_text = bookname_text;
    }
    public void setProceText(JTextField price_text){
        this.price_text = price_text;
    }
    
    
}
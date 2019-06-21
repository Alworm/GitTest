/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
/**
 *
 * @author lenovo
 */
public class ReadingBooksGui extends JFrame implements ActionListener{
    
    Container con;
    JScrollPane scroll;
    JTextArea text;
    JMenuBar bar;
    JMenuItem item1,item2,item3;
    JMenu menu1;
    public ReadingBooksGui(){
        
    }
    public ReadingBooksGui(String bookname){
        super("图书试读");
        bookname = bookname.trim();
        bookname=bookname+".txt";
        con =getContentPane();
        bar = new JMenuBar();
        menu1 = new JMenu("背景设置");
        item1 = new JMenuItem("护眼模式");
        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setBackground(Color.green);
            }
        });
        item2 = new JMenuItem("正常模式");
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setBackground(Color.WHITE);
            }
        
        });
        item3 = new JMenuItem("夜间模式");
        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setBackground(Color.gray);
                
            }
        });
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        bar.add(menu1);
        setJMenuBar(bar);
        
        text = new JTextArea();
        text.setLineWrap(true);//设置自动换行
        text.setWrapStyleWord(true);   
        text.setEditable(false);
        text.setFont(new Font("微软雅黑", Font.PLAIN, 18));
//        text.setText(null);
        try{
            BufferedReader bfr = new BufferedReader(new FileReader(new File(bookname)));
            while(bfr.read()!=-1){
                String s =bfr.readLine();
                text.append(s);
            }
            bfr.close();
            /*放到这里，当书籍无法打开时，不会弹出text的界面*/
            scroll = new JScrollPane(text);
            con.add(scroll);
            setVisible(true);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500,800);
            setLocation(location(getSize()));
        }catch(IOException e){
            System.out.println("文件打开错误"+e);
            JOptionPane.showMessageDialog(null, "书籍已经下架", 
                            "警告信息", JOptionPane.WARNING_MESSAGE);
//            setVisible(false);
        }
        
        
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    public void actionPerformed(ActionEvent e){
        
    }
}

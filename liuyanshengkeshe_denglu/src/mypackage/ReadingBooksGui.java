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
    
    public Container con;
    public JScrollPane scroll;
    public JTextArea text;
    public JMenuBar bar;
    public JMenuItem item1,item2,item3;
    public JMenu menu1,menu2,menu3;
    public JMenuItem itemColorFont;
    public JMenuItem itemColorSelection;
    public JMenuItem itemFontStyle;
//    JTextPane text2;
    public ReadingBooksGui(){
        
    }
    public ReadingBooksGui(String bookname){
        super("图书试读");
        
        Font font =new Font("微软雅黑", Font.PLAIN, 18);
        
        bookname = bookname.trim();
        bookname=bookname+".txt";
        con =getContentPane();
        bar = new JMenuBar();
        
        /*背景设置*/
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
        /*字体设置*/
        menu2 = new JMenu("字体设置");
        itemColorFont = new JMenuItem("设置选定字体颜色");
        itemColorFont.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Color newColor = JColorChooser.showDialog(con, "颜色", Color.yellow);
                if(newColor!=null){
                    text.setSelectedTextColor(newColor);
                    
                }
            }
        });
        itemFontStyle = new JMenuItem("设置字体");
        itemFontStyle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MyFontPanel font = new MyFontPanel();
                font.setJTextAreaFont(text);
//                String fontStyleName = font.selectFontName;
//                text.setFont(new Font(fontStyleName, Font.PLAIN, 18));
                
            }
        });
        
        /*段落设置*/
        menu3 = new JMenu("段落设置");
        itemColorSelection  = new JMenuItem("设置选定段落的颜色");
        itemColorSelection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Color newColor = JColorChooser.showDialog(con, "颜色", Color.yellow);
                if(newColor!=null){
                    text.setSelectionColor(newColor);
                    
                }
            }
        });
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        
        menu2.add(itemColorFont);
        menu2.addSeparator();
        menu2.add(itemFontStyle);
        
        menu3.add(itemColorSelection);
        
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        setJMenuBar(bar);
        
        text = new JTextArea();
        text.setLineWrap(true);//设置自动换行
        text.setWrapStyleWord(true);   
        text.setEditable(false);
        text.setFont(font);

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

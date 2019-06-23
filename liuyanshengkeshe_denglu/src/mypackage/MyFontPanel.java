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
public class MyFontPanel extends JFrame implements ItemListener{
    JComboBox box;
    Container con;
    JLabel label;
    JTextArea show;
    JButton buttonConfirm,buttonCancel;
    public String selectFontName;
    public String str;
    JTextArea readingBooksText;
    public MyFontPanel(){
        super("字体设置");
        buttonConfirm = new JButton("确定");
        
        buttonCancel = new JButton("取消");
        buttonCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        
        con =getContentPane();
        con.setLayout(null);
        box = new JComboBox();
        show = new JTextArea("ABCD演示字体");
        show.setFont(new Font("微软雅黑", Font.PLAIN, 30));
//        show.setAlignmentX(CENTER_ALIGNMENT);
//        show.setAlignmentY(CENTER_ALIGNMENT);
        label = new JLabel("选择字体：");
        /*获取本机所有字体*/
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontName[] = ge.getAvailableFontFamilyNames();
        for(int i=0;i<fontName.length;i++){
             box.addItem(fontName[i]);
        }
        
        box.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getItemSelectable() instanceof JComboBox){
                    str =(String)(box.getSelectedItem());
                    show.setFont(new Font(str, Font.PLAIN, 30));
                }
            }
        });
        /*给确定按钮添加事件*/
        buttonConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFontName = str;
//                ReadingBooksGui reading = new ReadingBooksGui();
//                reading.text.setFont(selectFontName, Font.PLAIN, 18));
                readingBooksText.setFont(new Font(selectFontName, Font.PLAIN, 18));
                
            }
        });
        
        
        label.setLocation(30,30);
        box.setLocation(130,30);
        show.setLocation(50,70);
        buttonConfirm.setLocation(50,250);
        buttonCancel.setLocation(180,250);
        
        label.setSize(100,20);
        box.setSize(150,25);
        show.setSize(220,166);
        buttonConfirm.setSize(70,35);
        buttonCancel.setSize(70,35);
        
        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        box.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonConfirm.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonCancel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        
        
        con.add(label);
        con.add(box);
        con.add(show);
        con.add(buttonConfirm);
        con.add(buttonCancel);
        setVisible(true);
        setLocation(location(getSize()));
        setSize(355,361);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public MyFontPanel(String str){
        
    }
    
    public void itemStateChanged(ItemEvent e){
        
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    public void  setJTextAreaFont(JTextArea text){
        this.readingBooksText = text;
        
    }
    
}

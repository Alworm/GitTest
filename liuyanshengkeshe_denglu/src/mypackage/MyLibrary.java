/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;
import mydatastructure.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author lenovo
 */
public class MyLibrary extends JFrame implements ActionListener,MouseListener{
    
    MyPanel_MyBooks imgpanel;
    
    JButton addbutton;
    ImageIcon addimg;
    JButton[] addbookbutton = new JButton[200];
    int i=0;
    /*
    MyBooksButton addbutton;
     */
    Container con;
//    String bookname;
    public MyLibrary(){
        super("我的图书");
        imgpanel = new MyPanel_MyBooks();
//        imgpanel.setLayout(new BoxLayout(imgpanel,BoxLayout.LINE_AXIS));
        imgpanel.setLayout(null);
        con = getContentPane();
        /*设置图片大小和按钮的大小一样*/
        
        addbutton = new JButton();
        addbutton.setSize(80,80);
        addimg = new ImageIcon("addhao.png");
        Image temp = addimg.getImage().getScaledInstance(addbutton.getWidth(), 
                addbutton.getHeight(), addimg.getImage().SCALE_DEFAULT);
        addimg = new ImageIcon(temp);
        addbutton.setIcon(addimg);
        
        /*用类*/
        /*
        addbutton = new MyBooksButton();
        */
        /*去掉按钮的默认背景*/
        
        addbutton.setFocusPainted(false);//去掉聚焦线
        addbutton.setOpaque(false);//设定透明效果
        addbutton.setContentAreaFilled(false);//去掉背景点击效果
        addbutton.setBorder(null);//去掉边框
        addbutton.setLocation(40,120);
        
        
        addbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BooksListGui booklist = new BooksListGui();
            }
        });
        
        imgpanel.add(addbutton);
        con.add(imgpanel);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(535,770);
        setLocation(location(getSize()));
    }
    public MyLibrary(String str){
        
    }
    public void actionPerformed(ActionEvent e){
        
    }
    public void addNewBooks(final String bookname){
//        this.bookname = bookname;
        System.out.println("addNewBooks"+bookname);
        addbookbutton[i] = new JButton(bookname);
        addbookbutton[i].addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e){
        
            }
            public void mouseClicked(MouseEvent e){//双击事件
                int clickTimes = e.getClickCount();
                if (clickTimes == 2){
                    ReadingBooksGui readBooks = new ReadingBooksGui(bookname);
                    System.out.println("双击事件");
                    System.out.println("打开文件");
                }
        
            }
            public void mouseReleased(MouseEvent e){
        
            }
            public void mouseEntered(MouseEvent e){
        
            }
            public void mouseExited(MouseEvent e){
        
            }
        });
        addbookbutton[i].setSize(80,80);
        StoreAddLibraryBooks storeadd = new StoreAddLibraryBooks();
        storeadd.storeToLibraryBooks(bookname);
        /*
        ImageIcon newaddimg = new ImageIcon("addhao.png");
        Image temp = newaddimg.getImage().getScaledInstance(addbookbutton[i].getWidth(), 
                addbookbutton[i].getHeight(), newaddimg.getImage().SCALE_DEFAULT);
        newaddimg = new ImageIcon(temp);
        addbookbutton[i].setIcon(newaddimg);
        */
        imgpanel.add(addbookbutton[i]);
        /*
        addbookbutton[i].setFocusPainted(false);//去掉聚焦线
        addbookbutton[i].setOpaque(false);//设定透明效果
        addbookbutton[i].setContentAreaFilled(false);//去掉背景点击效果
        addbookbutton[i].setBorder(null);//去掉边框
        */
        if(i==0){
            addbookbutton[i].setLocation(180,120);
        }
        if(i==1){
            addbookbutton[i].setLocation(300,120);
        }
        if(i==2){
            addbookbutton[i].setLocation(420,120);
        }
        if(i==3){
            addbookbutton[i].setLocation(40,240);
        }
        if(i==4){
            addbookbutton[i].setLocation(180,240);
        }
        if(i==5){
            addbookbutton[i].setLocation(300,240);
        }
        if(i==6){
            addbookbutton[i].setLocation(420,240);
        }
        if(i==7){
            addbookbutton[i].setLocation(40,380);
        }
        if(i==8){
            addbookbutton[i].setLocation(180,380);
        }
        if(i==9){
            addbookbutton[i].setLocation(300,380);
        }
        if(i==10){
            addbookbutton[i].setLocation(420,380);
        }
        addbookbutton[i].setText(bookname);
        addbookbutton[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
        /*打印出添加到书架上的书籍*/
        for(int j=0;j<=i;j++){
            System.out.print("storeto:"+storeadd.toString(j));
        }
        System.out.println();
        
        i++;
    }
    public Point location(Dimension size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - size.width) / 2;
        int y = (screenSize.height - size.height) / 2;
        return new Point(x, y);
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseClicked(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    
}

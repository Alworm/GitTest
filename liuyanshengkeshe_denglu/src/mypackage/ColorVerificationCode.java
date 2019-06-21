package mypackage;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class ColorVerificationCode extends JLabel {
    private static final long serialVersionUID = -963570191302793615L;
    private static String text;// 用于保存生成验证图片的字符串,便于验证是否正确，
                                //使所有对象共用一个 
    private Color[] colors = {      Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                                    Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, 
                                    Color.MAGENTA, Color.ORANGE,Color.PINK, Color.RED,
                                    Color.pink, Color.YELLOW };// 定义画笔颜色数组
    public ColorVerificationCode(){
        
    }
    public ColorVerificationCode(String text) {
        this.text = text;
        setPreferredSize(new Dimension(60, 36));// 设置标签的大小
    }
    public String getVerificationCode(){
        return this.text;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 16));// 设置字体
        for (int i = 0; i < text.length(); i++) {
            Random random = new Random();
            int t = random.nextInt(13);
            g.setColor(colors[t]);
            g.drawString("" + text.charAt(i), 5 + i * 13, 25);// 绘制字符串
        }
//        System.out.println(text);
    }
}


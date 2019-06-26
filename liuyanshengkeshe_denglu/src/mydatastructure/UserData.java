/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatastructure;
import java.util.*;
import java.sql.*;
/**
 *
 * @author lenovo
 */
public class UserData {
    private String selectUserInformation = "select username,userpassword,useremail from users";
    public static Map<String,String> nandp = new HashMap<String,String>();//为了让所有的对象都能够访问
    public static Map<String,String> nande = new HashMap<String,String>();//方便检查正确性
    public UserData(){
        
    }
    public void upDateMap(){
        
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
        String userName = "sa";
        String userPwd = "123456789";
        Statement stmt = null;
        ResultSet rs = null;
        // 加载与SQLserver数据库连接的驱动
        try {
           Class.forName(driverName);
           System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            // 与数据库连接
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectUserInformation);
            while(rs.next()) {
                String dataBaseUserName = rs.getString("username");
                dataBaseUserName = dataBaseUserName.trim();
                String dataBaseUserPassword = rs.getString("userpassword");
                dataBaseUserPassword = dataBaseUserPassword.trim();
                nandp.put(dataBaseUserName,dataBaseUserPassword);
                
                String dataBaseUserEmail = rs.getString("useremail");
                dataBaseUserEmail = dataBaseUserEmail.trim();
                nande.put(dataBaseUserName,dataBaseUserEmail);
           }
            
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        printNameAndPassword();
    }
    public void pushUserAndPassword(String username,String password){
        nandp.put(username, password);
    }
    public void alterDataBasePassword(String name,String password){
        String updatepasswordstr = "update users "
                + "set userpassword ='"+password+"' where username='"+name+"'";
        
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
        String userName = "sa";
        String userPwd = "123456789";
        // 加载与SQLserver数据库连接的驱动
        try {
           Class.forName(driverName);
           System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            // 与数据库连接
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");
            try{
                PreparedStatement stmt = conn.prepareStatement(updatepasswordstr);
                stmt.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        
        
        
        
        
    }
    public void pushData(String username,String password,String email){
        nandp.put(username,password);
        nande.put(username,email);
    }
    public void pushDataToDataBase(String username,String password,String email){
        String str = "insert into users values('"+username+"','"+password+"','"+email+"')";
        System.out.println(str);
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
        String userName = "sa";
        String userPwd = "123456789";
        // 加载与SQLserver数据库连接的驱动
        try {
           Class.forName(driverName);
           System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            // 与数据库连接
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");
            try{
                PreparedStatement stmt = conn.prepareStatement(str);
                stmt.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        } catch (Exception e) {
                e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        
    }
    public boolean checkPassword(String username,String password){
        boolean f = false;
        if(nandp.containsKey(username)){//如果map中包含这个，并且对应相等
            String password2 = nandp.get(username);
            if(password2.equals(password)){//比较不要比较对象
                f = true;
            }
        }
        return f;
    }
    
    public boolean checkEmail(String username,String email){
        boolean f = false;
        if(nande.containsKey(username)){
            String email2 = nande.get(username);
            if(email2.equals(email)){
                f = true;
            }
        }
        return f;
    }
    public void removeKeyAndValue(String key){
//        System.out.println(nandp.remove(key));
        nandp.remove(key);
    }
    public void printNameAndPassword(){
        Iterator iter = nandp.entrySet().iterator();
	while (iter.hasNext()) {
		Map.Entry entry = (Map.Entry) iter.next();
		Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + ":" + value);
        }
    }
    public void printNameAndEmail(){
        Iterator iter = nande.entrySet().iterator();
	while (iter.hasNext()) {
		Map.Entry entry = (Map.Entry) iter.next();
		Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + ":" + value);
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatastructure;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class UserData {
    public static Map<String,String> nandp = new HashMap<String,String>();//为了让所有的对象都能够访问
    public static Map<String,String> nande = new HashMap<String,String>();//方便检查正确性
    public UserData(){
        
    }
    public void pushUserAndPassword(String username,String password){
        nandp.put(username, password);
        
    }
    public void pushData(String username,String password,String email){
        nandp.put(username,password);
        nande.put(username,email);
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

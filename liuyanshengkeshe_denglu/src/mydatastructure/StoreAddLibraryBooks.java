/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatastructure;

/**
 *
 * @author lenovo
 */
public class StoreAddLibraryBooks {
    public static String[] tolibrary = new String[200];
    public static int i=0;
    
    public StoreAddLibraryBooks(){
        
    }
    
    public static void storeToLibraryBooks(String name){
        tolibrary[i]=name;
        i++;
    }
    public String toString(int j){
        return tolibrary[j];
    }
    
    
    
    
    
}

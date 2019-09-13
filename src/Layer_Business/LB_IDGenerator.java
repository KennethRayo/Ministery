/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

/**
 *
 * @author KGR
 */
public class LB_IDGenerator {

    public LB_IDGenerator() { }
    
    
    public String getID(String key, int count)
    {
        String  mensaje = key;
         char array[] = mensaje.toCharArray();
         for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] + (char)5);//cambia aumentando 5 posiciones de caracter ASSCI
         }
         
         String encripted = String.valueOf(array);
         
         //desencriptar
         char arrayd[] = encripted.toCharArray();
         for (int i = 0; i < arrayd.length; i++) {
            arrayd[i] = (char)(arrayd[i] - (char)5);//cambia aumentando 5 posiciones de caracter ASSCI
         }
         
         String planetext = String.valueOf(arrayd);
         
         return encripted;
    }
    
    public String getIDs(String str, int val)
    {
        String numbers = "0123456789";
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String min = "abcdefghijklmnopqrstuvwxyz";
        String ESPECIALES = "ñÑ";
        String name = str;
        
        int length = val;
        
        String ID =  getPassword(getPinNumber(numbers), name, mayus, min, length);
         
         return ID;
    }
    
    public static String getPinNumber(String numbers) {
	return getPassword3(numbers, 4);//get numbers
    }
 
    public static String getPassword(String numbers, String name, String mayus, String min, int length) {
	return getPassword2(numbers, name, mayus, min, length);//get ID 
    }
 
    public static String getPassword2(String numbers, String name, String mayus, String min, int length) {
	return getPassword3(numbers + name + mayus + min, length);
    }
    
    public static String getPassword3(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
                pswd+=(key.charAt((int)(Math.random() * key.length())));
        }

        return pswd;
    }

    
}
import java.util.Arrays;
import java.util.Collections;

public class FindUniqueString {

 public boolean isUniqueString(String s){
     if(s== null || s.trim().length() == 0){
         //log or throw exception
         return false;
     }
     char[] charArray = s.toCharArray();
     Arrays.sort(charArray);

     char prev = Character.MIN_VALUE;
     for(char c : charArray){
         if (c == prev){
             return false;
         }else{
             prev = c;
         }
     }

     return true;
 }


 public static void main (String args[]){
     boolean status = new FindUniqueString().isUniqueString("ABCDERB");
     System.out.println(status);
 }
}

import java.util.*;
public class SuppressWarningClass {
   public static void main(String[]args){
       @SuppressWarnings("unchecked")
       ArrayList list=new ArrayList();
       list.add("Harshit");
       list.add("A");
       list.add("B");
       for(Object l:list){
           System.out.println((String)l);
       }

   }
}

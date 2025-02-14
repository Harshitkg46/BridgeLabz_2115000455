import java.util.*;
public class SortStudentAges {
   public static void countingSort(int[] ages, int maxAge) {
       int[] count = new int[maxAge + 1];
       for (int age : ages) count[age]++;
       int index = 0;
       for (int i = 0; i <= maxAge; i++) {
           while (count[i]-- > 0) ages[index++] = i;
       }
   }
   public static void main(String[] args) {
       int[] ages = {12, 15, 10, 14, 18, 13, 12, 16, 11};
       countingSort(ages, 18);
       System.out.println(Arrays.toString(ages));
   }
}

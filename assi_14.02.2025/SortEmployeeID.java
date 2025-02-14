import java.util.*;
public class SortEmployeeId {
   public static void insertionSort(int[] empIds) {
       int n = empIds.length;
       for (int i = 1; i < n; i++) {
           int key = empIds[i];
           int j = i - 1;
           while (j >= 0 && empIds[j] > key) {
               empIds[j + 1] = empIds[j];
               j--;
           }
           empIds[j + 1] = key;
       }
   }
   public static void main(String[] args) {
       int[] empIds = {103, 101, 105, 102, 104};
       insertionSort(empIds);
       System.out.println(Arrays.toString(empIds));
   }
}

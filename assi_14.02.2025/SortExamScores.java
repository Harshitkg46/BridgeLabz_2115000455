import java.util.*;
public class SortExamScores {
   public static void selectionSort(int[] scores) {
       int n = scores.length;
       for (int i = 0; i < n - 1; i++) {
           int minIdx = i;
           for (int j = i + 1; j < n; j++) {
               if (scores[j] < scores[minIdx]) {
                   minIdx = j;
               }
           }
           int temp = scores[i];
           scores[i] = scores[minIdx];
           scores[minIdx] = temp;
       }
   }
   public static void main(String[] args) {
       int[] scores = {88, 75, 92, 85, 78};
       selectionSort(scores);
       System.out.println(Arrays.toString(scores));
   }
}

import java.util.*;
public class SortProductPrices {
   public static void quickSort(int[] prices, int low, int high) {
       if (low < high) {
           int pi = partition(prices, low, high);
           quickSort(prices, low, pi - 1);
           quickSort(prices, pi + 1, high);
       }
   }
   private static int partition(int[] prices, int low, int high) {
       int pivot = prices[high], i = low - 1;
       for (int j = low; j < high; j++) {
           if (prices[j] < pivot) {
               int temp = prices[++i];
               prices[i] = prices[j];
               prices[j] = temp;
           }
       }
       int temp = prices[++i];
       prices[i] = prices[high];
       prices[high] = temp;
       return i;
   }
   public static void main(String[] args) {
       int[] prices = {400, 200, 300, 100, 500};
       quickSort(prices, 0, prices.length - 1);
       System.out.println(Arrays.toString(prices));
   }
}

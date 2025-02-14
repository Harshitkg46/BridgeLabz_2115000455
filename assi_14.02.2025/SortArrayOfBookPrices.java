import java.util.*;
public class SortArrayOfBookPrices {
	public static void main(String[] args) {
       int[] prices = {300, 150, 450, 200, 100};
       mergeSort(prices, 0, prices.length - 1);
       System.out.println(Arrays.toString(prices));
   }
	
   public static void mergeSort(int[] prices, int left, int right) {
       if (left < right) {
           int mid = left + (right - left) / 2;
           mergeSort(prices, left, mid);
           mergeSort(prices, mid + 1, right);
           merge(prices, left, mid, right);
       }
   }
   private static void merge(int[] prices, int left, int mid, int right) {
       int n1 = mid - left + 1, n2 = right - mid;
       int[] L = new int[n1], R = new int[n2];
       for (int i = 0; i < n1; i++) L[i] = prices[left + i];
       for (int i = 0; i < n2; i++) R[i] = prices[mid + 1 + i];
       int i = 0, j = 0, k = left;
       while (i < n1 && j < n2) prices[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
       while (i < n1) prices[k++] = L[i++];
       while (j < n2) prices[k++] = R[j++];
   }
}

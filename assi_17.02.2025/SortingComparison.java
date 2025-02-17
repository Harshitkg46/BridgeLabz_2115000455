import java.util.*;
public class SortingComparison {
	
	public static void main(String[] args) {
       int[] arr = {10, 3, 2, 8, 6, 7};
       mergeSort(arr);
       System.out.println("Sorted Array: " + Arrays.toString(arr));
   }
	
   public static void bubbleSort(int[] arr) {
       int n = arr.length;
       for (int i = 0; i < n - 1; i++) {
           for (int j = 0; j < n - i - 1; j++) {
               if (arr[j] > arr[j + 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
       }
   }
   private static void mergeSort(int[] arr) {
       Arrays.sort(arr);
   }
   public static void quickSort(int[] arr, int low, int high) {
       if (low < high) {
           int pi = partition(arr, low, high);
           quickSort(arr, low, pi - 1);
           quickSort(arr, pi + 1, high);
       }
   }
   private static int partition(int[] arr, int low, int high) {
       int pivot = arr[high], i = low - 1;
       for (int j = low; j < high; j++) {
           if (arr[j] <= pivot) {
               i++;
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }
       int temp = arr[i + 1];
       arr[i + 1] = arr[high];
       arr[high] = temp;
       return i + 1;
   }
}

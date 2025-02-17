import java.util.*;
public class SearchComparison {
	public static void main(String[] args) {
       int[] dataset = {5, 2, 8, 10, 3, 7};
       int target = 8;
       System.out.println("Linear Search Index: " + linearSearch(dataset, target));
       System.out.println("Binary Search Index: " + binarySearch(dataset, target));
   }
	
   public static int linearSearch(int[] arr, int target) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == target) return i;
       }
       return -1;
   }
   public static int binarySearch(int[] arr, int target) {
       Arrays.sort(arr);
       int left = 0, right = arr.length - 1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] == target) return mid;
           else if (arr[mid] < target) left = mid + 1;
           else right = mid - 1;
       }
       return -1;
   }
}

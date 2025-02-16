import java.util.*;
public class BothSearches {
	
     public static void main(String[] args) {
       int[] nums = {3, 4, -1, 1};
       System.out.println(linearSearchHelper(nums));
       int[] arr = {5, 3, 7, 9, 1, 2};
       int target = 7;
       System.out.println("Index: "+ binarySearchHelper(arr, target));
   }
  
   public static int linearSearchHelper(int[] nums) {
       int n = nums.length;
       for (int i = 0; i < n; i++) {
           while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
               int temp = nums[i];
               nums[i] = nums[temp - 1];
               nums[temp - 1] = temp;
           }
       }
       for (int i = 0; i < n; i++) {
           if (nums[i] != i + 1) return i + 1;
       }
       return n + 1;
   }
   public static int binarySearchHelper(int[] arr, int target) {
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

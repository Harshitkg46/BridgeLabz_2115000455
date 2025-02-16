public class FindFirstAndLastOccurence {
    public static void main(String[] args) {
       int[] arr = {2, 4, 10, 10, 10, 18, 20};
       int target = 10;
       System.out.println("First occurrence: " + helperFirst(arr, target));
       System.out.println("Last occurrence: " + helperLast(arr, target));
   }
	
   private static int helperFirst(int[] arr, int target) {
       int left = 0, right = arr.length - 1, result = -1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] >= target) {
               if (arr[mid] == target) result = mid;
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
       return result;
   }
   private static int helperLast(int[] arr, int target) {
       int left = 0, right = arr.length - 1, result = -1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] <= target) {
               if (arr[mid] == target) result = mid;
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       return result;
   }
}

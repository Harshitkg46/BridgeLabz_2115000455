public class SearchForFirstNegative {
	public static void main(String[] args) {
       int[] arr = {3, 5, 7, -2, 4, -6};
       System.out.println("Index of first negative number: " + helper(arr));
   }
   public static int helper(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] < 0) {
               return i;
           }
       }
       return -1;
   }
}

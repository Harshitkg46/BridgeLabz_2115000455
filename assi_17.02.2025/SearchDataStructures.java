import java.util.*;
public class SearchDataStructures {
   public static void main(String[] args) {
       int[] arr = {10, 3, 5, 7, 2, 8};
       HashSet<Integer> hashSet = new HashSet<>();
       TreeSet<Integer> treeSet = new TreeSet<>();
       for (int num : arr) {
           hashSet.add(num);
           treeSet.add(num);
       }
       int target = 5;
       long start, end;
       start = System.nanoTime();
       boolean foundArray = Arrays.stream(arr).anyMatch(num -> num == target);
       end = System.nanoTime();
       System.out.println("Array Search Time: " + (end - start) / 1e6 + " ms");
       start = System.nanoTime();
       boolean foundHashSet = hashSet.contains(target);
       end = System.nanoTime();
       System.out.println("HashSet Search Time: " + (end - start) / 1e6 + " ms");
       start = System.nanoTime();
       boolean foundTreeSet = treeSet.contains(target);
       end = System.nanoTime();
       System.out.println("TreeSet Search Time: " + (end - start) / 1e6 + " ms");
   }
}

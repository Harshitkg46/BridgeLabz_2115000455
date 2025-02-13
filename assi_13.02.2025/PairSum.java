import java.util.HashSet;
public class PairSum {
    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {13, 15, 5, 7};
        int target = 20;
        System.out.println(hasPair(arr, target));
    }
}

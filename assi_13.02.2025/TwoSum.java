import java.util.*;
public class TwoSum{
    public static int[] find(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (mpp.containsKey(c)) {
                return new int[]{mpp.get(c), i};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {3, 7, 11, 15};
        int target = 10;
        int[] result = find(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}

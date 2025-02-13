import java.util.*;
public class ZeroSum{
    public static List<int[]> findZeroSum(int[] arr) {
        List<int[]> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    ans.add(new int[]{start + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return ans;
    }

    public static void print(List<int[]> subarrays, int[] arr) {
        for (int[] subarray : subarrays) {
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, -3, 1, 6, -1, -2, 3};
        List<int[]> subarrays = findZeroSum(arr);
        print(subarrays, arr);
    }
}

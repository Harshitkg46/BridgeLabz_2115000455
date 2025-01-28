import java.util.Scanner;
public class l2q8 {
    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) minAge = ages[i];
        }
        return "Youngest is: " + minAge + " years old";
    }

    public static String findTallest(int[] heights) {
        int maxHeight = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) maxHeight = heights[i];
        }
        return "Tallest is: " + maxHeight + " cm";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of friend " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }
        System.out.println(findYoungest(ages));
        System.out.println(findTallest(heights));
    }
}

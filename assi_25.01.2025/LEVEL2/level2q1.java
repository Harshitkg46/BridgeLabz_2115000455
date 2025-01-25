import java.util.Scanner;

public class level2q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            salaries[i] = sc.nextDouble();
            years[i] = sc.nextDouble();
        }

        for (int i = 0; i < 10; i++) {
            bonuses[i] = (years[i] > 5 ? 0.05 : 0.02) * salaries[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += salaries[i] + bonuses[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}

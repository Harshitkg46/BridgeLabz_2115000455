import java.util.Random;
public class l3q11 {
    public static double[][] generateSalariesAndService(int employees) {
        double[][] data = new double[employees][2];
        Random random = new Random();
        for (int i = 0; i < employees; i++) {
            data[i][0] = 10000 + random.nextInt(90000);
            data[i][1] = 1 + random.nextInt(10);
        }
        return data;
    }

    public static double[][] calculateNewSalaries(double[][] data) {
        double[][] updatedData = new double[data.length][3];
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            updatedData[i][0] = salary;
            updatedData[i][1] = years;
            updatedData[i][2] = salary + bonus;
        }
        return updatedData;
    }

    public static void displaySalaries(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "Emp ID", "Old Salary", "Years of Service", "Bonus", "New Salary");
        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            double years = oldData[i][1];
            double newSalary = newData[i][2];
            double bonus = newSalary - oldSalary;
            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f %-15.2f%n", i + 1, oldSalary, years, bonus, newSalary);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-15s %-15.2f %-15.2f%n", "Total", totalOldSalary, "", totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateSalariesAndService(10);
        double[][] updatedData = calculateNewSalaries(employeeData);
        displaySalaries(employeeData, updatedData);
    }
}

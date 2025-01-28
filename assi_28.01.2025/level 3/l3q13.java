import java.util.Random;
import java.util.Scanner;
public class l3q13{
    public static int[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = random.nextInt(10);
        return matrix;
    }

    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                sum[i][j] = a[i][j] + b[i][j];
        return sum;
    }

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] diff = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                diff[i][j] = a[i][j] - b[i][j];
        return diff;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        int[][] product = new int[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    product[i][j] += a[i][k] * b[k][j];
        return product;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
               matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
               matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null;
        return new double[][]{
            {matrix[1][1] / (double) det, -matrix[0][1] / (double) det},
            {-matrix[1][0] / (double) det, matrix[0][0] / (double) det}
        };
    }

    public static int[][] adjoint3x3(int[][] matrix) {
        int[][] adj = new int[3][3];
        adj[0][0] = determinant2x2(new int[][]{{matrix[1][1], matrix[1][2]}, {matrix[2][1], matrix[2][2]}});
        adj[0][1] = -determinant2x2(new int[][]{{matrix[1][0], matrix[1][2]}, {matrix[2][0], matrix[2][2]}});
        adj[0][2] = determinant2x2(new int[][]{{matrix[1][0], matrix[1][1]}, {matrix[2][0], matrix[2][1]}});
        adj[1][0] = -determinant2x2(new int[][]{{matrix[0][1], matrix[0][2]}, {matrix[2][1], matrix[2][2]}});
        adj[1][1] = determinant2x2(new int[][]{{matrix[0][0], matrix[0][2]}, {matrix[2][0], matrix[2][2]}});
        adj[1][2] = -determinant2x2(new int[][]{{matrix[0][0], matrix[0][1]}, {matrix[2][0], matrix[2][1]}});
        adj[2][0] = determinant2x2(new int[][]{{matrix[0][1], matrix[0][2]}, {matrix[1][1], matrix[1][2]}});
        adj[2][1] = -determinant2x2(new int[][]{{matrix[0][0], matrix[0][2]}, {matrix[1][0], matrix[1][2]}});
        adj[2][2] = determinant2x2(new int[][]{{matrix[0][0], matrix[0][1]}, {matrix[1][0], matrix[1][1]}});
        return transposeMatrix(adj);
    }

    public static double[][] inverse3x3(int[][] matrix) {
        int det = determinant3x3(matrix);
        if (det == 0) return null;
        int[][] adj = adjoint3x3(matrix);
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inverse[i][j] = adj[i][j] / (double) det;
        return inverse;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Inverse does not exist.");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size (2 or 3): ");
        int size = scanner.nextInt();
        int[][] matrixA = generateMatrix(size, size);
        int[][] matrixB = generateMatrix(size, size);

        System.out.println("\nMatrix A:");
        displayMatrix(matrixA);
        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);

        System.out.println("\nAddition:");
        displayMatrix(addMatrices(matrixA, matrixB));

        System.out.println("\nSubtraction:");
        displayMatrix(subtractMatrices(matrixA, matrixB));

        System.out.println("\nMultiplication:");
        displayMatrix(multiplyMatrices(matrixA, matrixB));

        System.out.println("\nTranspose of Matrix A:");
        displayMatrix(transposeMatrix(matrixA));

        if (size == 2) {
            System.out.println("\nDeterminant of Matrix A: " + determinant2x2(matrixA));
            System.out.println("\nInverse of Matrix A:");
            displayMatrix(inverse2x2(matrixA));
        } else if (size == 3) {
            System.out.println("\nDeterminant of Matrix A: " + determinant3x3(matrixA));
            System.out.println("\nInverse of Matrix A:");
            displayMatrix(inverse3x3(matrixA));
        }

        scanner.close();
    }
}

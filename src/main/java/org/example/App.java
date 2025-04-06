package org.example;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        int[][] A = readMatrixFromFile("A.txt");
        int[][] B = readMatrixFromFile("B.txt");

        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;

        if (aCols != bRows) {
            System.out.println("Невозможно умножить: число столбцов A != числу строк B");
            return;
        }

        int[][] result = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++) {
                    result[i][j] = (result[i][j] + ((A[i][k] * B[k][j]) % 2)) % 2;
                }
            }
        }

        System.out.println("Результат умножения матриц:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrixFromFile(String filename) throws IOException {
        Scanner sc = new Scanner(new File(filename));
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        sc.close();
        return matrix;
    }
}

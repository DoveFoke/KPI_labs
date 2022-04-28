//С5: 1428 % 5 = 3 - действие - "Прямая сумма";
//C7: 1428 % 7 = 0 - тип елементов матрицы "double";
//C11: 1428 % 11 = 9 - Найти среднее значение каждого столбика матрицы.

package com.kpi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Переменные
        Scanner scan = new Scanner(System.in);
        int n, m, l, k, a, b, count = 1;
        double sum;
        String A_biggest_number, B_biggest_number, C_biggest_number, A_temp, B_temp, A_filling, B_filling, C_filling;
        System.out.print("Определите размер матрицы А.\nВведите кол-во строк: ");
        try {
            m = scan.nextInt();
            System.out.print("Введите кол-во столбцов: ");
            n = scan.nextInt();
            System.out.print("Определите размер матрицы В.\nВведите кол-во строк: ");
            k = scan.nextInt();
            System.out.print("Введите кол-во столбцов: ");
            l = scan.nextInt();
        } catch (InputMismatchException exc) {
            System.out.println("Количество столбцов или строк должно быть целым числом!");
            return;
        }
        A_biggest_number = "0";
        B_biggest_number = "0";
        a = m + k;
        b = n + l;
        double[][] A = new double[m][n];
        double[][] B = new double[k][l];
        double[][] C = new double[a][b];
        //Заполнение матрицы А
        System.out.println("Заполните поэлементно матрицу А:\n");
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scan.nextDouble();
                    A_temp = Double.toString(A[i][j]);
                    if (A_temp.length() >= A_biggest_number.length()) {
                        A_biggest_number = A_temp;
                    }
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Проверьте введённые данные!");
            return;
        }
        //Заполнение матрицы В
        System.out.println("Заполните поэлементно матрицу В:\n");
        try {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < l; j++) {
                    B[i][j] = scan.nextDouble();
                    B_temp = Double.toString(B[i][j]);
                    if (B_temp.length() >= B_biggest_number.length()) {
                        B_biggest_number = B_temp;
                    }
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Проверьте введённые данные!");
            return;
        }
        //Вывод матрицы А
        A_filling = "%" + A_biggest_number.length() + "s";
        System.out.println("Матрица А:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf(A_filling, A[i][j]);
                    System.out.print(" ");
                } else if (n - j == 1) {
                    System.out.printf(A_filling, A[i][j]);
                    System.out.println(" |");
                } else {
                    System.out.printf(A_filling, A[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Вывод матрицы B
        B_filling = "%" + B_biggest_number.length() + "s";
        System.out.println("Матрица B:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf(B_filling, B[i][j]);
                    System.out.print(" ");
                } else if (l - j == 1) {
                    System.out.printf(B_filling, B[i][j]);
                    System.out.println(" |");
                } else {
                    System.out.printf(B_filling, B[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Выполнение операции "Прямая сумма"
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j < n && i < m) {
                    C[i][j] = A[i][j];
                } else if (j >= n && i >= m) {
                    C[i][j] = B[i - m][j - n];
                }
            }
        }
        //Вывод матрицы C
        if (B_biggest_number.length() >= A_biggest_number.length()) {
            C_biggest_number = B_biggest_number;
        } else {
            C_biggest_number = A_biggest_number;
        }
        C_filling = "%" + C_biggest_number.length() + "s";
        System.out.println("Матрица C:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf(C_filling, C[i][j]);
                    System.out.print(" ");
                } else if (b - j == 1) {
                    System.out.printf(C_filling, C[i][j]);
                    System.out.print(" |\n");
                } else {
                    System.out.printf(C_filling, C[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Среднее значение каждого столбика
        for (int j = 0; j < b; j++) {
            sum = 0;
            for (int i = 0; i < a; i++) {
                sum += C[i][j];
            }
            System.out.println("Среднее значение " + count + "-го столбика = " + (sum / a));
            count += 1;
        }
    }
}

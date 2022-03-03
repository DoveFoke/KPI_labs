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
        double avg, avg_temp;
        String A_ij_length, B_ij_length;
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
            System.out.println("Количество столбцов или строк не может быть дробным числом!");
            return;
        }
        a = m + k;
        b = n + l;
        double[][] A = new double[m][n];
        double[][] B = new double[k][l];
        double[][] C = new double[a][b];
        //Заполнение матрицы А
        System.out.println("Не вводите число, сумма символов которого > 7!\nУчтите, что при введении целого числа, нв выводе всё равно получим число типа double с запятой и нулем после введенного числа.\nТо есть при введении целого числа, в нем может быть максимум 5 символов!");
        System.out.println("Заполните поэлементно матрицу А:\n");
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scan.nextDouble();
                    A_ij_length = Double.toString(A[i][j]);
                    if (A_ij_length.length() > 7) {
                        System.out.println("Введите число, сумма символов которого <= 7!");
                        return;
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
                for (int j = 0; j < l; j++){
                    B[i][j] = scan.nextDouble();
                    B_ij_length = Double.toString(B[i][j]);
                    if (B_ij_length.length() > 7) {
                        System.out.println("Введите число, сумма символов которого <= 7!");
                        return;
                    }
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Проверьте введённые данные!");
            return;
        }
        //Вывод матрицы А
        System.out.println("Матрица А:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf("%7s", A[i][j]);
                    System.out.print(" ");
                }
                else if (n - j == 1){
                    System.out.printf("%7s", A[i][j]);
                    System.out.println(" |");
                }
                else {
                    System.out.printf("%7s", A[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Вывод матрицы B
        System.out.println("Матрица B:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++){
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf("%7s", B[i][j]);
                    System.out.print(" ");
                }
                else if (l - j == 1){
                    System.out.printf("%7s", B[i][j]);
                    System.out.println(" |");
                }
                else {
                    System.out.printf("%7s", B[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Выполнение операции "Прямая сумма"
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++) {
                if (j < n && i < m){
                    C[i][j] = A[i][j];
                }
                else if (j >= n && i >= m) {
                    C[i][j] = B[i - m][j - n];
                }
                else{
                    C[i][j] = 0;
                }
            }
        }
        //Вывод матрицы C
        System.out.println("Матрица C:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++){
                if (j == 0) {
                    System.out.print("| ");
                    System.out.printf("%7s", C[i][j]);
                    System.out.print(" ");
                }
                else if (b - j == 1){
                    System.out.printf("%7s", C[i][j]);
                    System.out.print(" |\n");
                }
                else {
                    System.out.printf("%7s", C[i][j]);
                    System.out.print(" ");
                }
            }
        }
        //Среднее значение каждого столбика
        for (int j = 0; j < b; j++){
            avg_temp = 0;
            for (int i = 0; i < a; i++){
                avg_temp += C[i][j];
            }
            avg = avg_temp / a;
            System.out.println("Среднее значение "+count+"-го столбика = "+avg);
            count += 1;
        }
    }
}

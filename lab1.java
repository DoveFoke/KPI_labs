//  № зачётки - 1428
//  С2 = 0, операция О1 - "+"
//  С3 = 0, константа = 0
//  С5 = 3, операция О2 - "+"
//  С7 = 0, тип индексов i и j - byte
package com.kpi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        int m;
        int numerator;
        double denominator;
        byte a, b;
        double constanta = 1428 % 3, res = 0;
        try {
            System.out.print("Введите значение n: ");
            n = scan.nextInt();
            System.out.print("Введите значение m: ");
            m = scan.nextInt();
            System.out.print("Введите значение a: ");
            a = scan.nextByte();
            System.out.print("Введите значение b: ");
            b = scan.nextByte();
        } catch (InputMismatchException exc){
            System.out.println("Введённые данные должны соответствовать типу, обозначенному в задании!");
            return;
        }
        if (a > n || b > m) {
            System.out.println("Вводимые данные a и b не могут быть больше n и m соответственно.");
            return;
        }
        if (a <= 0 || b <= 0) {
            System.out.println("Порядковый номер суммы ряда(a и b) не может быть меньше или равным 0!");
            return;
        }
        for (byte i = a;i<=n;i++) {
            for (byte j = b; j <= m; j++) {
                denominator = i + constanta;
                if (denominator == 0){
                    System.out.println("Знаменатель не может быть равен 0, так как на 0 делить нельзя.");
                    break;
                } else {
                    numerator = i + j;
                    res += numerator / denominator;
                }
            }
        }
        System.out.println("Результат вычислений: S = "+res);
    }
}
package fibonachi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cash {
    //Мы добавляем функцию fib(n) в отдельный класс и выделяем
    //кеш структуру данных под хранение
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {// вывел метод, что бы запустить и проверить кэш
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();

                int c = (fib(a));
                try (PrintWriter out = new PrintWriter("D:/Fib.txt")) {
                    out.println(c);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            System.out.println(c);


            }

            }
        }



package fibonachi;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibbonachi {
    //Доп задание: реализовать алгоритм поиска числа Фибоначчи рекурсией
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
//реализация
           while (true) {
               Scanner scanner = new Scanner(System.in);
               int n = scanner.nextInt();

               System.out.print(fib(n));
           }


    }
}





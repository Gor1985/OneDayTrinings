package GameTwoLevel;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// часть честно слизал с интернета, добавил возможность записи в файл, счет очков и запись в файл, вывод победителя
class KrestikNolik {
    public static boolean isWin = false;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int randomPlayer = (int) (Math.random() * 2 + 1);
        if (randomPlayer == 1) {
            System.out.println("Player1 ходит первым!" + '\n');
        } else System.out.println("Player2 ходит первым!" + '\n');
        System.out.println("Введите число от 1 до 9, чтобы сделать Ваш ход: " + '\n');
        char[][] field = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}};

        char crossOrZero;
        int switcher = 0; // переключатель между первым и вторым игроком

        while (true) {
            if (switcher % 2 == 0) {
                crossOrZero = 'x';
                a = a + 1;
                String e = Integer.toString(a);
                try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    String text = "Игрок x получает " + e + " очков\n";
                    writer.write(text);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            } else crossOrZero = 'o';
            b = b + 1;
            String z = Integer.toString(b);
            try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                // запись всей строки
                String text1 = "Игрок o получает " + z + " очков\n";
                writer.write(text1);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }


            printField(field);

            int num;
            try {
                num = Integer.parseInt(reader.readLine()); // запрет ввода символов, отличных от чисел
            } catch (NumberFormatException e) {
                System.out.println("Число, только число!");
                continue;
            }

            if (Arrays.deepToString(field).contains(Integer.toString(num)) && num <= 9 && num > 0) {
                switch (num) {
                    case 1:
                        field[0][0] = crossOrZero;
                        break;
                    case 2:
                        field[0][1] = crossOrZero;
                        break;
                    case 3:
                        field[0][2] = crossOrZero;
                        break;
                    case 4:
                        field[1][0] = crossOrZero;
                        break;
                    case 5:
                        field[1][1] = crossOrZero;
                        break;
                    case 6:
                        field[1][2] = crossOrZero;
                        break;
                    case 7:
                        field[2][0] = crossOrZero;
                        break;
                    case 8:
                        field[2][1] = crossOrZero;
                        break;
                    case 9:
                        field[2][2] = crossOrZero;
                        break;
                }
            } else {
                System.out.println("Введите число из оставшихся на поле!");
                continue;
            }


            checkingForMatch(field);

            draw(field);
            if (isWin) {
                if (draw(field)) {

                    System.out.println("Ничья");

                    try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text3 = "Ничья";
                        writer.write(text3);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;




                } else
                    System.out.println("Победа: " + crossOrZero + "\n" + "сыграем еще?");


                try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    String text2 = "Победил игрок " + crossOrZero + "\n";
                    writer.write(text2);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                printField(field);


            } else
                System.out.println("Пока никто не выиграл. Играем дальше");


            if (a > b) {
                System.out.println("Ведет игрок х");
            } else {
                System.out.println("Ведет игрок o");
            }
            switcher++;
        }
    }


    public static void printField(char[][] field) { // печать поля

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j != 2) {
                    System.out.print(field[i][j] + "|");
                } else System.out.print(field[i][j]);

            }
            System.out.println();


        }
    }




    public static char[][] checkingForMatch(char[][] field) { // проверка на совпадение трёх элементов
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] || // сравнение по горизонтали
                    field[0][i] == field[1][i] && field[0][i] == field[2][i] || // сравнение по вертикали
                    field[0][0] == field[1][1] && field[0][0] == field[2][2] || // сравнение по
                    field[2][0] == field[1][1] && field[2][0] == field[0][2]) { // диагоналям
                isWin = true;
               break;
            }


                    }
        return field;
    }




    public static boolean draw (char[][] field){
        for (int a=0;a< field.length;a++){
            if (a> field.length-1){
                isWin = true;
                break;
            }
        }

        return true;
    }
}
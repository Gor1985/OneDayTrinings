package GameTwoLevel;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// часть честно слизал с интернета, добавил возможность записи в файл, счет очков и запись в файл, вывод победителя
class KrestikNolik {
    public static boolean isWin = false;
    public static int id;
    private static int a = 0;
    private static int b = 0;

    static int c = 0;
    public static void main(String[] args) throws IOException {

        PlayerOne playerOne = new PlayerOne();
        PlayerTwo playerTwo = new PlayerTwo();
        Switch aSwitch = new Switch();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Первый игрок, введите имя ");
            String player1 = reader.readLine();
            playerOne.setName(player1);

            System.out.println("Второй игрок, введите имя ");
            String player2 = reader.readLine();
            playerTwo.setName(player2);

        } catch (StackOverflowError e) {
            e.printStackTrace();
        }


       int randomPlayer = (int) (Math.random() * 2 + 1);
        if (randomPlayer == 1) {
            System.out.println(PlayerOne.getName() + " ходит первым!" + '\n');

        } else {

            System.out.println(PlayerTwo.getName() + " ходит первым!" + '\n');
            System.out.println("Введите число от 1 до 9, чтобы сделать Ваш ход: " + '\n');

        }



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

            } else crossOrZero = 'o';
            b = b + 1;


            printField(field);

            int num;
            try {
                num = Integer.parseInt(reader.readLine()); // запрет ввода символов, отличных от чисел
                c++;
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
            if (c >= 9) {
                System.out.println("Ничья");
                try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    String text3 = "Ничья";
                    writer.write(text3);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.exit(1);
            }

            checkingForMatch(field);
            if (isWin) {

                    System.out.println("Победа: " + crossOrZero);


                try (FileWriter writer = new FileWriter("src/GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    String text2 = "Победил игрок " + crossOrZero + "\n";
                    writer.write(text2);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;


            } else
                System.out.println("Пока никто не выиграл. Играем дальше");


            if (a > b) {
                if (aSwitch.randomPlayer == 1) {
                    System.out.println("Ведет игрок х: " + playerOne.getName() + ", у него " + " " + a + " очков, у игрока " + playerTwo.getName() + b + "очков");

                } else
                    System.out.println("Ведет игрок х: " + playerTwo.getName() + ", у него " + " " + a + " очков ,у игрока " + playerOne.getName() + " " + b + " очков");

            } else {
                if (aSwitch.randomPlayer == 1) {
                    System.out.println("Ведет игрок 0: " + playerOne.getName() + ", у него " + " " + b + " очков, " + " у игрока " + playerTwo.getName() + " " + a + " очков");


                } else
                    System.out.println("Ведет игрок 0: " + playerTwo.getName() + ", у него " + " " + b + " очков , у игрока " + playerOne.getName() + " " + b + " очков");

            }
            switcher++;
        }
    }

        public static void printField ( char[][] field){ // печать поля

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
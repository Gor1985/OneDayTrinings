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
    static int c=0;

    static   boolean Win = false;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Первый игрок, введите имя ");
        String player1= reader.readLine();
        System.out.println("Второй игрок, введите имя ");
        String player2= reader.readLine();
        int randomPlayer = (int) (Math.random() * 2 + 1);
        if (randomPlayer == 1) {
            System.out.println(player1+" ходит первым!" + '\n');
        } else System.out.println(player2+" ходит первым!" + '\n');
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
                try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    if (randomPlayer==1) {
                        String text = "Игрок " + player1 + " получает " + e + " очков\n";
                        writer.write(text);
                        writer.flush();
                    }else {
                        String text = "Игрок " + player2 + " получает " + e + " очков\n";
                        writer.write(text);
                        writer.flush();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            } else crossOrZero = 'o';
            b = b + 1;
            String z = Integer.toString(b);
            try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                // запись всей строки

                if (randomPlayer==1) {
                    String text = "Игрок " + player1 + " получает " + z + " очков\n";
                    writer.write(text);
                    writer.flush();
                }else {
                    String text = "Игрок " + player2 + " получает " + z + " очков\n";
                    writer.write(text);
                    writer.flush();
                }
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
                        c++;
                        break;
                    case 2:
                        c++;
                        field[0][1] = crossOrZero;
                        break;
                    case 3:
                        c++;
                        field[0][2] = crossOrZero;
                        break;
                    case 4:
                        c++;
                        field[1][0] = crossOrZero;
                        break;
                    case 5:
                        c++;
                        field[1][1] = crossOrZero;
                        break;
                    case 6:
                        c++;
                        field[1][2] = crossOrZero;
                        break;
                    case 7:
                        c++;
                        field[2][0] = crossOrZero;
                        break;
                    case 8:
                        c++;
                        field[2][1] = crossOrZero;
                        break;
                    case 9:
                        c++;
                        field[2][2] = crossOrZero;
                        break;
                }
            } else {
                if (c < 10) {
                    System.out.println("Введите число из оставшихся на поле!");
                    continue;
                } else {
                    break;
                }
            }

            checkingForMatch(field);

            draw(field);
            if (isWin) {
                if ( c==9 ) {

                    System.out.println("Ничья");

                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text3 = "Ничья";
                        writer.write(text3);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                } else if (randomPlayer==1) {
                    System.out.println("Победа: " + player1 + crossOrZero);


                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text2 = "Победил игрок " + player1 + crossOrZero + "\n";
                        writer.write(text2);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    printField(field);
                    break;
                }else {

                    System.out.println("Победа: " + player2 + crossOrZero);

                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text4 = "Победил игрок " + player2 + crossOrZero + "\n";
                        writer.write(text4);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text2 = "Победил игрок " + player2 + crossOrZero + "\n";
                        writer.write(text2);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    printField(field);
                    break;
                }

            } else
                System.out.println("Пока никто не выиграл. Играем дальше");
            try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                // запись всей строки
                String text3 = "Пока никто не выиграл. Играем дальше";
                writer.write(text3);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }


            if (a > b) {
                if (randomPlayer==1){
                    System.out.println("Ведет игрок х: "+player1+", у него "+" "+a+" очков");
                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text3 = "Ведет игрок х: "+player1+", у него "+" "+a+" очков, "+" у игрока "+player2+" "+b+" очков";
                        writer.write(text3);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                }else System.out.println("Ведет игрок х: "+player2+", у него "+" "+a+" очков ,у игрока "+player1+" "+b+" очков");
                try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                    // запись всей строки
                    String text4 = "Ведет игрок х: "+player2+", у него "+" "+a+" очков, "+" у игрока "+player1+" "+b+" очков";
                    writer.write(text4);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                if (randomPlayer==1){
                    System.out.println("Ведет игрок 0: "+player1+", у него "+" "+b+" очков, "+" у игрока "+player2+" "+a+" очков");
                    try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txt", true)) {
                        // запись всей строки
                        String text3 = "Ведет игрок O: "+player1+", у него "+b+" очков, "+" у игрока "+player2+" "+a+" очков";
                        writer.write(text3);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else System.out.println("Ведет игрок 0: "+player2+", у него "+" "+b+" очков ");
                try (FileWriter writer = new FileWriter("GameTwoLevel/bloknot.txtt", true)) {
                    // запись всей строки
                    String text6 = "Ведет игрок O: "+player2+", у него "+b+" очков, "+" у игрока "+player1+" "+a+" очков";
                    writer.write(text6);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            switcher++;
        }
    }


    public static void printField(char[][] field) { // печать поля
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j != 2) {
                    System.out.print(field[i][j] + "|");
                } else
                    System.out.print(field[i][j]);


            }
            System.out.println();


        }







        // public static char[][] Wist(char[][] field) {
        //    if (!Win) {
        //       try {
        //    printField(field);
        //      } catch (StackOverflowError e) {
        // System.out.println("");
        //      }
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

        if (c==10) {
            isWin = true;

        }

        return true;
    }

}

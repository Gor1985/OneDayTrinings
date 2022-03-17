package GameTwoLevel;

public class Switch {



    int randomPlayer;


    public char[][] sswitch() {

        randomPlayer = (int) (Math.random() * 2 + 1);
      if (randomPlayer == 1) {
            System.out.println(PlayerOne.getName() + " ходит первым!" + '\n');

        } else {

            System.out.println(PlayerTwo.getName() + " ходит первым!" + '\n');
            System.out.println("Введите число от 1 до 9, чтобы сделать Ваш ход: " + '\n');

        }


        return new char[0][];
    }
}

package Objectss;

public class Cat {
    static int  catCounts;
    int catCount;
    public Cat() {
        catCount++;
    }

    protected void finalize() throws Throwable{
        System.out.println("Обьект кошка уничтожен");
        catCount--;
    }

    int getCatCount() {
        return catCounts;
    }

    public static void setCatCounts(int catCounts) {
        Cat.catCounts = catCounts;
    }
}

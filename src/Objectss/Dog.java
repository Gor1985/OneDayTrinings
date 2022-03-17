package Objectss;

public class Dog {
    protected void finalize() throws Throwable{
        System.out.println("Обьект собака уничтожен");
    }
}

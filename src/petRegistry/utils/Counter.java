package petRegistry.utils;

public class Counter {

    private int counter;

    public int add() {
        return counter++;
    }

    public void show() {
        System.out.println(counter);
    }
}

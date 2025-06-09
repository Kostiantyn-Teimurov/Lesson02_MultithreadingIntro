package lesson02_multithreading.hw02.task;

import java.util.Random;

public class TarakansTasks implements Runnable{
    private String name;
    private int distance;
    public static String winner;

    public TarakansTasks(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println(name + " started!");
        for (int i = 1; i <= distance; i++) {
            System.out.println(name + ". Distance: " + i);
            try {
                Thread.sleep(random.nextInt(4) + 2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (winner == null) {
            winner = name;
        }
    }
}

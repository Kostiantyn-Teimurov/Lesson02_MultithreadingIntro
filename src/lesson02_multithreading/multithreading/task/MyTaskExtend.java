package lesson02_multithreading.multithreading.task;

public class MyTaskExtend extends Thread {
    private String name;
    private int max;

    public MyTaskExtend(String name, int max) {
        this.name = name;
        this.max = max;
    }


    @Override
    public void run() {
        System.out.println(name + " task started");
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " task finished");
    }
}

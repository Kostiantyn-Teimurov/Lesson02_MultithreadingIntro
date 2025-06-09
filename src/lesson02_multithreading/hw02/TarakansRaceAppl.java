package lesson02_multithreading.hw02;

import lesson02_multithreading.hw02.task.TarakansTasks;

import java.util.Scanner;

public class TarakansRaceAppl {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of tarakans: ");
        int countTarakans = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter race distance (iterations): ");
        int distance = scanner.nextInt();
        scanner.nextLine();


        Runnable[] tarakans = new Runnable[countTarakans];
        Thread[] threads = new Thread[countTarakans];
        for (int i = 1; i < tarakans.length; i++) {
            tarakans[i] = new TarakansTasks("Tarakan#" + i, distance);
            threads[i] = new Thread(tarakans[i]);
            threads[i].start();
        }

        for (int i = 1; i < tarakans.length; i++) {
            threads[i].join();
        }
        System.out.println("Congratulations to: " + TarakansTasks.winner + "!");

    }
}

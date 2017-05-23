package t2.threadSynchronization;

/**
 * Gracefully terminating a thread from another thread and introducing the volatile keyword.
 */

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Running");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();

		// Wait for the Enter Key Press
		new Scanner(System.in).nextLine();

		pro.shutdown();
	}
}
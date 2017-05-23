package t1.startingThreads.extendingThread;

/**
 * Starting threads by extending the Thread class. The start method needs to be
 * invoked in the main to start the threads separately.
 */

class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Application {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();

		Runner runner2 = new Runner();
		runner2.start();

	}

}
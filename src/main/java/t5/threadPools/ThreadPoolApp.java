package t5.threadPools;

/**
 * How to manage multiple threads in Java using thread pools. 
 * With thread pools you can assign a whole collection of threads to work
 *  through your queue of tasks.
 * 
 * An Executor is used to submit a task for execution
 * without being coupled to how or when the task is executed. 
 * Basically, it creates an abstraction that can be used in place of
 *  explicit thread creation and execution. 
 *   
 * An ExecutorService is an enhanced Executor that provides additional
 *  functionality, such as the ability to execute a Callable instance 
 *  and to shut down (nondaemon threads in an Executor may keep the JVM
 *   running after your main method returns). 
 * 
 * The Callable interface is similar to the Runnable interface,
 * but adds the ability to return a result from its call method and
 *  can optionally throw an exception. 
 *   
 * The Executors (plural) call provides factory methods that can be used
 *  to construct ExecutorService instances,
 * for example: 
 * ExecutorService ex = Executors.newFixedThreadPool(4);.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Starting: " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		System.out.println("Completed: " + id);
	}
}

public class ThreadPoolApp {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted.");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

		System.out.println("All tasks completed.");
	}
}
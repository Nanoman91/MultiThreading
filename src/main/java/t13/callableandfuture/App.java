package t13.callableandfuture;

/**
 * <p>
 * interface Callable: A task that returns a result and may throw an exception.
 * Just need to override call() method which Computes a result, or throws an exception if unable to do so.
 * The Callable interface is similar to Runnable, in that both are designed for classes
 * whose instances are potentially executed by another thread. A Runnable, however, 
 * does not return a result and cannot throw a checked exception. 
 *
 * interface Future: A Future represents the result of an asynchronous computation. Methods are provided to check
 * if the computation is complete, to wait for its completion, and to retrieve the result of the
 * computation. The result can only be retrieved using method get when the computation has completed,
 * blocking if necessary until it is ready. Cancellation is performed by the cancel method.
 * Additional methods are provided to determine if the task completed normally or was cancelled.
 * Once a computation has completed, the computation cannot be cancelled.
 * </p>
 * 
 * <p> Udemy tutorial </p>
 */

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		
		/* class Executors: Factory and utility methods for Executor, ExecutorService, 
		 ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package.
		 newCachedThreadPool: Creates a thread pool that creates new threads as needed,
		 but will reuse previously constructed threads when they are available.
		 interface ExecutorService: An Executor that provides methods to manage termination and
		 methods that can produce a Future for tracking progress of one or more asynchronous tasks.
		 */
		ExecutorService executor = Executors.newCachedThreadPool(); 
		
		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);

				if (duration > 2000) {
					throw new IOException("Sleeping for too long.");
				}

				System.out.println("Starting ...");

				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Finished.");

				return duration;
			}

		});

		executor.shutdown();

		try {
			System.out.println("Result is: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();

			System.out.println(ex.getMessage());
		}
	}

}

## MultiThreading

From Official JavaSE 8 docs: 

<p> <b>interface Callable:</b> A task that returns a result and may throw an exception.
  Just need to override call() method which Computes a result, or throws an exception if unable to do so.
  The Callable interface is similar to Runnable, in that both are designed for classes
  whose instances are potentially executed by another thread. A Runnable, however, 
  does not return a result and cannot throw a checked exception. 
 </p>
 <p>
  <b>interface Future:</b> A Future represents the result of an asynchronous computation. Methods are provided to check
  if the computation is complete, to wait for its completion, and to retrieve the result of the
  computation. The result can only be retrieved using method get when the computation has completed,
  blocking if necessary until it is ready. Cancellation is performed by the cancel method.
  Additional methods are provided to determine if the task completed normally or was cancelled.
  Once a computation has completed, the computation cannot be cancelled.
  </p>
  
  
  <b>class Executors:</b> Factory and utility methods for Executor, ExecutorService, 
		 ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package.
	<b>newCachedThreadPool:</b> Creates a thread pool that creates new threads as needed,
		 but will reuse previously constructed threads when they are available.
	<b>interface ExecutorService:</b> An Executor that provides methods to manage termination and
		 methods that can produce a Future for tracking progress of one or more asynchronous tasks.

Contents of the Project:

1- Java Multithreading: Starting Threads

2- Java Multithreading: Volatile – Basic Thread Communication

3- Java Multithreading: Synchronized

4- Java Multithreading: Lock Objects

5- Java Multithreading: Thread Pools

6- Java Multithreading: Countdown Latches

7- Java Multithreading: Producer-Consumer

8- Java Multithreading: Wait and Notify

9- Java Multithreading: Low-Level Producer-Consumer

10- Java Multithreading: Re-entrant Locks

11- Java Multithreading: Deadlock

12- Java Multithreading: Semaphores

13- Java Multithreading: Callable and Future

14- Java Multithreading: Interrupting Threads

15- Java Multithreading: Multithreading in Swing with SwingWorker

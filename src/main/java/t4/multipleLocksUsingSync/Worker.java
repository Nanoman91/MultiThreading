package t4.multipleLocksUsingSync;

/** 
 * First Disable synchronized(lock1) and synchronized(lock2) and run MultiLockTest class. 
 * Both the lists will not be full with 2000 items.
 * 
 * To resolve it we need to use synchronized but if we synchronize the stageOne()
 * method and stageTwo() method then thread t1 and t2 both will try to 
 * acquire the lock on Worker object which will cause the time taken will be
 *  twice as long like 4 seconds. Try it.
 * 
 * But we want a mechanism where Thread t1 and t2 can not run stageOne() at the same time
 *  but Thread t1 can run stageOne() and t2 can run stageTwo() at the same time
 *   without waiting for each other. But that can not be done with one lock.
 *   
 * Hence we use multiple locks to speed up complex multi-threaded code.
 * Now enable synchronized(lock1) and synchronized(lock2) and run MultiLockTest class.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	//public synchronized void stageOne() { // can be done but takes twice the time for execution
	public void stageOne() {
		//synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		//}

	}

	//public synchronized void stageTwo() { // can be done but takes twice the time for execution
	public void stageTwo() {
		//synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		//}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Starting ...");

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + "; List2: "
				+ list2.size());
	}
}
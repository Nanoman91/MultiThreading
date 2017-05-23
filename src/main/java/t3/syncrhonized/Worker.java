package t3.syncrhonized;

/**
 * Here two threads are incrementing the count and final
 * Count should be 200000 but instead it is less than that.
 * 
 * How do you resolve it?
 * Make the increment method synchronized.
 */

public class Worker {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public static void main(String[] args)
    {
    	Worker worker = new Worker();
    	worker.run();
    }
    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 100000; i++) {
                    increment();
                }
            }
        });
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 100000; i++) {
                    increment();
                }
            }
        });
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Count is: " + count);
    }
}
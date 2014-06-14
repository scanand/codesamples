package thread03.demo1;


/****
 * threads interleaving
 * 
 * both threads write on same variable
 * 
 * @author BGMTS
 *
 */

public class Worker {
    private int count = 0;
    
    public static void main(String[] args) {
		Worker w = new Worker();
		w.run();
	}
     
    /****
	 * without synchronized increment count operation both threads can
	 * overwirite count erroneously
	 * 
	 * volatile wont count help as the operation is not accessed serially 
	 * (1) execution control, and (2) memory visibility. The first has to do with
	 * controlling when code executes (including the order in which instructions
	 * are executed) and whether it can execute concurrently,
	 * 
	 * synchronized gets intrinsic lock
	 */
    public synchronized void increment() {
        count++;
    }
     
    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread1.start();
         
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
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
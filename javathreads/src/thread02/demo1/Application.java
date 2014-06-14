package thread02.demo1;

import java.util.Scanner;

/******
 * Gracefully terminating a thread from another thread:
 * 
 * @author BGMTS
 *
 */

/***
 * Runs some code which needs synchronization
 * @author BGMTS
 *
 */
class Processor extends Thread {
    
	//end condition
	//you have to change the value of this variable from other thread use volatile
	//when called shutdown() from other thread JVM can ignore change in "running" variable
	//and continue for ever, But when variable is volatile, the same variable used by second thread is updated 
    private volatile boolean running = true;
     
    public void run() {
         
        while(running) {
            System.out.println("Running");
             
            try {
                Thread.sleep(50); //pause
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
 
/****
 * Data cached, volatile keyord
 * 
 * 
 * @author BGMTS
 *
 */
public class Application {
 
    public static void main(String[] args) {
        Processor pro = new Processor();
        //spawns second thread from main thread
        pro.start(); // calls overridden run() methods
         
        // Wait for the enter key
        new Scanner(System.in).nextLine();
         
        //to end thread gracefully
        pro.shutdown();
    }
 
}
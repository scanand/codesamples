package thread04.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Worker {

	private List<Integer> list1= new ArrayList<Integer>();
	private List<Integer> list2= new ArrayList<Integer>();
	private Random random = new Random();
	
	public void stageOne()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
	public void stageTwo()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}		
	
	public void process() {
		
		
	}
	
}

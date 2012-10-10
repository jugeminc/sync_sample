package sample;

class MyWorker2 implements Runnable {
	
	private static final int LOOP_NUM = 10000000;
	
	private MyCounter2 counter;
	
	MyWorker2(MyCounter2 counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i = 0; i < LOOP_NUM; i++){
			this.counter.incremnt();
		}
		
	}
}

public class MyCounter2 {
	
	private int count;
	
	public synchronized void incremnt(){
		this.count++;
	}

	public static void main(String[] args) throws Exception{
		
		MyCounter2 counter = new MyCounter2();
		Thread t1 = new Thread(new MyWorker2(counter));
		t1.start();
		
		Thread t2 = new Thread(new MyWorker2(counter));
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter.count);
		
	}

}

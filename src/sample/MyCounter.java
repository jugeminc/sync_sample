package sample;

class MyWorker implements Runnable {
	
	private static final int LOOP_NUM = 10000000;
	
	private MyCounter counter;
	
	MyWorker(MyCounter counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i = 0; i < LOOP_NUM; i++){
			this.counter.incremnt();
		}
		
	}
}

public class MyCounter {
	
	private int count;
	
	public void incremnt(){
		this.count++;
	}

	public static void main(String[] args) throws Exception{
		
		MyCounter counter = new MyCounter();
		Thread t1 = new Thread(new MyWorker(counter));
		t1.start();
		
		Thread t2 = new Thread(new MyWorker(counter));
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter.count);
		
	}

}

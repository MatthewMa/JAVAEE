package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread{	
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(6);
		Runnable runnable = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		};
		newFixedThreadPool.submit(runnable);
		newFixedThreadPool.submit(runnable);
		newFixedThreadPool.shutdown();
	}	
}



package ThreadPoolExecutor;


	import java.util.concurrent.ExecutorService;  
	import java.util.concurrent.Executors;  
	/**
	 * 单线化线程池主要解决线程执行顺讯
	 *
	 */
	public class newSingleThreadExecutorDemo {  
	 public static void main(String[] args) {  
	  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
	  for (int i = 0; i < 10; i++) {  
	   final int index = i;  
	   singleThreadExecutor.execute(new Runnable() {  
	    public void run() {  
	     try {  
	      System.out.println(index);  
	      Thread.sleep(2000);  
	     } catch (InterruptedException e) {  
	      e.printStackTrace();  
	     }  
	    }  
	   });  
	  }  
	 }  
	}  

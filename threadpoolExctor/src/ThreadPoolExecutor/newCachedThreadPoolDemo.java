package ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  

public class newCachedThreadPoolDemo {  
	
 public static void main(String[] args) {  
	 
  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
	  for (int i = 0; i < 10; i++) {  
	   final int index = i;  
//	   try {  
//	    Thread.sleep(index * 1000);  //µÈ´ý1Ãë
//		   
//	   } catch (InterruptedException e) {  
//	    e.printStackTrace();  
//	   }  
	   cachedThreadPool.execute(new Runnable() {  
		    public void run() {
		        for (int x = 0; x < 10; x++) {
		            System.out.println(Thread.currentThread().getName() + ":" + x);
		       }
		    }
	   });  
	  }  
 }  
}  
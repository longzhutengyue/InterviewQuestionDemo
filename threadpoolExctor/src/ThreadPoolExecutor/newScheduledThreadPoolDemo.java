package ThreadPoolExecutor;

import java.util.concurrent.Executors;  
/**
 * ��Ҫ�����ʱ����
 */
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
public class newScheduledThreadPoolDemo {  
 public static void main(String[] args) {  
  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
  scheduledThreadPool.schedule(new Runnable() {  
   public void run() {  
    System.out.println("�ӳ� 3 seconds");  
   }  
  }, 3, TimeUnit.SECONDS);  
 }  
}  

package ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newFixedThreadPoolDemo {
    public static void main(String[] args) {
        // ����һ���̳߳ض��󣬿���Ҫ���������̶߳���
        // public static ExecutorService newFixedThreadPool(int nThreads)
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // ����ִ��Runnable�������Callable���������߳�
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

       //�����̳߳�
       pool.shutdown();
      }
    
    
}

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class test1  extends Thread {

	@Test
	void test() {
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
		    System.out.println(feature);
		}
	}
	
	/**
	 * ��forѭ���ı����Ż�
	 */
	@Test
	void test2() {
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		//features.forEach(n-> System.out.println(n));
		features.forEach(System.out::println);
	}
	
	
	@Test
	void test3() {
		
		new Thread(new Runnable() {   //    �����ڲ����д��    
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
	}

	/**
	 * ʹ��lambda���������ڲ���
	 */
	@Test
	void test4() {
		
		new Thread(new Runnable() {   //    �����ڲ����д��    
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
	}

}

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
	 * 对for循环的遍历优化
	 */
	@Test
	void test2() {
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		//features.forEach(n-> System.out.println(n));
		features.forEach(System.out::println);
	}
	
	
	@Test
	void test3() {
		
		new Thread(new Runnable() {   //    匿名内部类的写法    
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
	}

	/**
	 * 使用lambda代替匿名内部类
	 */
	@Test
	void test4() {
		
		new Thread(new Runnable() {   //    匿名内部类的写法    
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
	}

}

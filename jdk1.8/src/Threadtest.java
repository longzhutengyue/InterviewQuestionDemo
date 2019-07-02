
public class Threadtest {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {   //    匿名内部类的写法    
		    @Override
		    public void run() {
		    System.out.println("匿名内部类实现runnable接口");
		    }
		});
		
		t1.start();
		

	}
}

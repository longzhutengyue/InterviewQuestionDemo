
public class main {
	
	
	public static void main(String[] args) {
	   new MyThread().start();//创建并启动线程
	}
	

}
class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程1启动");
	}

}
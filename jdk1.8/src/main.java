
public class main {
	
	
	public static void main(String[] args) {
	   new MyThread().start();//�����������߳�
	}
	

}
class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�߳�1����");
	}

}
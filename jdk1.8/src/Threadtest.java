
public class Threadtest {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {   //    �����ڲ����д��    
		    @Override
		    public void run() {
		    System.out.println("�����ڲ���ʵ��runnable�ӿ�");
		    }
		});
		
		t1.start();
		

	}
}

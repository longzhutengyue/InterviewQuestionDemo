package Extend;

public class zooson extends zoo{

	/**
	 * �̳г��������ʵ�ֳ�����ĳ��󷽷����̳��������
	 * ��д����Է���
	 * 
	 * ��д����ĳ��󷽷����������η�������ֵ
	 * 
	 *��д�����׳��ȸ��෶Χ������쳣
	 *
	 *�����final�������ܱ���д��һ��ֻ����д����ĳ��󷽷�
	 */
	@Override
	public void eat() {

		System.out.println("��ˮ��");
	}

	@Override
	public void sleep() {
		System.out.println("˯��");
	}

	public static void main(String[] args) {
		zooson zooson1=new zooson();
		zooson1.eat();
	}
}

package Extend;

class Animal{
	   public void move(){
		   
	      System.out.println("��������ƶ�");
	   }
	   public static void main(String args[]){
	      Animal a = new Animal(); // Animal ����
	      Animal b = new Dog(); // Dog ����
	 
	      
	      a.move();// ִ�� Animal ��ķ���
	 
	      b.move();//ִ�� Dog ��ķ���
	   }
}   

class Dog extends Animal{
	   public void move(){
	      System.out.println("�������ܺ���");
	   }
	}

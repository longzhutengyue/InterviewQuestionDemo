package Extend;

class Animal{
	   public void move(){
		   
	      System.out.println("动物可以移动");
	   }
	   public static void main(String args[]){
	      Animal a = new Animal(); // Animal 对象
	      Animal b = new Dog(); // Dog 对象
	 
	      
	      a.move();// 执行 Animal 类的方法
	 
	      b.move();//执行 Dog 类的方法
	   }
}   

class Dog extends Animal{
	   public void move(){
	      System.out.println("狗可以跑和走");
	   }
	}

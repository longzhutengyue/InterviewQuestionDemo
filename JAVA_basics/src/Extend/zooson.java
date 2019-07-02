package Extend;

public class zooson extends zoo{

	/**
	 * 继承抽象类必须实现抽象类的抽象方法，继承是针对类
	 * 重写是针对方法
	 * 
	 * 重写父类的抽象方法，访问修饰符、返回值
	 * 
	 *重写不能抛出比父类范围更大的异常
	 *
	 *父类的final方法不能被重写。一般只是重写父类的抽象方法
	 */
	@Override
	public void eat() {

		System.out.println("吃水果");
	}

	@Override
	public void sleep() {
		System.out.println("睡觉");
	}

	public static void main(String[] args) {
		zooson zooson1=new zooson();
		zooson1.eat();
	}
}

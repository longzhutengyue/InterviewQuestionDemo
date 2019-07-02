import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class Stu {
	private int age;
	private String name;
	public String addr;
	
	public Stu(int age, String name, String addr) {
		this.age = age;
		this.name = name;
		this.addr = addr;
	}
 
	public Stu(int age, String name) {
		this.age = age;
		this.name = name;
	}
 
	private Stu(int age) {
		this.age = age;
	}
 
	public Stu() {
	}
	
	private int method1(){
		return 0;
	}
	private int method2(int age){
		return age;
	}
	public void print(String name,int age){
		System.out.println("hello£º"+name+"ÄêÁä£º"+age);
	}
	
	public String print2(String name,int age){
		System.out.println("hello£º"+name+"ÄêÁä£º"+age);
		return null;
	}
 
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", addr=" + addr
				+ "]";
	}	
}


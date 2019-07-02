import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
 

 
public class ReflectDemo {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}
	@Test
	public void test() throws Exception{
		User u = new User();
		//通过Class的forName方法，注意使用目标类的全路径（文件所在包以下路径）
		Class clazz = Class.forName("reflect.User");
		
		//反射类的构造方法
		//通过无参构造器得到该类的对象
		//User user = (User)clazz.newInstance();
		Constructor c = clazz.getConstructor(null);
		User user = (User)c.newInstance(null);
		//通过带参构造器获得该类对象
		Constructor c1 = clazz.getConstructor(String.class);
		User user1 = (User)c1.newInstance("nick");
		
		//获得方法名为login但是没有参数的method对象
		Method method = clazz.getMethod("login",null);
		//第一个参数为哪个user对象，第二个参数就是这个方法的参数
		method.invoke(u,null);
		//获取有参数返回值的方法eat
		Method method1 = clazz.getMethod("eat",String.class);
		String args = (String)method1.invoke(u,"超人");
		//获取带有参数无返回值的静态方法sleep
		Method method2 = clazz.getMethod("sleep",String.class);
		method2.invoke(null, "蝙蝠侠");
		
		/**************反射类的字段*******************/
		//注意需要用getDeclareField方法，getField只能获取到public的字段
		Field f = clazz.getDeclaredField("name");
		Class type = f.getType();
		System.out.println(type);
		f.setAccessible(true);
		f.set(u, "wang");
		String name = (String)f.get(u);
		System.out.println(name);
	}
}
class User{
	private String name;
	private String password;
	
	public User() {
		System.out.println("无参构造方法");
	}
	public User(String name) {
		System.out.println("带参数的构造方法"+name);
	}
	//无参无返回值的方法login
	public void login() {
		System.out.println("用户登陆");
	}
	//带参数有返回值的方法eat
	public String eat(String name) {
		System.out.println("用户"+name+"登陆了");
		return "eat";
	}
	//带有参数无返回值的静态方法
	public static void sleep(String name) {
		System.out.println(name+"去睡觉了");
	}
}

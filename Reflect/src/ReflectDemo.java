import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
 

 
public class ReflectDemo {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}
	@Test
	public void test() throws Exception{
		User u = new User();
		//ͨ��Class��forName������ע��ʹ��Ŀ�����ȫ·�����ļ����ڰ�����·����
		Class clazz = Class.forName("reflect.User");
		
		//������Ĺ��췽��
		//ͨ���޲ι������õ�����Ķ���
		//User user = (User)clazz.newInstance();
		Constructor c = clazz.getConstructor(null);
		User user = (User)c.newInstance(null);
		//ͨ�����ι�������ø������
		Constructor c1 = clazz.getConstructor(String.class);
		User user1 = (User)c1.newInstance("nick");
		
		//��÷�����Ϊlogin����û�в�����method����
		Method method = clazz.getMethod("login",null);
		//��һ������Ϊ�ĸ�user���󣬵ڶ�������������������Ĳ���
		method.invoke(u,null);
		//��ȡ�в�������ֵ�ķ���eat
		Method method1 = clazz.getMethod("eat",String.class);
		String args = (String)method1.invoke(u,"����");
		//��ȡ���в����޷���ֵ�ľ�̬����sleep
		Method method2 = clazz.getMethod("sleep",String.class);
		method2.invoke(null, "������");
		
		/**************��������ֶ�*******************/
		//ע����Ҫ��getDeclareField������getFieldֻ�ܻ�ȡ��public���ֶ�
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
		System.out.println("�޲ι��췽��");
	}
	public User(String name) {
		System.out.println("�������Ĺ��췽��"+name);
	}
	//�޲��޷���ֵ�ķ���login
	public void login() {
		System.out.println("�û���½");
	}
	//�������з���ֵ�ķ���eat
	public String eat(String name) {
		System.out.println("�û�"+name+"��½��");
		return "eat";
	}
	//���в����޷���ֵ�ľ�̬����
	public static void sleep(String name) {
		System.out.println(name+"ȥ˯����");
	}
}

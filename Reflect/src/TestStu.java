import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestStu {

	@Test
	public void getMsthods() {
		Stu student = new Stu();
		Class studentClass = student.getClass();
		// getDeclaredMethods得到本类中所有方法
		Method[] studentMethods = studentClass.getMethods();//获取所有的
		Method[] studentMethods2 = studentClass.getDeclaredMethods();//只获取public修饰的
		System.out.println("方法个数："+studentMethods.length);
		System.out.println("方法个数："+studentMethods2.length);
		for (Method method : studentMethods) {
			//得到返回类型
			System.out.print("方法名称和参数："+method.getName()+"(");
			//取得某个方法对应的参数类型数组
			Class[] paramsType =  method.getParameterTypes();
			for (Class paramType : paramsType) {
				System.out.print(paramType.getTypeName()+" ");
			}
			System.out.print(")");
			Class returnType = method.getReturnType();
			System.out.println("返回类型："+returnType.getTypeName());
		}
		for (Method method : studentMethods2) {
			//得到返回类型
			System.out.print("private类型的方法名称和参数："+method.getName()+"(");
			//取得某个方法对应的参数类型数组
			Class[] paramsType =  method.getParameterTypes();
			for (Class paramType : paramsType) {
				System.out.print(paramType.getTypeName()+" ");
			}
			System.out.print(")");
			Class returnType = method.getReturnType();
			System.out.println("返回类型："+returnType.getTypeName());
		}
	}
	@Test
	public void getConstructors() {
		Constructor[] cs2 = Stu.class.getConstructors();
		Constructor[] cs22 = Stu.class.getDeclaredConstructors();
		System.out.println("构造方法个数："+cs2.length);
		System.out.println("构造方法个数："+cs22.length);
		for (Constructor constructor : cs2) {
			String printstr = "(";
			//获取某个构造方法中的参数数组
			Class[] paramsType = constructor.getParameterTypes();
			for (Class parameter : paramsType) {
				printstr = printstr+parameter.getTypeName()+",";
			}
			if(printstr.length()>2){
			printstr = printstr.substring(0, printstr.length()-1);
			}
			System.out.println(printstr+")");
		}
		for (Constructor constructor : cs22) {
			String printstr = "(";
			//获取某个构造方法中的参数数组
			Class[] paramsType = constructor.getParameterTypes();
			for (Class parameter : paramsType) {
				printstr = printstr+parameter.getTypeName()+",";
			}
			if(printstr.length()>2){
			printstr = printstr.substring(0, printstr.length()-1);
			}
			System.out.println(printstr+")");
		}
	}
	@Test
	public void getfields() {
		//getFields()方法获取的是所有的public的信息
				//getDeclaredFields()获取的是该类自己声明的成员变量信息
				Class stuClass = Stu.class;
				Field[] fs = stuClass.getDeclaredFields();
				Field[] fs2 = stuClass.getFields();//仅能获得public类型的变量
				for(Field field : fs){
					//得到类的变量的类型的类类型
					Class fieldType = field.getType();
				String fieldTypeStr = fieldType.getName();
				//得到成员变量的名称
				String fieldname = field.getName();
				System.out.println("getDeclaredFields方法获取：类型："+fieldTypeStr+"名称："+fieldname);
				}
				for(Field field : fs2){
					//得到类的变量的类型的类类型
					Class fieldType = field.getType();
				String fieldTypeStr = fieldType.getName();
				//得到成员变量的名称
				String fieldname = field.getName();
				System.out.println("getFields方法获取：类型："+fieldTypeStr+"名称："+fieldname);
				}
	}
}

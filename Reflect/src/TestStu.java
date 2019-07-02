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
		// getDeclaredMethods�õ����������з���
		Method[] studentMethods = studentClass.getMethods();//��ȡ���е�
		Method[] studentMethods2 = studentClass.getDeclaredMethods();//ֻ��ȡpublic���ε�
		System.out.println("����������"+studentMethods.length);
		System.out.println("����������"+studentMethods2.length);
		for (Method method : studentMethods) {
			//�õ���������
			System.out.print("�������ƺͲ�����"+method.getName()+"(");
			//ȡ��ĳ��������Ӧ�Ĳ�����������
			Class[] paramsType =  method.getParameterTypes();
			for (Class paramType : paramsType) {
				System.out.print(paramType.getTypeName()+" ");
			}
			System.out.print(")");
			Class returnType = method.getReturnType();
			System.out.println("�������ͣ�"+returnType.getTypeName());
		}
		for (Method method : studentMethods2) {
			//�õ���������
			System.out.print("private���͵ķ������ƺͲ�����"+method.getName()+"(");
			//ȡ��ĳ��������Ӧ�Ĳ�����������
			Class[] paramsType =  method.getParameterTypes();
			for (Class paramType : paramsType) {
				System.out.print(paramType.getTypeName()+" ");
			}
			System.out.print(")");
			Class returnType = method.getReturnType();
			System.out.println("�������ͣ�"+returnType.getTypeName());
		}
	}
	@Test
	public void getConstructors() {
		Constructor[] cs2 = Stu.class.getConstructors();
		Constructor[] cs22 = Stu.class.getDeclaredConstructors();
		System.out.println("���췽��������"+cs2.length);
		System.out.println("���췽��������"+cs22.length);
		for (Constructor constructor : cs2) {
			String printstr = "(";
			//��ȡĳ�����췽���еĲ�������
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
			//��ȡĳ�����췽���еĲ�������
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
		//getFields()������ȡ�������е�public����Ϣ
				//getDeclaredFields()��ȡ���Ǹ����Լ������ĳ�Ա������Ϣ
				Class stuClass = Stu.class;
				Field[] fs = stuClass.getDeclaredFields();
				Field[] fs2 = stuClass.getFields();//���ܻ��public���͵ı���
				for(Field field : fs){
					//�õ���ı��������͵�������
					Class fieldType = field.getType();
				String fieldTypeStr = fieldType.getName();
				//�õ���Ա����������
				String fieldname = field.getName();
				System.out.println("getDeclaredFields������ȡ�����ͣ�"+fieldTypeStr+"���ƣ�"+fieldname);
				}
				for(Field field : fs2){
					//�õ���ı��������͵�������
					Class fieldType = field.getType();
				String fieldTypeStr = fieldType.getName();
				//�õ���Ա����������
				String fieldname = field.getName();
				System.out.println("getFields������ȡ�����ͣ�"+fieldTypeStr+"���ƣ�"+fieldname);
				}
	}
}

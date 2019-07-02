package cn.com.infcn.ioc;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import cn.com.infcn.annotation.Component;
import cn.com.infcn.annotation.Inject;
/**
 * Ioc ����ʵ����
 * 
ɨ�����ָ����·���µ����е�Class�����жϸ�Class�Ƿ���@Componentע����࣬
����ǣ��򴴽�ʵ���������浽applicationContext�����С�
����IocUtil.inject()����������ע�롣
 */
public class IocContext {
	/**
	 * 1����������
	 */
    public static final Map<Class<?>, Object> applicationContext = new ConcurrentHashMap<Class<?>, Object>();
    static{
    	
    	
        String packageName = "cn.com.infcn";
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void initBean(String packageName) throws Exception {
    	/**
    	 * 2��ͨ��getResources��ȡָ��·�������ļ�
    	 */
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
        while (urls.hasMoreElements()) {
        	String filePath=urls.nextElement().getPath();
            try {
            	//3, ��ȡ��·����������class�ļ���Ŀ¼
            	File[] files=new File(filePath).listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
                    }
                });
            	
                if (files != null) {
                    for (File f : files) {
                        String fileName = f.getName();
                        if (f.isFile()) {
                            Class<?> clazz = Class.forName(packageName + "." + fileName.substring(0, fileName.lastIndexOf(".")));
                            //4���жϸ����Ƿ�ʵ����ע��
                            if(clazz.isAnnotationPresent(Component.class)) {
                            	
                            	//5��ʵ����clazz���ҷ���applicationContext����
                                applicationContext.put(clazz, clazz.newInstance());
                            }
                        } else {
                            addClassByAnnotation(f.getPath(), packageName + "." + fileName);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

        /**
			 * Ioc ע��ʵ��
			 * ѭ������ applicationContext�����е�Bean���ж�ÿ��Bean���Ƿ��б�@Injectע�����ε����ԣ�
			 * ��������applicationContext�л�ȡҪע���ʵ������ʹ�÷���ʵ���Զ�ע�빦�ܡ�
         */
        //IOCʵ�֣� �Զ�ע��
        Map<Class<?>, Object> map = IocContext.applicationContext;
        try {
            for (Entry<Class<?>, Object> entry : map.entrySet()) {
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                //6��ͨ�����䣬�����������ó�����Ϣ
                Field[] fields = clazz.getDeclaredFields();//���ķ�������ȡ����Ϣ
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = map.get(fieldClazz);
                        
                        //7�� ����ȡ����bean��Ϣ��ͨ������ע�뵽ע�������ĵط�
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //��ȡָ����·����ʵ�� Component����Bean��ʵ��
    private static void addClassByAnnotation(String filePath, String packageName) {
        try {
        	//��ȡ��·����������class�ļ���Ŀ¼
        	File[] files=new File(filePath).listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
                }
            });
        	
            if (files != null) {
                for (File f : files) {
                    String fileName = f.getName();
                    if (f.isFile()) {
                        Class<?> clazz = Class.forName(packageName + "." + fileName.substring(0, fileName.lastIndexOf(".")));
                        //�жϸ����Ƿ�ʵ����ע��
                        if(clazz.isAnnotationPresent(Component.class)) {
                        	
                        	//ʵ����clazz���ҷ���applicationContext����
                            applicationContext.put(clazz, clazz.newInstance());
                        }
                    } else {
                        addClassByAnnotation(f.getPath(), packageName + "." + fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
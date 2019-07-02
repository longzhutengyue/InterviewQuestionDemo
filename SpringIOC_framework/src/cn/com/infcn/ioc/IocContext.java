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
 * Ioc 容器实现类
 * 
扫描加载指定包路径下的所有的Class，并判断该Class是否是@Component注解的类，
如果是，则创建实例，并保存到applicationContext缓存中。
调用IocUtil.inject()，进行依赖注入。
 */
public class IocContext {
	/**
	 * 1，创建容器
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
    	 * 2，通过getResources获取指定路径的下文件
    	 */
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
        while (urls.hasMoreElements()) {
        	String filePath=urls.nextElement().getPath();
            try {
            	//3, 获取该路径下所遇的class文件和目录
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
                            //4，判断该类是否实现了注解
                            if(clazz.isAnnotationPresent(Component.class)) {
                            	
                            	//5，实例化clazz并且放入applicationContext容器
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
			 * Ioc 注入实现
			 * 循环变量 applicationContext中所有的Bean，判断每个Bean中是否有被@Inject注解修饰的属性，
			 * 如果有则从applicationContext中获取要注入的实例，并使用反射实现自动注入功能。
         */
        //IOC实现， 自定注入
        Map<Class<?>, Object> map = IocContext.applicationContext;
        try {
            for (Entry<Class<?>, Object> entry : map.entrySet()) {
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                //6，通过反射，从容器里面拿出类信息
                Field[] fields = clazz.getDeclaredFields();//核心方法，获取类信息
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = map.get(fieldClazz);
                        
                        //7， 将获取到的bean信息，通过反射注入到注解申明的地方
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取指定包路径下实现 Component主键Bean的实例
    private static void addClassByAnnotation(String filePath, String packageName) {
        try {
        	//获取该路径下所遇的class文件和目录
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
                        //判断该类是否实现了注解
                        if(clazz.isAnnotationPresent(Component.class)) {
                        	
                        	//实例化clazz并且放入applicationContext容器
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
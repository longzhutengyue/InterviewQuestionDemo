package org.aop;

import org.aop.annotion.aspect.Aspect;
import org.aop.annotion.aspect.PointCut;
import org.aop.proxy.AbsMethodAdvance;
import org.aop.util.ClassUtil;
import org.aop.util.ReflectionUtil;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 15:25  2018/4/18
 **/
public class ApplicationContext {

	/**
	 * 存放代理类的集合
	 */
	public static ConcurrentHashMap<String, Object> proxyBeanMap = new ConcurrentHashMap<String, Object>();

	static {
		initAopBeanMap("org.aop.demo");
	}

	/**
	 * 初始化 aop 容器
	 */
	public static void initAopBeanMap(String basePath) {
		try {
			//通过反射获取类信息
			Set<Class<?>> classSet = ClassUtil.getClassSet(basePath);

			for (Class clazz : classSet) {
				if (clazz.isAnnotationPresent(Aspect.class)) {
					//循环切面所在的类并获取该类信息
					Method[] methods = clazz.getMethods();

					for(Method method : methods) {

						if (method.isAnnotationPresent(PointCut.class)) {
							
							// 循环被@Aspect标记为切面的类，循环获取标记为@PointCut的切点信息
							PointCut pointCut = (PointCut) method.getAnnotations()[0];
							String pointCutStr = pointCut.value();
							String[] pointCutArr = pointCutStr.split("_");

							// 获取需要被代理的类名
							String className = pointCutArr[0];
							// 获取需要被代理的方法名
							String methodName = pointCutArr[1];

							// 实例化被代理对象
							Object targetObj = ReflectionUtil.newInstance(className);
							// 实例化代理对象
							AbsMethodAdvance proxyer = (AbsMethodAdvance) ReflectionUtil.newInstance(clazz);
							// 设置代理的方法
							proxyer.setProxyMethodName(methodName);

							//将实例化的被代理的对象，传入实例化的代理对象，通过enhancer的create()方法，创建代理对象
							Object object = proxyer.createProxyObject(targetObj);

							if (object != null) {
								//将代理对象放入aop代理容器
								proxyBeanMap.put(targetObj.getClass().getSimpleName().toLowerCase(), object);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

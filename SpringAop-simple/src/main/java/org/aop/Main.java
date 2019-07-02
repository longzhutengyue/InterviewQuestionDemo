package org.aop;

import org.aop.demo.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: huangwenjun
 * @Description:
 * @Date: Created in 15:57  2018/4/18
 **/
public class Main {

	public static void main(String[] args) {
		// 1,初始化applicationContext容器
		ApplicationContext applicationContext = new ApplicationContext();
		//2，通过jdk动态代理或者cgli生成代理容器
		ConcurrentHashMap<String, Object> proxyBeanMap = ApplicationContext.proxyBeanMap;

		// 3，从容器中拿到代理对象 
		Test test = (Test) proxyBeanMap.get("test");
		test.doSomeThing();

		System.out.println("-------------");

		test.doWtihNotProxy();
	}
}

package com.lqr.HWspringboot.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
	 * 创建SpittrWebAppInitializer类
	继承于AbstractAnnotationConfigDispatcherServletInitializer类，
	这个类是负责配置DispatcherServlet、初始化SpringMVC容器、spring容器。
	
	getRootConfigClasses()用于加载根配置信息，初始化spring容器，
	
	getServletConfigClasses()用于加载springMVC配置信息，初始化springMVC容器
	
	getServletMappings()用于配置拦截url映射，这里“/”表示拦截所有请求

 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载根配置信息 spring核心
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    // springmvc 加载 配置信息
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    // springmvc 拦截url映射 拦截所有请求
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

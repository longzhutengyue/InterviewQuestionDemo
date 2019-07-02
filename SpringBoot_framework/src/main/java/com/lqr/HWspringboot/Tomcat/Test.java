package com.lqr.HWspringboot.Tomcat;

import com.lqr.HWspringboot.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * 更改上一节的手写Tomcat运行程序，将读取自己创建的Servlet改为读取项目生成的class文件，即读取springMVC生成的Servlet对象
 * @author USER
 *
 */
public class Test {
    private static int PORT = 8080;
//    private static String CONTEXT_PATH = "/hwtomcat";
//    private static String SERVER_NAME = "indexServlet";
    public static void main( String[] args ) throws LifecycleException {
//        创建Tomcat服务器
        Tomcat tomcatServer = new Tomcat();
//        设置端口号
        tomcatServer.setPort(PORT);
//        读取项目路径 加载静态资源
        StandardContext standardContext = (StandardContext)tomcatServer.addWebapp("/",
                new File("src/main").getAbsolutePath());
//        禁止重新载入
        standardContext.setReloadable(false);
//        class文件读取地址
        File additionWebInfClasses = new File("target/classes");
//        创建WebRoot
        WebResourceRoot resources = new StandardRoot(standardContext);
//        tomcat内部读取Class执行
        resources.addPreResources(
                new DirResourceSet(resources,"/WEB-INF/classes",
                        additionWebInfClasses.getAbsolutePath(),"/")
        );
        tomcatServer.start();
        System.out.println("tomcat启动成功...");
//        异步进行接收请求
        tomcatServer.getServer().await();
    }
}

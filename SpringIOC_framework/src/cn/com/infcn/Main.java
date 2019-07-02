package cn.com.infcn;
import cn.com.infcn.controller.UserController;
import cn.com.infcn.ioc.IocContext;
/**
 * 模拟调用UserController
 * 
 * 从IocContext 容器中获取UserController实例，并调用getUser()方法。运行结果结果如下图。
 * 从结果中我们发现 UserController中的UserService被容器自动注入进来了。
 * 然后调用UserService.getUser() 获取用户信息。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        UserController userController = (UserController)IocContext.applicationContext.get(UserController.class);
        userController.getUser();
    }
}
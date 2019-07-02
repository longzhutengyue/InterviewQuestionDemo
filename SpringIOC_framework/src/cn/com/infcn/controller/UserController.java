package cn.com.infcn.controller;
import cn.com.infcn.annotation.Component;
import cn.com.infcn.annotation.Inject;
import cn.com.infcn.bean.User;
import cn.com.infcn.service.UserService;
/**
 * 用户Controller实现
 * 
Usercontroller实现，该类被@Component注解注释，表示受容器管理的Bean。 
userService熟悉使用了@Inject自定义注解，表示该属性是容器自动注入该实例，实现IOC功能。
 */
@Component
public class UserController {
    @Inject
    private UserService userService;
    public void getUser() {
        User user = userService.getUser();
        System.out.println(user);
    }
}
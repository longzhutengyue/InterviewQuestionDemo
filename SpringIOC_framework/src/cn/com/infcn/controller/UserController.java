package cn.com.infcn.controller;
import cn.com.infcn.annotation.Component;
import cn.com.infcn.annotation.Inject;
import cn.com.infcn.bean.User;
import cn.com.infcn.service.UserService;
/**
 * �û�Controllerʵ��
 * 
Usercontrollerʵ�֣����౻@Componentע��ע�ͣ���ʾ�����������Bean�� 
userService��Ϥʹ����@Inject�Զ���ע�⣬��ʾ�������������Զ�ע���ʵ����ʵ��IOC���ܡ�
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
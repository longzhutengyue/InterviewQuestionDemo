package cn.com.infcn;
import cn.com.infcn.controller.UserController;
import cn.com.infcn.ioc.IocContext;
/**
 * ģ�����UserController
 * 
 * ��IocContext �����л�ȡUserControllerʵ����������getUser()���������н���������ͼ��
 * �ӽ�������Ƿ��� UserController�е�UserService�������Զ�ע������ˡ�
 * Ȼ�����UserService.getUser() ��ȡ�û���Ϣ��
 */
public class Main {
    public static void main(String[] args) throws Exception {
        UserController userController = (UserController)IocContext.applicationContext.get(UserController.class);
        userController.getUser();
    }
}
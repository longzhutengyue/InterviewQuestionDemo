package com.cn.test;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.cn.entity.User;

public class TestHibernate {

    @Test
    public void add() {
        // 读取配置文件
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        // 得到当前连接数据库的session
        Session session = factory.openSession();
        // 开启事务
        Transaction tx = session.beginTransaction();
        try {
            User user = new User(15, "liujuan1", "123456", "13610249898", "admin", "yes");
            Serializable id = session.save(user);

            if (id != null) {
                System.out.println("新增成功！");
                tx.commit();// 提交事务
            } else {
                tx.rollback();// 失败回滚
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void select() {
        // 读取配置文件
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        // 得到当前连接数据库的session
        Session session = factory.openSession();
        // 开启事务
        Transaction tx = session.beginTransaction();
        try {
            // 查询get
            User user = (User) session.get(User.class, 15);
            System.out.println("查询结果：" + user.getName());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void update() {
        // 读取配置文件
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        // 得到当前连接数据库的session
        Session session = factory.openSession();
        // 开启事务
        Transaction tx = session.beginTransaction();
        try {
            // 第1种：update持久化修改：先查询，与数据库有关联
        /*    User user = (User) session.get(User.class, 15);
            user.setName("duheyu");
            user.setPassword("duheyu");
            session.update(user);
            tx.commit();*/
            
            //第2种：瞬时状态下修改,会set全部字段，不修改的字段全部清空了
            /*User user =new User();
            user.setId(15);
            user.setName("duxinke");
            user.setPassword("duxinke");
            session.update(user);
            tx.commit();*/
            
            //第3种，新增或修改，拿瞬时状态来测试
            User user =new User();
            user.setId(15);
            user.setName("duxinke");
            user.setPassword("duxinke");
            session.saveOrUpdate(user);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    @Test
    public void delete(){
        //读取并解析配置文件hibernate.cfg.xml
        Configuration config=new Configuration().configure();
        //读取并解析映射信息，User.hbm.xml,创建SessionFactory
        SessionFactory factory = config.buildSessionFactory();
        //打开一个连接数据库的Session
        Session session = factory.openSession();
        //开始一个事务，增删除查改操作必须有，查询操作可选
        Transaction tx =session.beginTransaction();
        //执行操作，都是用当前Session执行
        try {
            User user =new User();
            user.setId(15);
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
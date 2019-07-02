package com;



public class mainTest {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Master master = (Master)context.getBean("hostess");
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("***********************************");
        master.WalkDog();
    }
}

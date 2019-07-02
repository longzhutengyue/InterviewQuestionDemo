package com;



import java.io.File;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private String fileName;
    
    public ClassPathXmlApplicationContext(String fileName){
        this.fileName = fileName;
    }
    
    @Override
    public Object getBean(String beanid) {
        //��ȡ����ĵ�ǰĿ¼
        String currentPath = this.getClass().getResource("").getPath().toString();
        
        SAXReader reader = new SAXReader();//DOM4J������
        Document doc = null;//xml�ĵ�����
        Object obj = null;//Ŀ�����������ʵ��
        try {
            doc = reader.read(  new File(currentPath+fileName)  );
            String xpath = "/beans/bean[@id='"+beanid+"']";
            Element beanNode = (Element) doc.selectSingleNode(xpath);
            String className = beanNode.attributeValue("class");
            obj = Class.forName(className).newInstance();
            
            Element propertyNode = (Element) beanNode.selectSingleNode("property");
            
            if(propertyNode!=null){
                System.out.println("��ǰbean��������Ҫע��");
                
                String propertyName = propertyNode.attributeValue("name");
                System.out.println("��ǰbean��Ҫע�������Ϊ"+propertyName);
                
                //ƴ�ӳ�ע�뷽��
                String setMethod = "set"+(propertyName.substring(0, 1)).toUpperCase()+propertyName.substring(1,propertyName.length());
                System.out.println("�Զ�����ע�뷽��"+setMethod);
                
                String set_object_name = propertyNode.attributeValue("ref");
                System.out.println("��Ҫע��Ķ�����"+set_object_name);
                
                Object di_object = getBean(set_object_name);
                System.out.println("ע��Ķ���ʵ��"+di_object);
                
                Method []methods = obj.getClass().getMethods();
                
                for (Method m : methods) {
                    if(setMethod.equals(m.getName())  ) {
                        m.invoke(obj, di_object);
                        break;
                    }
                }
                
            }else{
                System.out.println("��ǰbeanû�����ԣ�����ע��ֱ�ӽ���");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return obj;
    }

}

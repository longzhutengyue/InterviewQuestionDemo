package cn.com.infcn.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ָ����Ҫ�����������
 * 
 * �ȶ���һ��@Componentע�⡣ֻҪ��@Component�Զ�������ע�͵��඼�������������Bean
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
}
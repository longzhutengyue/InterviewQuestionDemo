package cn.com.infcn.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ָ����Ҫע�������
 * 
����һ��@Injectע�⣬ֻҪ�Ǳ�@Injectע��ע�͵����Զ����Զ�ע�룬ʵ��IOC���ܡ�
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
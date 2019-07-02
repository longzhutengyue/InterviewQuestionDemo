package cn.com.infcn.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 指定需要注入的属性
 * 
定义一个@Inject注解，只要是被@Inject注解注释的属性都会自动注入，实现IOC功能。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
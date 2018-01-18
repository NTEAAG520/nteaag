package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class TestCase {
    /**
     * 测试实例化Spring容器实例
     */
    @Test
    public void teatInitContext(){
        String conf = "C:\\apache-tomcat-9.0.1\\webapps\\ROOT\\WEB-INF\\applicationContext.xml";
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(conf);
        System.out.println("applicationContext文件内容："+applicationContext);

    }

    @Test
    public void testCreateBeanObject(){

//        实例化Spring容器示例
        String conf = "C:\\apache-tomcat-9.0.1\\webapps\\ROOT\\WEB-INF\\applicationContext.xml";
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(conf);
//        1.用构造器莱实例化的方式
//        Calendar calendar1 = (Calendar) applicationContext.getBean("calendarObj1");  //方式1
        Calendar calendar1 = applicationContext.getBean("calendarObj1", Calendar.class);  //方式2
        System.out.println("calendar1:" + calendar1);

//        2.使用静态工厂方法实例化的方式
//        利用Spring调用构造器Calendar的静态工厂方法getInstance（）创建Calendar实例。
        Calendar calendar2 = applicationContext.getBean("calendarObj2", Calendar.class);
        System.out.println("calendar2:" + calendar2);

//        3.使用实例工厂方法实例化的方式
//        利用Spring创建GregorianCalendar对象作为工厂，调用getTime（）方法创建Date类型对象实例。
        Date date = applicationContext.getBean("dateObj", Date.class);
        System.out.println("date:" + date);
    }

}

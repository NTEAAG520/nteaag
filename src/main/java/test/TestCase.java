package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
    /**
     * 测试实例化Spring容器实例
     */
    @Test
    public void teatInitContext(){
        String conf = "applicationContext.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(conf);
        System.out.println(applicationContext);

    }
}

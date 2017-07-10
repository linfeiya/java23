import com.kaishengit.Application;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */

public class AsperAdviceTest {
    @Test
    public void adviceTest() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        /*ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");*/

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

}

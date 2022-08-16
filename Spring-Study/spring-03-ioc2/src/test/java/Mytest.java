import com.hubin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Mytest {
    @Test
    public  void test1() {
        ApplicationContext context=new ClassPathXmlApplicationContext("AppliconContext.xml");
        User user=(User)context.getBean("User");
        user.show();
    }
}

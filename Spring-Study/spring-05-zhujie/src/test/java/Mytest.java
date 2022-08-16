import com.hubin.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public  void main() {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("People");
        people.getDog().Shout();
        people.getCat().Shout();

    }
}

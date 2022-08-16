import com.hubin.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public  void main() {
        ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student  student=(Student) context.getBean("Student") ;
        System.out.println(student.toString());
    }
}

import com.progressoft.induction.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by khaled on 1/18/17.
 */
public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/beans.xml");
        EmployeeDao employeeDao = applicationContext.getBean("employeeDao", EmployeeDao.class);
        System.out.println("dao is got ");
    }

}

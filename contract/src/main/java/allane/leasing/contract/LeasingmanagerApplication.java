package allane.leasing.contract;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.repo.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class LeasingmanagerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LeasingmanagerApplication.class, args);
//        test(context);
    }

    static void test(ApplicationContext con) {
        CustomerRepository customerRepository = con.getBean(CustomerRepository.class);

        Customer customer = new Customer();
        customer.setFirstName("Ram");
        customer.setLastName("Shyam");
        customer.setBirthDate(new Date(122, 11, 24));
        customer.setId("2");
        Object save = customerRepository.save(customer);
        System.out.println(save);
    }
}

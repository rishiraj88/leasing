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
    }
}

package rrlane.leasing.contract;

import rrlane.leasing.contract.entity.Customer;
import rrlane.leasing.contract.repo.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

/**
 * LeasingmanagerApplication. Capitalization scheme is by intention.
 */
@SpringBootApplication
@EnableJpaRepositories
public class LeasingmanagerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LeasingmanagerApplication.class, args);
    }
}

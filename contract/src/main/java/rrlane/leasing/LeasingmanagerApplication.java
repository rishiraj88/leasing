package rrlane.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * LeasingmanagerApplication: Capitalization scheme is set so by deliberation to emphasize:
 * Leasingmanager + Application.
 */
@SpringBootApplication(scanBasePackages = "rrlane.leasing")
@EnableJpaRepositories
public class LeasingmanagerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LeasingmanagerApplication.class, args);
    }
}

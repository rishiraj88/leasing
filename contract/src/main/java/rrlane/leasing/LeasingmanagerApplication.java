package rrlane.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * LeasingmanagerApplication: Capitalization scheme is set so by deliberation to emphasize:
 * Leasingmanager + Application.
 */
@SpringBootApplication(scanBasePackages = "rrlane.leasing")
@EnableJpaRepositories
@FlywayDataSource
public class LeasingmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeasingmanagerApplication.class, args);
    }
}

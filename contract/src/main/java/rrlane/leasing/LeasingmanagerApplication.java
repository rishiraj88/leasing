package rrlane.leasing;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LeasingmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeasingmanagerApplication.class, args);
    }
}

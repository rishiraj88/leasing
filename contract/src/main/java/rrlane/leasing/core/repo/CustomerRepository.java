package rrlane.leasing.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rrlane.leasing.core.entity.Customer;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByName(String name);

    List<Customer> findByNameAndBirthDate(String name, LocalDate bdate);

    List<Customer> findByBirthDate(LocalDate bdate);
}
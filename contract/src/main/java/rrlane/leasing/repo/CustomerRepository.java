package rrlane.leasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rrlane.leasing.entity.Customer;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    List<Customer> findByName(String name);
    List<Customer> findByNameAndBirthDate(String name, LocalDateTime bdate);
    List<Customer> findByBirthDate(LocalDateTime bdate);

}

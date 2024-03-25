package rrlane.leasing.contract.repo;

import rrlane.leasing.contract.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    List<Customer> findByName(String name);
    List<Customer> findByNameAndBirthDate(String name, Date bdate);
}

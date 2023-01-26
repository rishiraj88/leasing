package allane.leasing.contract.repo;

import allane.leasing.contract.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    List<Customer> findByFirstNameAndLastName(String fname, String lname);
    List<Customer> findByFirstNameAndLastNameAndBirthDate(String fname, String lname, Date bdate);
}

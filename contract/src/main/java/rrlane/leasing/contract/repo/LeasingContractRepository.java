package rrlane.leasing.contract.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.core.entity.Customer;
import rrlane.leasing.core.entity.Vehicle;

import java.util.List;

@Repository
public interface LeasingContractRepository extends JpaRepository<LeasingContract, String> {
    public List<LeasingContract> findByContractNumberAndMonthlyRate(Integer contractNumber, Double monthlyRate); // planned for use

    public List<LeasingContract> findByContractNumber(Integer contractNumber);

    public LeasingContract findByVehicle(Vehicle vehicle);

    public List<LeasingContract> findByCustomer(Customer customer);

    public List<LeasingContract> findByMonthlyRate(Double monthlyRate);

    @Query("SELECT lc from LeasingContract lc WHERE lc.contractNumber=:contractNumber AND " + " lc.monthlyRate=:monthlyRate AND lc.vehicle=:vehicle AND lc.customer=:customer")
    public LeasingContract findByAllCriteria(Integer contractNumber, Double monthlyRate, Vehicle vehicle, Customer customer);
}

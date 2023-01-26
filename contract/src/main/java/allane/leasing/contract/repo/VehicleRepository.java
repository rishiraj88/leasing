package allane.leasing.contract.repo;

import allane.leasing.contract.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle,String> {
    public List<Vehicle> findByBrandAndModelAndModelYear(String brand, String model, String  year);
    public List<Vehicle> findByBrandAndModelAndModelYearAndVin(String brand, String model, String  year, String vin);

    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByModel(String modelName);
    List<Vehicle> findByModelYear(String modelYear);
    List<Vehicle> findByVin(String vin);
}

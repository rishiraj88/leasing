package rrlane.leasing.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rrlane.leasing.core.entity.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public List<Vehicle> findByBrandAndModelAndModelYear(String brand, String model, String year);

    public List<Vehicle> findByBrandAndModelAndModelYearAndVin(String brand, String model, String year, String vin);// planned for use

    List<Vehicle> findByBrand(String brand);

    List<Vehicle> findByModel(String modelName);

    List<Vehicle> findByModelYear(String modelYear);

    List<Vehicle> findByVin(String vin);
}
package digifico.test.geolocation.db.repository;

import digifico.test.geolocation.db.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Modifying
    @Query("update Vehicle v set v.longitude = ?2, v.latitude = ?3 where v.id = ?1")
    void setLocation(long id, double longitude, double latitude);

    List<Vehicle> findVehiclesByLongitudeBetweenAndLatitudeBetween(double longitudeMin, double longitudeMax, double latitudeMin, double latitudeMax);
}


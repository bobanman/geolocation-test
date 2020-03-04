package digifico.test.geolocation.service;

import digifico.test.geolocation.db.entity.Vehicle;
import digifico.test.geolocation.db.repository.VehicleRepository;
import digifico.test.geolocation.dto.LocationDTO;
import digifico.test.geolocation.dto.RectangleCoordinatesDTO;
import digifico.test.geolocation.dto.VehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Transactional
    public void setLocation(long id, LocationDTO location) {
        vehicleRepository.setLocation(id, location.getLongitude(), location.getLatitude());
    }

    public List<VehicleDTO> getVehicles(RectangleCoordinatesDTO rectangleCoordinates) {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByLongitudeBetweenAndLatitudeBetween(
            Math.min(rectangleCoordinates.getLeftTop().getLongitude(), rectangleCoordinates.getRightBottom().getLongitude()),
            Math.max(rectangleCoordinates.getLeftTop().getLongitude(), rectangleCoordinates.getRightBottom().getLongitude()),
            Math.min(rectangleCoordinates.getLeftTop().getLatitude(), rectangleCoordinates.getRightBottom().getLatitude()),
            Math.max(rectangleCoordinates.getLeftTop().getLatitude(), rectangleCoordinates.getRightBottom().getLatitude()));

        return vehicles.stream()
                .map(VehicleDTO::fromVehicle)
                .collect(Collectors.toList());
    }
}
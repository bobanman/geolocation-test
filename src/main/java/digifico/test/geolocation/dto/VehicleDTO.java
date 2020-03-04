package digifico.test.geolocation.dto;

import digifico.test.geolocation.db.entity.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleDTO {
    private String number;
    private String name;
    private LocationDTO currentLocation;

    public static VehicleDTO fromVehicle(Vehicle vehicle) {
        return VehicleDTO.builder()
                .number(vehicle.getNumber())
                .name(vehicle.getName())
                .currentLocation(new LocationDTO(vehicle.getLongitude(), vehicle.getLatitude()))
                .build();
    }
}

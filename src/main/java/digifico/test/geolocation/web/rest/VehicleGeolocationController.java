package digifico.test.geolocation.web.rest;

import digifico.test.geolocation.dto.LocationDTO;
import digifico.test.geolocation.dto.RectangleCoordinatesDTO;
import digifico.test.geolocation.dto.VehicleDTO;
import digifico.test.geolocation.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VehicleGeolocationController.URI)
@RequiredArgsConstructor
public class VehicleGeolocationController {

    public static final String URI = "/vehicles";

    private final VehicleService vehicleService;

    @PutMapping("/{id}")
    public void setVehicleLocation(@PathVariable("id") long id,
                                   @RequestBody @Valid LocationDTO locationDTO) {
        vehicleService.setLocation(id, locationDTO);
    }

    @GetMapping
    public List<VehicleDTO> getVehicles(@RequestBody @Valid RectangleCoordinatesDTO rectangleCoordinates) {
        return vehicleService.getVehicles(rectangleCoordinates);
    }

}

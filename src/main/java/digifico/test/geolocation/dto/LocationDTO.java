package digifico.test.geolocation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class LocationDTO {

    @NotNull
    @JsonProperty("longitude")
    private final double longitude;

    @NotNull
    @JsonProperty("latitude")
    private final double latitude;

    @JsonCreator
    public LocationDTO(@JsonProperty("longitude") double longitude, @JsonProperty("latitude") double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

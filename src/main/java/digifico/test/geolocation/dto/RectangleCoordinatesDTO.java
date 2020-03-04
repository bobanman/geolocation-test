package digifico.test.geolocation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RectangleCoordinatesDTO {

    @NotNull
    @JsonProperty("leftTop")
    private final LocationDTO leftTop;

    @NotNull
    @JsonProperty("rightBottom")
    private final LocationDTO rightBottom;

    @JsonCreator
    public RectangleCoordinatesDTO(@JsonProperty("leftTop") LocationDTO leftTop, @JsonProperty("rightBottom") LocationDTO rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }
}

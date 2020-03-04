package digifico.test.geolocation.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Builder
@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "number", nullable = false)
    private String number;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "longitude", nullable = false)
    private double longitude;

    @NotNull
    @Column(name = "latitude", nullable = false)
    private double latitude;
}

package NMSTechVenturas.example.NMSTechVenturas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "devices")
public class DeviceEntity {

    //Creation of Device Entity
    public enum DeviceStatus {
        ONLINE,
        OFFLINE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "vendor cannot be a blank")
    @NotBlank(message = "vendor cannot be a blank")
    private String vendor;

    @NotNull(message = "dateCreated cannot be a blank")
    @NotBlank(message = "dateCreated cannot be a blank")
    private String dateCreated;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    @ManyToOne
    @JoinColumn(name = "gateway_Id")
    private GatewayEntity gateway;

}

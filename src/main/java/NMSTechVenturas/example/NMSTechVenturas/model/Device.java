package NMSTechVenturas.example.NMSTechVenturas.model;

import NMSTechVenturas.example.NMSTechVenturas.entity.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    //Creation of Device Model
    Long id;
    private String vendor;
    private String dateCreated;
    private DeviceEntity.DeviceStatus status;
    private Long gatewayId;
}

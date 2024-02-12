package NMSTechVenturas.example.NMSTechVenturas.model;

import NMSTechVenturas.example.NMSTechVenturas.entity.DeviceEntity;
import NMSTechVenturas.example.NMSTechVenturas.entity.GatewayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    Long id;
    private String vendor;
    private String dateCreated;
    private DeviceEntity.DeviceStatus status;
}

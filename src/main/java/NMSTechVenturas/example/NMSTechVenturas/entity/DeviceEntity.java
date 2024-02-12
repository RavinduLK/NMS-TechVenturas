package NMSTechVenturas.example.NMSTechVenturas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "devices")
public class DeviceEntity {

    public enum DeviceStatus {
        ONLINE,
        OFFLINE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String vendor;
    private String dateCreated;
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

}

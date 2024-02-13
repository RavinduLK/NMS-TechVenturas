package NMSTechVenturas.example.NMSTechVenturas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "gateways")
public class GatewayEntity {

    //Creation of Gateway Entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String serialNumber;
    private String name;

    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$", message = "Invalid IPv4 Address")
    private String ipv4Address;

    @OneToMany(mappedBy = "gateway", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 10, message = "No more than 10 devices are allowed for a gateway")
    private List<DeviceEntity> devices = new ArrayList<>();

}

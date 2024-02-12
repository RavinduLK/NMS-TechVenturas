package NMSTechVenturas.example.NMSTechVenturas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {
    private long id;
    private String serialNumber;
    private String name;
    private String ipv4Address;
}

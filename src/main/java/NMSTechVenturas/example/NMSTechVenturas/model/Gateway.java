package NMSTechVenturas.example.NMSTechVenturas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {

    //Creation of Gateway Model
    private long id;
    private String serialNumber;
    private String name;
    private String ipv4Address;
    private List<Device> devices;

}

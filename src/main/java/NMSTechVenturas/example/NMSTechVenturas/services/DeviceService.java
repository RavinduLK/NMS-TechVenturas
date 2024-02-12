package NMSTechVenturas.example.NMSTechVenturas.services;

import NMSTechVenturas.example.NMSTechVenturas.model.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    Device createDevice(Device device);

    List<Device> getAllDevices();

    boolean deleteDevice(Long id);

    Device getDeviceById(Long id);

    Device updateDevice(Long id, Device device);

    Device vendorUpdateDevice(Long id, Map<String, Object> updates);
}

package NMSTechVenturas.example.NMSTechVenturas.services;

import NMSTechVenturas.example.NMSTechVenturas.entity.DeviceEntity;
import NMSTechVenturas.example.NMSTechVenturas.entity.GatewayEntity;
import NMSTechVenturas.example.NMSTechVenturas.model.Device;
import NMSTechVenturas.example.NMSTechVenturas.repository.DeviceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device createDevice(Device device) {
        DeviceEntity deviceEntity = new DeviceEntity();
        BeanUtils.copyProperties(device,deviceEntity);
        deviceRepository.save(deviceEntity);
        return device;
    }

    @Override
    public List<Device> getAllDevices() {
        List<DeviceEntity> deviceEntities
                = deviceRepository.findAll();

        List<Device> devices = deviceEntities
                .stream()
                .map(dev -> new Device(
                        dev.getId(),
                        dev.getVendor(),
                        dev.getDateCreated(),
                        dev.getStatus()))
                .collect(Collectors.toList());
        return devices;
    }

    @Override
    public boolean deleteDevice(Long id) {
        DeviceEntity device = deviceRepository.findById(id).get();
        deviceRepository.delete(device);
        return true;
    }

    @Override
    public Device getDeviceById(Long id) {
        DeviceEntity deviceEntity
                = deviceRepository.findById(id).get();
        Device device = new Device();
        BeanUtils.copyProperties(deviceEntity,device);
        return device;
    }

    @Override
    public Device updateDevice(Long id, Device device) {
        DeviceEntity deviceEntity
                = deviceRepository.findById(id).get();
        deviceEntity.setVendor(device.getVendor());
        deviceEntity.setDateCreated(device.getDateCreated());
        deviceEntity.setStatus(device.getStatus());
        deviceRepository.save(deviceEntity);
        return device;
    }

    @Override
    public Device vendorUpdateDevice(Long id, Map<String, Object> updates) {
        DeviceEntity deviceEntity
                = deviceRepository.findById(id).get();

        if (updates.containsKey("vendor")) {
            deviceEntity.setVendor((String) updates.get("vendor"));
        }

        deviceRepository.save(deviceEntity);

        Device updatedDevice = new Device();
        BeanUtils.copyProperties(deviceEntity,updatedDevice);
        return updatedDevice;
    }
}

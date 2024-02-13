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

    //Implementation of create Device method
    @Override
    public Device createDevice(Device device) {
        DeviceEntity deviceEntity = new DeviceEntity();
        BeanUtils.copyProperties(device,deviceEntity);

        if (device.getGatewayId() != null) {
            GatewayEntity gatewayEntity = new GatewayEntity();
            gatewayEntity.setId(device.getGatewayId());
            deviceEntity.setGateway(gatewayEntity);
        }

        deviceRepository.save(deviceEntity);
        return device;
    }

    //Implementation of get all devices method
    @Override
    public List<Device> getAllDevices() {
        List<DeviceEntity> deviceEntities
                = deviceRepository.findAll();

        List<Device> devices = deviceEntities
                .stream()
                .map(dev -> {
                    Long gatewayId = dev.getGateway() != null ? dev.getGateway().getId() : null;
                    return new Device(
                            dev.getId(),
                            dev.getVendor(),
                            dev.getDateCreated(),
                            dev.getStatus(),
                            gatewayId);
                })
                .collect(Collectors.toList());
        return devices;
    }

    //Implementation of delete device method
    @Override
    public boolean deleteDevice(Long id) {
        DeviceEntity device = deviceRepository.findById(id).get();
        deviceRepository.delete(device);
        return true;
    }

    //Implementation of get device by Id method
    @Override
    public Device getDeviceById(Long id) {
        DeviceEntity deviceEntity
                = deviceRepository.findById(id).get();
        Device device = new Device();
        BeanUtils.copyProperties(deviceEntity,device);
        return device;
    }

    //Implementation of update Device method
    @Override
    public Device updateDevice(Long id, Device device) {
        DeviceEntity deviceEntity
                = deviceRepository.findById(id).get();
        deviceEntity.setVendor(device.getVendor());
        deviceEntity.setDateCreated(device.getDateCreated());
        deviceEntity.setStatus(device.getStatus());

        if (device.getGatewayId() != null) {
            GatewayEntity gatewayEntity = new GatewayEntity();
            gatewayEntity.setId(device.getGatewayId());
            deviceEntity.setGateway(gatewayEntity);
        }

        deviceRepository.save(deviceEntity);
        return device;
    }

    //Implementation of vendor update Device method
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

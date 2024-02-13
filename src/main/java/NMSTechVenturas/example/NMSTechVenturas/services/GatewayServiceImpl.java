package NMSTechVenturas.example.NMSTechVenturas.services;

import NMSTechVenturas.example.NMSTechVenturas.entity.GatewayEntity;
import NMSTechVenturas.example.NMSTechVenturas.model.Device;
import NMSTechVenturas.example.NMSTechVenturas.model.Gateway;
import NMSTechVenturas.example.NMSTechVenturas.repository.GatewayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GatewayServiceImpl implements GatewayService {
    private GatewayRepository gatewayRepository;

    public GatewayServiceImpl(GatewayRepository gatewayRepository) {
        this.gatewayRepository = gatewayRepository;
    }

    //Implementation of create gateway method
    @Override
    public Gateway createGateway(Gateway gateway) {
        GatewayEntity gatewayEntity = new GatewayEntity();
        BeanUtils.copyProperties(gateway,gatewayEntity);
        gatewayRepository.save(gatewayEntity);
        return gateway;
    }

    //Implementation of get all gateways method
    @Override
    public List<Gateway> getAllGateways() {
        List<GatewayEntity> gatewayEntities = gatewayRepository.findAll();
        List<Gateway> gateways = gatewayEntities.stream()
                .map(gate -> new Gateway(
                        gate.getId(),
                        gate.getSerialNumber(),
                        gate.getName(),
                        gate.getIpv4Address(),
                        gate.getDevices().stream()
                                .map(deviceEntity -> new Device(
                                        deviceEntity.getId(),
                                        deviceEntity.getVendor(),
                                        deviceEntity.getDateCreated(),
                                        deviceEntity.getStatus(),
                                        gate.getId()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
        return gateways;
    }

    //Implementation of delete gateway method
    @Override
    public boolean deleteGateway(Long id) {
        GatewayEntity gateway = gatewayRepository.findById(id).get();
        gatewayRepository.delete(gateway);
        return true;
    }

    //Implementation of get gateway by Id method
    @Override
    public Gateway getGatewayById(Long id) {
        GatewayEntity gatewayEntity
                = gatewayRepository.findById(id).get();
        Gateway gateway = new Gateway();
        BeanUtils.copyProperties(gatewayEntity, gateway);
        return gateway;
    }

    //Implementation of update Gateway method
    @Override
    public Gateway updateGateway(Long id, Gateway gateway) {
        GatewayEntity gatewayEntity
                = gatewayRepository.findById(id).get();
        gatewayEntity.setSerialNumber(gateway.getSerialNumber());
        gatewayEntity.setName(gateway.getName());
        gatewayEntity.setIpv4Address(gateway.getIpv4Address());
        gatewayRepository.save(gatewayEntity);
        return gateway;
    }

    //Implementation of name update Gateway method
    @Override
    public Gateway nameUpdateGateway(Long id, Map<String, Object> updates) {
        GatewayEntity gatewayEntity = gatewayRepository.findById(id).get();
        if (updates.containsKey("name")) {
            gatewayEntity.setName((String) updates.get("name"));
        }

        gatewayRepository.save(gatewayEntity);

        Gateway updatedGateway = new Gateway();
        BeanUtils.copyProperties(gatewayEntity, updatedGateway);
        return updatedGateway;
    }

}

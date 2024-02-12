package NMSTechVenturas.example.NMSTechVenturas.services;

import NMSTechVenturas.example.NMSTechVenturas.entity.GatewayEntity;
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

    @Override
    public Gateway createGateway(Gateway gateway) {
        GatewayEntity gatewayEntity = new GatewayEntity();
        BeanUtils.copyProperties(gateway,gatewayEntity);
        gatewayRepository.save(gatewayEntity);
        return gateway;
    }

    @Override
    public List<Gateway> getAllGateways() {
        List<GatewayEntity> gatewayEntities
                =gatewayRepository.findAll();
        List<Gateway> gateways = gatewayEntities
                .stream()
                .map(gate -> new Gateway(
                        gate.getId(),
                        gate.getSerialNumber(),
                        gate.getName(),
                        gate.getIpv4Address()))
                .collect(Collectors.toList());
        return gateways;
    }

    @Override
    public boolean deleteGateway(Long id) {
        GatewayEntity gateway = gatewayRepository.findById(id).get();
        gatewayRepository.delete(gateway);
        return true;
    }

    @Override
    public Gateway getGatewayById(Long id) {
        GatewayEntity gatewayEntity
                = gatewayRepository.findById(id).get();
        Gateway gateway = new Gateway();
        BeanUtils.copyProperties(gatewayEntity, gateway);
        return gateway;
    }

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

package NMSTechVenturas.example.NMSTechVenturas.services;

import NMSTechVenturas.example.NMSTechVenturas.model.Gateway;

import java.util.List;
import java.util.Map;

public interface GatewayService {
    Gateway createGateway(Gateway gateway);

    List<Gateway> getAllGateways();

    boolean deleteGateway(Long id);

    Gateway getGatewayById(Long id);

    Gateway updateGateway(Long id, Gateway gateway);

    Gateway nameUpdateGateway(Long id, Map<String, Object> updates);
}

package NMSTechVenturas.example.NMSTechVenturas.repository;

import NMSTechVenturas.example.NMSTechVenturas.entity.GatewayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<GatewayEntity, Long> {
}

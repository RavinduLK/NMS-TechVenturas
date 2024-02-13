package NMSTechVenturas.example.NMSTechVenturas.repository;

import NMSTechVenturas.example.NMSTechVenturas.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creation of Device Repository
@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
}

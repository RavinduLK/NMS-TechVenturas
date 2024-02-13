package NMSTechVenturas.example.NMSTechVenturas.controller;

import NMSTechVenturas.example.NMSTechVenturas.model.Device;
import NMSTechVenturas.example.NMSTechVenturas.services.DeviceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //Creating the Device
    @PostMapping("/devices")
    public Device createDevice(@Valid @RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    //Retrieving all the Devices
    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    //Deleting the Devices
    @DeleteMapping("/devices/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteDevice(@PathVariable Long id) {
        boolean deleted = false;
        deleted = deviceService.deleteDevice(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    //Getting the Device by Id
    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = null;
        device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    //Updating the Device based on Id
    @PutMapping("/devices/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
        device = deviceService.updateDevice(id, device);
        return ResponseEntity.ok(device);
    }

    //Updating only the vendor of the Device : Assumption
    @PatchMapping("/devices/{id}")
    public ResponseEntity<Device> vendorUpdateDevice(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Device updatedDevice = deviceService.vendorUpdateDevice(id, updates);
        return ResponseEntity.ok(updatedDevice);
    }
}

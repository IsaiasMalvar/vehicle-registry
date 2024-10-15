package com.name.vehicleregistration.controller;
import com.name.vehicleregistration.controller.dtos.VehicleRequest;
import com.name.vehicleregistration.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleInfoById(@PathVariable Integer id) {

        try{
            return ResponseEntity.ok(vehicleService.getVehicleById(id));
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        try{
            return ResponseEntity.ok(vehicleService.saveVehicle(vehicleRequest));
        } catch ( Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable Integer id) {

        log.info("Deleting vehicle");
        try{
            vehicleService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<?> updateVehicleById(@PathVariable Integer id,@RequestBody VehicleRequest vehicleRequest) {
            try {
                return ResponseEntity.ok(vehicleService.updateById(id, vehicleRequest));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
    }
}

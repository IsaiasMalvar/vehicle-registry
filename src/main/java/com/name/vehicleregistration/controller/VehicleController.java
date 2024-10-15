package com.name.vehicleregistration.controller;
import com.name.vehicleregistration.controller.dtos.VehicleRequest;
import com.name.vehicleregistration.service.VehicleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@OpenAPIDefinition(info = @Info(title = "API de registro de vehículos", description = "API para gestionar correctamente operaciones CRUD con vehículos."))
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Tag(name = "get", description = "Método GET de la API de registro de vehículos.")
    @Operation(summary = "Obtener información del vehículo por ID",
            description = "Devuelve la información detallada de un vehículo basado en el ID proporcionado. Si el vehículo no existe, se retorna un error 404.")
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleInfoById(@PathVariable Integer id) {

        try{
            return ResponseEntity.ok(vehicleService.getVehicleById(id));
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @Tag(name="post", description = "Método POST de la API de registro de vehículos.")
    @Operation(summary = "Añadir un nuevo vehículo",
            description = "Agrega un nuevo vehículo a la base de datos utilizando la información proporcionada en el cuerpo de la solicitud. Si ocurre un error, se retorna código 400.")
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        try{
            return ResponseEntity.ok(vehicleService.saveVehicle(vehicleRequest));
        } catch ( Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Tag(name = "delete", description = "Método DELETE de la API de registro de vehículos.")
    @Operation(summary = "Eliminar un vehículo por ID",
            description = "Elimina un vehículo de la base de datos basado en el ID proporcionado. Si el vehículo no se encuentra, se retorna código 404.")
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

    @Tag(name = "put", description = "Método PUT de la API de registro de vehículos.")
    @PutMapping("/vehicles/{id}")
    @Operation(summary = "Actualizar un vehículo por ID",
            description = "Actualiza la información de un vehículo en la base de datos utilizando el ID proporcionado y la información en el cuerpo de la solicitud. Si el vehículo no se encuentra, se retorna código 404.")
    public ResponseEntity<?> updateVehicleById(@PathVariable Integer id,@RequestBody VehicleRequest vehicleRequest) {
            try {
                return ResponseEntity.ok(vehicleService.updateById(id, vehicleRequest));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
    }
}

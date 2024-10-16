package com.name.vehicleregistration.repository.impl;

import com.name.vehicleregistration.controller.dtos.Vehicle;
import com.name.vehicleregistration.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    List<Vehicle> vehiclesList = new ArrayList<>();

    public Optional<Vehicle> getVehicleById(Integer id) {
        return Optional.of(vehiclesList.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().get());
    }

    public Optional<Vehicle> saveVehicle(Vehicle vehicle) {

        if (vehiclesList.stream().anyMatch(v -> v.getId().equals(vehicle.getId()))) {
            return Optional.empty();
        } else {
            vehiclesList.add(vehicle);
            return Optional.ofNullable(vehicle);
        }
    }

    public boolean deleteVehicleById(Integer id) {
        return vehiclesList.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    public Optional<Vehicle> updateVehicleById(Vehicle vehicle, Integer id) {
        if (getVehicleById(id).isEmpty()) {
            return Optional.empty();
        } else {
            deleteVehicleById(id);
            vehicle.setId(id);
            saveVehicle(vehicle);
            return Optional.of(vehicle);
        }
    }

}

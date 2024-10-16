package com.name.vehicleregistration.repository;


import com.name.vehicleregistration.controller.dtos.Vehicle;

import java.util.Optional;

public interface VehicleRepository {

    Optional<Vehicle> getVehicleById(Integer id);

    Optional<Vehicle> saveVehicle(Vehicle vehicle);

    boolean deleteVehicleById(Integer id);

    Optional<Vehicle> updateVehicleById(Vehicle vehicle, Integer id);
}

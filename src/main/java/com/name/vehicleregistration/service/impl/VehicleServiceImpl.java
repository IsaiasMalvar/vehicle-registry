package com.name.vehicleregistration.service.impl;

import com.name.vehicleregistration.controller.dtos.Vehicle;
import com.name.vehicleregistration.controller.dtos.VehicleRequest;
import com.name.vehicleregistration.controller.dtos.VehicleResponse;
import com.name.vehicleregistration.repository.VehicleRepository;
import com.name.vehicleregistration.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleResponse getVehicleById(Integer id) throws Exception {
        Vehicle vehicle = vehicleRepository.getVehicleById(id);
        return this.responseMapper(vehicle);
    }

    @Override
    public void deleteById(Integer id) throws Exception {

        boolean isDeleted = vehicleRepository.deleteVehicleById(id);
        if (!isDeleted) {
            throw new Exception();
        }
    }

    @Override
    public VehicleResponse updateById(Integer id, VehicleRequest vehicleRequest) throws Exception {
        Vehicle vehicle = vehicleRepository.updateVehicleById(requestMapper(vehicleRequest), id);
        if (vehicle == null) {
            throw new Exception();
        }
        return responseMapper(vehicle);

    }

    @Override
    public VehicleResponse saveVehicle(VehicleRequest vehicleRequest) throws Exception {
        Vehicle vehicle = vehicleRepository.saveVehicle(requestMapper(vehicleRequest));
        if (vehicle == null) {
            throw new Exception("This vehicle has already been registered.");
        }
        return responseMapper(vehicle);
    }

    private VehicleResponse responseMapper(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();

        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setBrand(vehicle.getBrand());
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setMileage(vehicle.getMileage());
        vehicleResponse.setPrice(vehicle.getPrice());
        vehicleResponse.setYear(vehicle.getYear());
        vehicleResponse.setDescription(vehicle.getDescription());
        vehicleResponse.setColour(vehicle.getColour());
        vehicleResponse.setFuelType(vehicle.getFuelType());
        vehicleResponse.setNumDoors(vehicle.getNumDoors());

        return vehicleResponse;
    }

    private Vehicle requestMapper(VehicleRequest request) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(request.getId());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setMileage(request.getMileage());
        vehicle.setPrice(request.getPrice());
        vehicle.setYear(request.getYear());
        vehicle.setDescription(request.getDescription());
        vehicle.setColour(request.getColour());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setNumDoors(request.getNumDoors());

        return vehicle;
    }
}

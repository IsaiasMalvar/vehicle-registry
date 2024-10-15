package com.name.vehicleregistration.service;

import com.name.vehicleregistration.controller.dtos.VehicleRequest;
import com.name.vehicleregistration.controller.dtos.VehicleResponse;

public interface VehicleService {

    VehicleResponse getVehicleById(Integer id) throws Exception;

    void deleteById(Integer id) throws Exception;

    VehicleResponse updateById(Integer id, VehicleRequest vehicleRequest) throws Exception;

    VehicleResponse saveVehicle(VehicleRequest vehicleRequest) throws Exception;
}

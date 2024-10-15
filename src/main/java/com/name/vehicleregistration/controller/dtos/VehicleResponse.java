package com.name.vehicleregistration.controller.dtos;

import lombok.Data;

@Data
public class VehicleResponse {

    private Integer id;
    private String brand;
    private String model;
    private Integer mileage;
    private Double price;
    private Integer year;
    private String description;
    private String colour;
    private String fuelType;
    private Integer numDoors;

}

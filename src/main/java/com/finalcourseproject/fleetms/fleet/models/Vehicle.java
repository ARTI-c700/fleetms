package com.finalcourseproject.fleetms.fleet.models;

import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.parameters.models.Location;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    private VehicleType vehicleType;
    private Integer vehicleTypeId;

    private String vehicleNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date acquisitionDate;
    private String description;

    private VehicleMake vehicleMake;
    private Integer vehicleMakeId;

    private String fuelCapacity;
    private String power;

    private VehicleStatus vehicleStatus;
    private Integer vehicleStatusId;

    private String netWeight;

    private VehicleModel vehicleModel;
    private Integer vehicleModelId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee inCharge;
    private Integer employeeId;

    private Location currentLocation;
    private Integer locationId;

    private String remarks;
}

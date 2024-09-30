package com.finalcourseproject.fleetms.fleet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.parameters.models.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name="vehicle_type_id", insertable=false, updatable=false)
    private VehicleType vehicleType;

    @Column(name = "vehicle_type_id")
    private Integer vehicleTypeId;

    private String vehicleNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date acquisitionDate;

    private String description;

    @ManyToOne
    @JoinColumn(name="vehicle_make_id", insertable=false, updatable=false)
    private VehicleMake vehicleMake;

    @Column(name = "vehicle_make_id")
    private Integer vehicleMakeId;

    private String power;
    private String fuelCapacity;

    @ManyToOne
    @JoinColumn(name="vehicle_status_id", insertable=false, updatable=false)
    private VehicleStatus vehicleStatus;

    @Column(name = "vehicle_status_id")
    private Integer vehicleStatusId;

    private String netWeight;

    @ManyToOne
    @JoinColumn(name="employee_id", insertable=false, updatable=false)
    private Employee inCharge;

    @Column(name = "employee_id")
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name="vehicle_model_id", insertable=false, updatable=false)
    private VehicleModel vehicleModel;

    @Column(name = "vehicle_model_id")
    private Integer vehicleModelId;

    @ManyToOne
    @JoinColumn(name="location_id", insertable=false, updatable=false)
    private Location currentLocation;

    @Column(name = "location_id")
    private Integer locationId;

    private String remarks;
}
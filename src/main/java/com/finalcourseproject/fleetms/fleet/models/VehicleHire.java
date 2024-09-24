package com.finalcourseproject.fleetms.fleet.models;

import com.finalcourseproject.fleetms.parameters.models.Client;
import com.finalcourseproject.fleetms.parameters.models.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VehicleHire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    private Vehicle vehicle;
    private Integer vehicleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;
    private String timeOut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;
    private String timeIn;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;
    private Integer locationId;

    private String price;
    private String remarks;
}

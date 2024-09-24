package com.finalcourseproject.fleetms.fleet.models;

import com.finalcourseproject.fleetms.parameters.models.CommonObject;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {
}

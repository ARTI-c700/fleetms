package com.finalcourseproject.fleetms.parameters.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String description;
	private String details;
	
	@ManyToOne
	@JoinColumn(name="country_id", insertable=false, updatable=false)
	private Country country;

	@Column(name = "country_id")
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="state_id", insertable=false, updatable=false)
	private State state;

	@Column(name = "state_id")
	private Integer stateId;
		
	private String city;
	private String address;			
}

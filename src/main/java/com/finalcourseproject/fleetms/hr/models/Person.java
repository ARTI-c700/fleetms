package com.finalcourseproject.fleetms.hr.models;

import com.finalcourseproject.fleetms.parameters.models.Country;
import com.finalcourseproject.fleetms.parameters.models.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String otherName;

	@Formula(value = " concat(firstname, ' ', lastname) ")
	private String fullName;

	private String title;
	private String initials;
	private String socialSecurityNumber;
	private String gender;
	private String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name="country_id", insertable=false, updatable=false)
	private Country country;
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="state_id", insertable=false, updatable=false)
	private State state;
	private Integer stateId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
}

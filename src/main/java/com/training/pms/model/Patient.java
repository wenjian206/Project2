package com.training.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {
	@Id
	private int patientId;
	
	private String name;
	private String email;
	private String password;
	private String city;
	private String symptom;
	private String doctorAssigned;
	private int billAmount;
	private int loginId;
}
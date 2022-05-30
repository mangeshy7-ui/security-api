package com.usd.security.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table
@Data
public class UserManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private String kyc;
	private String description;
	private String purchaseServicePlan;
	@Column(name = "createDateTime", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdON;
	@UpdateTimestamp
	private Date updatedOn;
	@ElementCollection
	private Set<String> roles;

}

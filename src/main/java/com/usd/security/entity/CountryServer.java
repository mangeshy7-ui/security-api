package com.usd.security.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class CountryServer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	private String banUnbanOpration;
	private String hosts;
	@ElementCollection
	private List<String> country;
	private String priority;
	@CreationTimestamp
	@Column(name = "createDateTime", nullable = false, updatable = false)
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updateOn;

}

package com.usd.security.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
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
public class Configuration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cnfId;
	private String type;
	private String name;
	private String completLogPath;
	@Column(name= "createDateTime", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private Date updatedOn;
}

package com.usd.security.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class FirewallRules {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String ip;
	private String type;
	private String source;
	private String destination;
	private String moveRules;
	@Column(name = "createDateTime", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;

}

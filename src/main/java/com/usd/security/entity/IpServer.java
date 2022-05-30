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
public class IpServer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ipServerId;
    private String ip;
    private String banUnban;
    private String subnet;
    private String priority;
    @CreationTimestamp
    @Column(name = "createDateTime", nullable = false, updatable = false)
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}

package com.nit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Doctor_Info")
@NoArgsConstructor
public class Doctor 
{
	//Data properties
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "DOC_SEQ",initialValue=10,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.AUTO)
      private int did;
	@Column(length=30)
      private String dname;
	@Column(length=30)
      private String specialization;
      private double fee;
  	@Column(length=30)
      private String qlfy;
  	
  	//Meta Data properties
  	@Version
  	private Integer updateCount;
  	@CreationTimestamp
  	@Column(updatable = false,insertable = true)
  	private LocalDateTime createdOn;
  	@UpdateTimestamp
  	@Column(updatable = true,insertable = false)
  	private LocalDateTime lastAccessOn;
  	@Column(length=30)
  	private String active_sw="active";
  	@Column(length=30)
    private String createdBy;
  	@Column(length=30)
     private String updatedBy;
  	
}

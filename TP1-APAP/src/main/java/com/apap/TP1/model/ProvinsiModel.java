package com.apap.TP1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="provinsi")
public class ProvinsiModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull
	@Size(max=255)
	@Column(name="nama", nullable=false)
	private String nama;
	
	@NotNull
	@Size(max=255)
	@Column(name="presentase_tunjuangan", nullable=false)
	private double presentase_tunjangan;
	
	
	
}

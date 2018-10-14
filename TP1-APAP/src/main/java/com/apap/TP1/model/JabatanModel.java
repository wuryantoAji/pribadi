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
@Table(name="jabatan")
public class JabatanModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@NotNull
	@Size(max=255)
	@Column(name="nama_jabatan", nullable=false)
	private String nama_jabatan;
	
	@NotNull
	@Size(max=255)
	@Column(name="deskripsi", nullable=false)
	private String deskripsi;
	
	@NotNull
	@Size(max=255)
	@Column(name="gaji_pokok", nullable=false)
	private double gaji_pokok;
}

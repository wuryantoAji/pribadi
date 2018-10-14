package com.apap.TP1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_jabatan", referencedColumnName="id",nullable=false)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private List<JabatanModel> jabatan;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pegawai", referencedColumnName="id",nullable=false)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private List<PegawaiModel> pegawai;
	
}

package com.jofre.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Escala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "DATE")
	private Date dataInicio;
	@Column(columnDefinition = "DATE")
	private Date dataFim;
	

	@OneToMany(mappedBy = "escala")
	private List<EscalaItem> dirigentes = new ArrayList<>();
	
		
	@OneToMany(mappedBy = "escala")
	private List<EscalaItem> pregadores = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public List<EscalaItem> getDirigentes() {
		return dirigentes;
	}
	public void setDirigentes(List<EscalaItem> dirigentes) {
		this.dirigentes = dirigentes;
	}
	public List<EscalaItem> getPregadores() {
		return pregadores;
	}
	public void setPregadores(List<EscalaItem> pregadores) {
		this.pregadores = pregadores;
	}
	@Override
	public String toString() {
		return "Escala [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", dirigentes=" + dirigentes
				+ ", pregadores=" + pregadores + "]";
	}
		
}

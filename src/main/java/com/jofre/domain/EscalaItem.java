package com.jofre.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class EscalaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Selecione uma congregação.")
	@ManyToOne
	@JoinColumn(name= "id_escala")
	private Escala escala;
	
	@ManyToOne
	@JoinColumn(name= "id_ponto_pregacao")
	private PontoPregacao prontoPregacao;
	
	@ManyToOne
	@JoinColumn(name= "id_pregador")
	private Obreiro pregador;
	
	@ManyToOne
	@JoinColumn(name= "id_dirigente")
	private Obreiro dirigente;
	
	@Column(columnDefinition = "DATE")
	private Date dataEscala;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public PontoPregacao getProntoPregacao() {
		return prontoPregacao;
	}

	public void setProntoPregacao(PontoPregacao prontoPregacao) {
		this.prontoPregacao = prontoPregacao;
	}

	public Obreiro getPregador() {
		return pregador;
	}

	public void setPregador(Obreiro pregador) {
		this.pregador = pregador;
	}

	public Obreiro getDirigente() {
		return dirigente;
	}

	public void setDirigente(Obreiro dirigente) {
		this.dirigente = dirigente;
	}

	public Date getDataEscala() {
		return dataEscala;
	}

	public void setDataEscala(Date dataEscala) {
		this.dataEscala = dataEscala;
	}

	@Override
	public String toString() {
		return "EscalaItem [id=" + id + ", escala=" + escala + ", prontoPregacao=" + prontoPregacao + ", pregador="
				+ pregador + ", dirigente=" + dirigente + ", dataEscala=" + dataEscala + "]";
	}
	
}

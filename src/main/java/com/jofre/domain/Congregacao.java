package com.jofre.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Congregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe o nome da congregação.")
	@Size(min = 3, max = 60, message = "O nome da congregação deve conter entre {min} e {max} caracteres.")
	@Column(nullable =  false, length = 60, unique = true)
	private String nome;

	@OneToMany(mappedBy = "congregacao")
	private List<PontoPregacao> pontosPregacao = new ArrayList<>();
	
	@OneToMany(mappedBy = "congregacao")
	private List<Obreiro> obreiros = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PontoPregacao> getPontosPregacao() {
		return pontosPregacao;
	}

	public void setPontosPregacao(List<PontoPregacao> pontosPregacao) {
		this.pontosPregacao = pontosPregacao;
	}

	public List<Obreiro> getObreiros() {
		return obreiros;
	}

	public void setObreiros(List<Obreiro> obreiros) {
		this.obreiros = obreiros;
	}

	
}



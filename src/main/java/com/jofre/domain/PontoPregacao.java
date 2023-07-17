package com.jofre.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class PontoPregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe o nome do ponto de pregação.")
	@Size(min = 3, max = 60, message = "A descrição da congregação deve conter entre {min} e {max} caracteres.")
	@Column(nullable =  false, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione uma congregação.")
	@ManyToOne
	@JoinColumn(name= "id_congregacao")
	private Congregacao congregacao;
	
	@NotNull(message = "Informe o dia do culto.")
	private Integer diaCulto;

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

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Integer getDiaCulto() {
		return diaCulto;
	}

	public void setDiaCulto(Integer diaCulto) {
		this.diaCulto = diaCulto;
	}

	
}

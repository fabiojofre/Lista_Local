package com.jofre.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class Obreiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="Informe o nome do Obreiro.")
	@Size(min = 10, max = 60, message = "o nome do obreiro deve conter entre {min} e {max} caracteres.")
	@Column(nullable =  false, length = 60)
	private String nome;
	
	@Column(nullable =  false)
	private Long cartaoMembro;
	
	private Boolean bloqueado;
	
	@Column(length = 10)
	private String disponiblidade;
	
	@NotBlank(message ="Informe o telefone com Whatsapp do Obreiro.")
	private String whatsapp;
	private Boolean trabalhoIntermitente;
	private Boolean trabalhoNoturno;

	private Integer escalaIntermitente;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(columnDefinition = "DATE")
	private Date dataUltimaEscala;
	
	
	private Integer tipoObreiro;
	
	private String diasDisponivel;
	
	@NotNull(message = "Selecione uma congregação.")
	@ManyToOne
	@JoinColumn(name= "id_congregacao")
	private Congregacao congregacao;
	
	private Boolean eDomingo;
	private Boolean eSegunda;
	private Boolean eTerca;
	private Boolean eQuarta;
	private Boolean eQuinta;
	private Boolean eSexta;
	private Boolean eSabado;
	
	
	

	public Boolean geteDomingo() {
		return eDomingo;
	}

	public void seteDomingo(Boolean eDomingo) {
		this.eDomingo = eDomingo;
	}

	public Boolean geteSegunda() {
		return eSegunda;
	}

	public void seteSegunda(Boolean eSegunda) {
		this.eSegunda = eSegunda;
	}

	public Boolean geteTerca() {
		return eTerca;
	}

	public void seteTerca(Boolean eTerca) {
		this.eTerca = eTerca;
	}

	public Boolean geteQuarta() {
		return eQuarta;
	}

	public void seteQuarta(Boolean eQuarta) {
		this.eQuarta = eQuarta;
	}

	public Boolean geteQuinta() {
		return eQuinta;
	}

	public void seteQuinta(Boolean eQuinta) {
		this.eQuinta = eQuinta;
	}

	public Boolean geteSexta() {
		return eSexta;
	}

	public void seteSexta(Boolean eSexta) {
		this.eSexta = eSexta;
	}

	public Boolean geteSabado() {
		return eSabado;
	}

	public void seteSabado(Boolean eSabado) {
		this.eSabado = eSabado;
	}

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

	public String getWhatsapp() {
		return whatsapp;
	}

	
	
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Boolean getTrabalhoIntermitente() {
		return trabalhoIntermitente;
	}

	public void setTrabalhoIntermitente(Boolean trabalhoIntermitente) {
		this.trabalhoIntermitente = trabalhoIntermitente;
	}

	public Boolean getTrabalhoNoturno() {
		return trabalhoNoturno;
	}

	public void setTrabalhoNoturno(Boolean trabalhoNoturno) {
		this.trabalhoNoturno = trabalhoNoturno;
	}

	public Integer getEscalaIntermitente() {
		return escalaIntermitente;
	}

	public void setEscalaIntermitente(Integer escalaIntermitente) {
		this.escalaIntermitente = escalaIntermitente;
	}

	public Date getDataUltimaEscala() {
		return dataUltimaEscala;
	}

	public void setDataUltimaEscala(Date dataUltimaEscala) {
		this.dataUltimaEscala = dataUltimaEscala;
	}

	public Integer getTipoObreiro() {
		return tipoObreiro;
	}

	public void setTipoObreiro(Integer tipoObreiro) {
		this.tipoObreiro = tipoObreiro;
	}

	public String getDiasDisponivel() {
		return diasDisponivel;
	}

	public void setDiasDisponivel(String diasDisponivel) {
		this.diasDisponivel = diasDisponivel;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	
	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getDisponiblidade() {
		return disponiblidade;
	}

	public void setDisponiblidade(String disponiblidade) {
		this.disponiblidade = disponiblidade;
	}
	
	

	public Long getCartaoMembro() {
		return cartaoMembro;
	}

	public void setCartaoMembro(Long cartaoMembro) {
		this.cartaoMembro = cartaoMembro;
	}

	@Override
	public String toString() {
		return "Obreiro [id=" + id + ", nome=" + nome + ", cartaoMembro=" + cartaoMembro + ", trabalhoIntermitente="
				+ trabalhoIntermitente + ", escalaIntermitente=" + escalaIntermitente + ", dataUltimaEscala="
				+ dataUltimaEscala + ", eDomingo=" + eDomingo + ", eSegunda=" + eSegunda + ", eTerca=" + eTerca
				+ ", eQuarta=" + eQuarta + ", eQuinta=" + eQuinta + ", eSexta=" + eSexta + ", eSabado=" + eSabado + "]";
	}

}

package com.jofre.service;

import java.util.Date;
import java.util.List;

import com.jofre.domain.Obreiro;

public interface ObreiroService {

	void salvar(Obreiro obreiro);
	
	void editar(Obreiro obreiro);
	
	void excluir(Integer id);
	
	Obreiro buscarPorId(Integer id);
	
	List<Obreiro> buscarTodos();
	
	List<Obreiro>buscarPorNome(String nome);

	List<Obreiro> buscarPorCongregacao(Integer id);

	List<Obreiro>buscarPorCartao(Long cartaoMembro);

	List<Obreiro>buscarPorWhatsapp(String telefone);
	
	List<Obreiro> buscarPorData(Date data);

//	boolean congregacaoTemFuncionarios(Integer id);
	
}

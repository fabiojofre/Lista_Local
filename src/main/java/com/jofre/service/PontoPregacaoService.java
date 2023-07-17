package com.jofre.service;

import java.util.List;

import com.jofre.domain.PontoPregacao;

public interface PontoPregacaoService {

	void salvar(PontoPregacao pontoPregacao);
	
	void editar(PontoPregacao pontoPregacao);
	
	void excluir(Integer id);
	
	PontoPregacao buscarPorId(Integer id);
	
	List<PontoPregacao> buscarTodos();
	

//	boolean congregacaoTemFuncionarios(Integer id);
	
}

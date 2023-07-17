package com.jofre.service;

import java.util.List;

import com.jofre.domain.Congregacao;

public interface CongregacaoService {

	void salvar(Congregacao congregacao);
	
	void editar(Congregacao congregacao);
	
	void excluir(Integer id);
	
	Congregacao buscarPorId(Integer id);
	
	List<Congregacao> buscarTodos();
	

//	boolean congregacaoTemFuncionarios(Integer id);
	
}

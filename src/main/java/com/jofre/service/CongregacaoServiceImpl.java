package com.jofre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.dao.CongregacaoDao;
import com.jofre.domain.Congregacao;


@Service
@Transactional(readOnly = false)
public class CongregacaoServiceImpl implements CongregacaoService {

	@Autowired
	private CongregacaoDao dao;
	

	
	@Override
	public void salvar(Congregacao congregacao) {
		dao.save(congregacao);
		
	}

	@Override
	public void editar(Congregacao congregacao) {
		dao.update(congregacao);
		
	}

	@Override
	public void excluir(Integer id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Congregacao buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Congregacao> buscarTodos() {
		return dao.findAll();
	}

//	@Override
//	public boolean congregacaoTemFuncionarios(Integer id) {
//		if(buscarPorId(id).getPessoas().isEmpty()) {
//			return false;
//		}
//		return true;
//	}



}

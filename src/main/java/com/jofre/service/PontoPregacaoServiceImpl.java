package com.jofre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.dao.PontoPregacaoDao;
import com.jofre.domain.PontoPregacao;


@Service
@Transactional(readOnly = false)
public class PontoPregacaoServiceImpl implements PontoPregacaoService {

	@Autowired
	private PontoPregacaoDao dao;
	

	
	@Override
	public void salvar(PontoPregacao pontoPregacao) {
		dao.save(pontoPregacao);
		
	}

	@Override
	public void editar(PontoPregacao pontoPregacao) {
		dao.update(pontoPregacao);
		
	}

	@Override
	public void excluir(Integer id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public PontoPregacao buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<PontoPregacao> buscarTodos() {
		return dao.findAll();
	}

//	@Override
//	public boolean PontoPregacaoTemMovimentos(Integer id) {
//		if(buscarPorId(id).getPessoas().isEmpty()) {
//			return false;
//		}
//		return true;
//	}



}

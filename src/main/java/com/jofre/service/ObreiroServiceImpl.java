package com.jofre.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.dao.ObreiroDao;
import com.jofre.domain.Obreiro;


@Service
@Transactional(readOnly = false)
public class ObreiroServiceImpl implements ObreiroService {

	@Autowired
	private ObreiroDao dao;
	

	
	@Override
	public void salvar(Obreiro obreiro) {
		dao.save(obreiro);
		
	}

	@Override
	public void editar(Obreiro obreiro) {
		dao.update(obreiro);
		
	}

	@Override
	public void excluir(Integer id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Obreiro buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Obreiro> buscarTodos() {
		Calendar c = Calendar.getInstance();
		buscarPorData(c.getTime());
		return dao.findAll();
	}
	
	@Override @Transactional(readOnly = true)
	public List<Obreiro> buscarPorNome(String nome) {
	
		return dao.findByNome(nome);
	}

	@Override
	public List<Obreiro> buscarPorCongregacao(Integer id) {
		return dao.findByCongregacaoId(id);
	}

	@Override
	public List<Obreiro> buscarPorCartao(Long cartaoMembro) {
		return dao.findByCartao(cartaoMembro);
	}

	@Override
	public List<Obreiro> buscarPorWhatsapp(String telefone) {
		// TODO Auto-generated method stub
		return dao.findByWhatsapp(telefone);
	}
	
	@Override
	public List<Obreiro> buscarPorData(Date data) {
		// TODO Auto-generated method stub
		return dao.findByData(data);
	}

//	@Override
//	public boolean ObreiroTemMovimentos(Integer id) {
//		if(buscarPorId(id).getPessoas().isEmpty()) {
//			return false;
//		}
//		return true;
//	}



}

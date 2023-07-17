package com.jofre.dao;

import java.util.Date;
import java.util.List;

import com.jofre.domain.Obreiro;

public interface ObreiroDao {
	
void save(Obreiro pontoPregacao);
	
	void update(Obreiro pontoPregacao);
	
	void delete(Integer id);
	
	Obreiro findById(Integer id);
	
	List<Obreiro>findAll();
	
	List<Obreiro> findByNome(String nome);

	List<Obreiro> findByCongregacaoId(Integer id);

	List<Obreiro> findByCartao(Long cartaoMembro);

	List<Obreiro> findByWhatsapp(String telefone);
	
	List<Obreiro> findByData(Date data);
}

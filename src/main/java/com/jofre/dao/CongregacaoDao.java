package com.jofre.dao;

import java.util.List;

import com.jofre.domain.Congregacao;

public interface CongregacaoDao {
	
void save(Congregacao congregacao);
	
	void update(Congregacao congregaqcao);
	
	void delete(Integer id);
	
	Congregacao findById(Integer id);
	
	List<Congregacao>findAll();
	
}

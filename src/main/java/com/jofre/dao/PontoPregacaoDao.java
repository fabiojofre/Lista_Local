package com.jofre.dao;

import java.util.List;

import com.jofre.domain.PontoPregacao;

public interface PontoPregacaoDao {
	
void save(PontoPregacao pontoPregacao);
	
	void update(PontoPregacao pontoPregacao);
	
	void delete(Integer id);
	
	PontoPregacao findById(Integer id);
	
	List<PontoPregacao>findAll();
	
}

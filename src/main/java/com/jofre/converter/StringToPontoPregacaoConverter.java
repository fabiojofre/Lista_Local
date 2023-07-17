package com.jofre.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jofre.domain.PontoPregacao;
import com.jofre.service.PontoPregacaoService;

@Component
public class StringToPontoPregacaoConverter implements Converter<String, PontoPregacao> {

	@Autowired
	 private  PontoPregacaoService PontoPregacaoService;
	
	
	@Override
	public PontoPregacao convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return PontoPregacaoService.buscarPorId(id);
	}

}

package com.jofre.test;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.dao.ObreiroDao;
import com.jofre.dao.PontoPregacaoDao;
import com.jofre.domain.Obreiro;

@Service
public class DBService {
	 @Autowired
	 private ObreiroDao od;
	 
	 @Autowired
	 private PontoPregacaoDao ppd;
	 
	public void testaBase() {
		// instancio ccalendar
		Calendar c = Calendar.getInstance();
		
		//busco o obreiro 
		Obreiro ob1 =od.findById(2);
		c.setTime(ob1.getDataUltimaEscala());
		
		//vou pro abraço
		int mes = c.get(Calendar.MONTH);
		int diaDaSemana = c.get(Calendar.DAY_OF_WEEK);
		int diaDoMes = c.get(Calendar.DAY_OF_MONTH);
		
		
		
		System.out.println("Data e Hora atual: "+c.getTime());
		System.out.println(ob1.getDataUltimaEscala());
		System.out.println(Calendar.DATE);
		System.out.println(diaDaSemana);
	}

}

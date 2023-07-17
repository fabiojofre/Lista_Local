package com.jofre.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jofre.domain.Obreiro;

@Repository
public class ObreiroDaoImpl extends AbstractDao<Obreiro, Integer> implements ObreiroDao {
	
	
	public List<Obreiro> findByNome(String nome) {
		return createQuery("select p from Obreiro p where p.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Obreiro> findByCongregacaoId(Integer id) {
		
		return createQuery("select p from Obreiro p where p.congregacao.id = ?1", id);
	}

	@Override
	public List<Obreiro> findByCartao(Long cartaoMembro) {
	
		return createQuery("select p from Obreiro p where p.cartaoMembro = ?1", cartaoMembro);
	}

	@Override
	public List<Obreiro> findByWhatsapp(String whatsapp) {
		return createQuery("select p from Obreiro p where p.whatsapp = ?1", whatsapp);
	}
	@Override
	public List<Obreiro> findByData(Date data){
		Calendar c = Calendar.getInstance();
		
		c.setTime(data);
		c.add(Calendar.DATE, 1);// mocó pra acrecentar um dia na data vinda do parametro externo
		
		int diaDaSemana = c.get(Calendar.DAY_OF_WEEK); //extrai o dia da semana
		
		List<Obreiro>obreiros = null;
		
		obreiros = createQuery("select p from Obreiro p where p.bloqueado = false");

		List<Obreiro>disponiveis = new ArrayList<>();
		
		for(Obreiro ob : obreiros) {
			ob.toString();
			Calendar cOb = Calendar.getInstance();
			if(ob.getDataUltimaEscala()!=null) {
				cOb.setTime(ob.getDataUltimaEscala());
			}
			String diasLivres = "";
			
				if(ob.geteDomingo())diasLivres +="1";
				if(ob.geteSegunda()) diasLivres +="2";
				if(ob.geteTerca()) diasLivres +="3";
				if(ob.geteQuarta())	diasLivres +="4";
				if(ob.geteQuinta()) diasLivres +="5";
				if(ob.geteSexta()) 	diasLivres +="6";
				if(ob.geteSabado())	diasLivres +="7";
				
				if(diasLivres.contains(Integer.toString(diaDaSemana))&&
						((ob.getTrabalhoIntermitente()==false||
								ob.getDataUltimaEscala()==null)||
									ob.getEscalaIntermitente()==null)) {
					System.out.println(ob.toString());
					System.out.println("------------------------------");
					System.out.println(diasLivres.contains(Integer.toString(diaDaSemana)));
					System.out.println(diaDaSemana);
					System.out.println(diasLivres);
					disponiveis.add(ob);
					
				}else if(diasLivres.contains(Integer.toString(diaDaSemana))&& 
							ob.getTrabalhoIntermitente()&&
								ob.getDataUltimaEscala()!=null &&
									ob.getEscalaIntermitente()!=null &&
										!((c.get(Calendar.DAY_OF_YEAR) - cOb.get(Calendar.DAY_OF_YEAR)) % (ob.getEscalaIntermitente()+1)==0)){
					System.out.println(ob.toString());
					System.out.println("*******************************"+(c.get(Calendar.DAY_OF_YEAR)));
					disponiveis.add(ob);
				}
		}
		System.out.println(disponiveis.size()+" - "+c.getTime());
		
		return disponiveis;
	}
}

package com.jofre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.domain.Congregacao;
import com.jofre.domain.Obreiro;
import com.jofre.service.CongregacaoService;
import com.jofre.service.ObreiroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/trabalhadores")
public class TrabalhadorController {
	
	@Autowired
	private ObreiroService trabalhadorService;

	@Autowired
	private CongregacaoService congregacaoservice;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Obreiro obreiro) {
		return "trabalhador/cadastro";
	}

		
	@PostMapping("/salvar")
	public String salvar(@Valid Obreiro obreiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "trabalhador/cadastro";
		}
		else if(trabalhadorService.buscarPorCartao(obreiro.getCartaoMembro()).size()>1) {
			attr.addFlashAttribute("fail","Cadastro do obreiro já efetuado com o número do cartão de membro: "+obreiro.getCartaoMembro()+". ");
			return "redirect:/trabalhadores/cadastrar";
		}
		else {
		
		trabalhadorService.salvar(obreiro);
		attr.addFlashAttribute("success","Ponto de Pregação cadastrado com sucesso.");
		return "redirect:/trabalhadores/cadastrar";
		}
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("obreiro", trabalhadorService.buscarPorId(id));
		return "trabahador/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Obreiro obreiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "trabahador/cadastro";
		}
		
		trabalhadorService.editar(obreiro);
		attr.addFlashAttribute("success","Ponto de Pregação atualizado com sucesso.");
		return "redirect:/trabalhadores/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
//		if(trabalhadorService.ObreiroTemMovimentos(id)) {
//			attr.addFlashAttribute("fail","Ponto de Pregação não excluido. Existem movimentações vinculadas a ele.");
//		}else {
//			trabalhadorService.excluir(id);
//			attr.addFlashAttribute("success","Ponto de Pregação excluido com sucesso.");
//		}
		return "redirect:/trabalhadores/listar";
	}
	@ModelAttribute("congregacoes")
	public List<Congregacao>listaDeCongregacoes(){
		return congregacaoservice.buscarTodos();
	}


}

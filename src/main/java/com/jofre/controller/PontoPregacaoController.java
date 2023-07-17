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
import com.jofre.domain.PontoPregacao;
import com.jofre.service.CongregacaoService;
import com.jofre.service.PontoPregacaoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pontosPregacao")
public class PontoPregacaoController {
	
	@Autowired
	private PontoPregacaoService pontoPregacaoservice;

	@Autowired
	private CongregacaoService congregacaoservice;
	
	@GetMapping("/cadastrar")
	public String cadastrar(PontoPregacao pontoPregacao) {
		return "pontoPregacao/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pontosPregacao", pontoPregacaoservice.buscarTodos());
		return "pontoPregacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid PontoPregacao pontoPregacao, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "pontoPregacao/cadastro";
		}
		
		pontoPregacaoservice.salvar(pontoPregacao);
		attr.addFlashAttribute("success","Ponto de Pregação cadastrado com sucesso.");
		return "redirect:/pontosPregacao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("pontoPregacao", pontoPregacaoservice.buscarPorId(id));
		return "pontoPregacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid PontoPregacao pontoPregacao, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "pontoPregacao/cadastro";
		}
		
		pontoPregacaoservice.editar(pontoPregacao);
		attr.addFlashAttribute("success","Ponto de Pregação atualizado com sucesso.");
		return "redirect:/pontosPregacao/cadastrar";
	}
	
//	@GetMapping("/excluir/{id}")
//	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
//		if(pontoPregacaoservice.PontoPregacaoTemMovimentos(id)) {
//			attr.addFlashAttribute("fail","Ponto de Pregação não excluido. Existem movimentações vinculadas a ele.");
//		}else {
//			pontoPregacaoservice.excluir(id);
//			attr.addFlashAttribute("success","Ponto de Pregação excluido com sucesso.");
//		}
//		return "redirect:/pontosPregacao/listar";
//	}
	@ModelAttribute("congregacoes")
	public List<Congregacao>listaDeCongregacoes(){
		return congregacaoservice.buscarTodos();
	}


}

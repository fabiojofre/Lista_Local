package com.jofre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.domain.Congregacao;
import com.jofre.service.CongregacaoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/congregacoes")
public class CongregacaoController {
	
	@Autowired
	private CongregacaoService congregacaoservice;

	
	@GetMapping("/cadastrar")
	public String cadastrar(Congregacao congregacao) {
		return "congregacao/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("congregacoes", congregacaoservice.buscarTodos());
		return "congregacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Congregacao congregacao, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "congregacao/cadastro";
		}
		
		congregacaoservice.salvar(congregacao);
		attr.addFlashAttribute("success","Congregação cadastrada com sucesso.");
		return "redirect:/congregacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("congregacao", congregacaoservice.buscarPorId(id));
		return "congregacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Congregacao congregacao, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "congregacao/cadastro";
		}
		
		congregacaoservice.editar(congregacao);
		attr.addFlashAttribute("success","Congregação atualizada com sucesso.");
		return "redirect:/congregacoes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
//		if(congregacaoservice.congregacaoTemFuncionarios(id)) {
			attr.addFlashAttribute("fail","Congregação não excluida. Existem pessoas vinculadas a ela.");
//		}else {
//			congregacaoservice.excluir(id);
//			attr.addFlashAttribute("success","Congregação excluida com sucesso.");
//		}
		return "redirect:/congregacoes/listar";
	}

}

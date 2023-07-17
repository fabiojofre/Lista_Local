package com.jofre.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.domain.Congregacao;
import com.jofre.domain.Obreiro;
import com.jofre.service.CongregacaoService;
import com.jofre.service.ObreiroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/obreiros")
public class ObreiroController {
	
	@Autowired
	private ObreiroService obreiroservice;

	@Autowired
	private CongregacaoService congregacaoservice;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Obreiro obreiro) {
		return "obreiro/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarTodos());
		return "obreiro/lista";
	}
	@GetMapping("/listardata")
	public String listardata(ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarTodos());
		return "obreiro/listadata";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Obreiro obreiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "obreiro/cadastro";
		}
		else if(obreiroservice.buscarPorCartao(obreiro.getCartaoMembro()).size()>1) {
			attr.addFlashAttribute("fail","Cadastro do obreiro já efetuado com o número do cartão de membro: "+obreiro.getCartaoMembro()+". ");
			return "redirect:/obreiros/cadastrar";
		}
		else {
		
		obreiroservice.salvar(obreiro);
		attr.addFlashAttribute("success","Ponto de Pregação cadastrado com sucesso.");
		return "redirect:/obreiros/cadastrar";
		}
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("obreiro", obreiroservice.buscarPorId(id));
		return "obreiro/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Obreiro obreiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "obreiro/cadastro";
		}
		
		obreiroservice.editar(obreiro);
		attr.addFlashAttribute("success","Ponto de Pregação atualizado com sucesso.");
		return "redirect:/obreiros/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
//		if(obreiroservice.ObreiroTemMovimentos(id)) {
//			attr.addFlashAttribute("fail","Ponto de Pregação não excluido. Existem movimentações vinculadas a ele.");
//		}else {
//			obreiroservice.excluir(id);
//			attr.addFlashAttribute("success","Ponto de Pregação excluido com sucesso.");
//		}
		return "redirect:/obreiros/listar";
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarPorNome(nome));
		return "obreiro/lista";
	}
	
	@GetMapping("/buscar/congregacao")
	public String getPorCongregacao(@RequestParam("id") Integer id, ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarPorCongregacao(id));
		return "obreiro/lista";
	}
	
	@GetMapping("/buscar/cartao")
	public String getPorCartao(@RequestParam("cartaoMembro") Long cartaoMembro, ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarPorCartao(cartaoMembro));
		return "obreiro/lista";
	}
	
	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam("data")@DateTimeFormat(iso = ISO.DATE) Date data, ModelMap model) {
		model.addAttribute("obreiros", obreiroservice.buscarPorData(data));
		return "obreiro/listadata";
	}

		 
	
	@ModelAttribute("congregacoes")
	public List<Congregacao>listaDeCongregacoes(){
		return congregacaoservice.buscarTodos();
	}
	


}

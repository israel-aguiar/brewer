package com.algaworks.brewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Cliente;
import com.algaworks.brewer.model.TipoPessoa;
import com.algaworks.brewer.repository.Estados;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private Estados estados;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		mv.addObject("estados", estados.findAll());
		
		return mv;
	}
	
//	public String cadastrar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
//		
//		if (result.hasErrors()) {
//			result.getAllErrors().stream().forEach(e -> System.out.println(e));
//			return novo(cliente);
//		}
//		
//		
//		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
//		return "redirect:/clientes/novo";
//	}

}

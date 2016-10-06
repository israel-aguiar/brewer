package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Cliente;
import com.algaworks.brewer.model.TipoPessoa;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		
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

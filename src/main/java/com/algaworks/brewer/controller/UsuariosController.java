package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.repository.Grupos;
import com.algaworks.brewer.service.CadastroUsuarioService;
import com.algaworks.brewer.service.exception.EmailUsuarioJaCadastradoException;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Grupos grupos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		usuario.setAtivo(true);
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors())
			return novo(usuario);
		
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso.");
		try {
		cadastroUsuarioService.salvar(usuario);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(usuario);
		}
		
		
		return new ModelAndView("redirect:/usuarios/novo");
	}

}

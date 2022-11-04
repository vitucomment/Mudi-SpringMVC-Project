package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoUsuario;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("user")
public class LoginController {

	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoUsuario requisicao) {
		return "/usuario/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return "/usuario/formulario";
		}
		System.out.println("CADASTRANDO");
		User novoUser = requisicao.toUser();
		
		userRepository.save(novoUser);
	
		return "redirect:/home";
	}
}

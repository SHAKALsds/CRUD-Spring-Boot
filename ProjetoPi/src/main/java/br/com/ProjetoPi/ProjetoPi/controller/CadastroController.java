package br.com.ProjetoPi.ProjetoPi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPi.ProjetoPi.models.Cadastro;
import br.com.ProjetoPi.ProjetoPi.models.Usuario;
import br.com.ProjetoPi.ProjetoPi.repository.CadastroRepository;
import br.com.ProjetoPi.ProjetoPi.repository.UsuarioRepository;

@Controller
public class CadastroController {

	@Autowired
	private CadastroRepository cr;

	@Autowired
	private UsuarioRepository ur;

	// Cadastrar Usuario - GET
	@RequestMapping("/")
	public String form() {
		return "form-cadastro";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String form(@Valid Cadastro cadastro, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/";
		}

		cr.save(cadastro);
		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso");
		return "redirect:/";
	}

	// Lista de Usuarios - GET
	@RequestMapping("/Usuarios")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("html/form-listar");
		Iterable<Cadastro> cadastros = cr.findAll();
		mv.addObject("cadastros", cadastros);
		return mv;
	}

	// Detalhes Usuario - GET
	@RequestMapping("/Usuarios/{codigo}")
	public ModelAndView detalhesUsuario(@PathVariable("codigo") long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("html/detalhes-usuario");
		mv.addObject("cadastro", cadastro);

		Iterable<Usuario> usuarios = ur.findByCadastro(cadastro);
		mv.addObject("usuarios", usuarios);
		return mv;
	}

	// Deletar Ususario pelo Id
	@RequestMapping("/deletarUsuario")
	public String deletarUsuario(long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		cr.delete(cadastro);
		return "redirect:/Usuarios";
	}

	// Editar usuario - GET
	@RequestMapping("/editar-usuario")
	public ModelAndView editarUsuario(long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("html/detalhes-usuario");
		mv.addObject("cadastro", cadastro);
		return mv;
	}

	// Atualizar usuario
	@RequestMapping(value = "/editar-usuario", method = RequestMethod.POST)
	public String updateUsuario(@Valid Cadastro cadastro, BindingResult result, RedirectAttributes attributes) {
		cr.save(cadastro);
		attributes.addFlashAttribute("sucess", "Usuario atualizado com sucesso");

		long codigoLong = cadastro.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/Usuarios/" + codigo;
	}

}

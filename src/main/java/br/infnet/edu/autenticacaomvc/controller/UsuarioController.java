package br.infnet.edu.autenticacaomvc.controller;

import br.infnet.edu.autenticacaomvc.model.domain.Usuario;
import br.infnet.edu.autenticacaomvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController  {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value="/usuario")
    public String TelaCadastro() {return "usuario/cadastro";}

    @GetMapping(value = "/usuarios")
    public String telaLista(Model model) {

        model.addAttribute("usuarioLista", usuarioService.obterLista());

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario){

        usuarioService.incluir(usuario);

        return "redirect:/";
    }


}

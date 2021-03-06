package br.infnet.edu.autenticacaomvc.controller;

import br.infnet.edu.autenticacaomvc.model.domain.Usuario;
import br.infnet.edu.autenticacaomvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String telaHome() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(SessionStatus status, HttpSession session) {

        status.setComplete();
        session.removeAttribute("user");

        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String validar(Model model, @RequestParam String email, @RequestParam String senha){

        Usuario usuario = usuarioService.autenticacao(email, senha);

        if(usuario != null) {
            model.addAttribute("user", usuario);

            return "redirect:/";
        } else {
            model.addAttribute(
                    "mensagem",
                    "As credenciais do usuário "+ email +" estão incorretas!!!"
            );

            return telaLogin();
        }

    }
}

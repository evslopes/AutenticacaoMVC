package br.infnet.edu.autenticacaomvc;

import br.infnet.edu.autenticacaomvc.model.domain.Usuario;
import br.infnet.edu.autenticacaomvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setNome("Elvis");
        usuario.setEmail("elvis@teste.com");
        usuario.setSenha("12345");

        usuarioService.incluir(usuario);
    }
}

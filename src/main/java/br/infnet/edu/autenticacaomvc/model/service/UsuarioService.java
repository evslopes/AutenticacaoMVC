package br.infnet.edu.autenticacaomvc.model.service;

import br.infnet.edu.autenticacaomvc.model.domain.Usuario;
import br.infnet.edu.autenticacaomvc.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticacao(String email, String senha) {
        return usuarioRepository.autenticacao(email, senha);
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }


}

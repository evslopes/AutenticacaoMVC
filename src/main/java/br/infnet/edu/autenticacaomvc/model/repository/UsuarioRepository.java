package br.infnet.edu.autenticacaomvc.model.repository;

import br.infnet.edu.autenticacaomvc.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("from Usuario u where u.email = :email and u.senha = :senha")
    public Usuario autenticacao(String email, String senha);
}
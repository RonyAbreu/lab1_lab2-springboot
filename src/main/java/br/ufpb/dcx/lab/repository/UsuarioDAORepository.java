package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAORepository extends JpaRepository<Long, Usuario> {
    Optional<Usuario> findByEmail(String email);
}

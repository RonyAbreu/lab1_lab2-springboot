package br.ufpb.dcx.lab1.repository;

import br.ufpb.dcx.lab1.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}

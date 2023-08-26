package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}

package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaDAORepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByTags_NomeTagContaining(String nomeTag);
}

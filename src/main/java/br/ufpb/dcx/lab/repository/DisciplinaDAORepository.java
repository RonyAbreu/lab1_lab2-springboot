package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplinaDAORepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByNameIgnoreCase(String name);
    List<Disciplina> findByTagsNameIgnoreCase(String tagName);
}

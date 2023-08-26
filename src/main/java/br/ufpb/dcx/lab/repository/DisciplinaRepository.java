package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}

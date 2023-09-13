package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagDAORepository extends JpaRepository<Tag,Long> {
}

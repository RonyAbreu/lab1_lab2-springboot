package br.ufpb.dcx.lab1.repository;

import br.ufpb.dcx.lab1.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}

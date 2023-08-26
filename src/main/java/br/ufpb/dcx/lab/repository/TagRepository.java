package br.ufpb.dcx.lab.repository;

import br.ufpb.dcx.lab.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}

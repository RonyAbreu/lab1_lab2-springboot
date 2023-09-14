package br.ufpb.dcx.lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})

@Entity
@Table(name = "tb_tags")
public class Tag implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

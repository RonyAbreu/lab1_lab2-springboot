package br.ufpb.dcx.lab1.entities;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Disciplina implements Serializable {
    private Integer id;
    private String nome;
    private Integer likes;
    private List<Integer> notas = new ArrayList<>();

    public Disciplina(Integer id, String nome, Integer likes) {
        this.id = id;
        this.nome = nome;
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id.equals(that.id) && nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

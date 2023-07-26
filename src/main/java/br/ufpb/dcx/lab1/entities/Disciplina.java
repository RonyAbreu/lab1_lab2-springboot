package br.ufpb.dcx.lab1.entities;

import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Disciplina {
    private Integer id;
    private String nome;
    private Integer likes;
    private List<Integer> notas;

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

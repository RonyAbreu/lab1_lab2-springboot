package br.ufpb.dcx.lab1.dto;

import br.ufpb.dcx.lab1.entities.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO implements Serializable {
    private String nome;

    public DisciplinaDTO(Disciplina disciplina) {
        this.nome = disciplina.getNome();
    }
}

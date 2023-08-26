package br.ufpb.dcx.lab.dto;

import br.ufpb.dcx.lab.entities.Disciplina;
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

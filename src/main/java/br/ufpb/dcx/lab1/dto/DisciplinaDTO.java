package br.ufpb.dcx.lab1.dto;

import br.ufpb.dcx.lab1.entities.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {
    private String nome;

    public DisciplinaDTO(Disciplina disciplina) {
        this.nome = disciplina.getNome();
    }
}

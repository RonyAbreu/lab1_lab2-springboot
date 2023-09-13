package br.ufpb.dcx.lab.dto;

import br.ufpb.dcx.lab.entities.Disciplina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO implements Serializable {
    @NotBlank(message = "{name.not.blank}")
    @Size(min = 4, max = 30)
    private String nome;

    public DisciplinaDTO(Disciplina disciplina) {
        this.nome = disciplina.getNome();
    }
}

package br.ufpb.dcx.lab.dto.disciplina;

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
public class DisciplinaRegisterDTO implements Serializable {
    @NotBlank(message = "O campo (Nome) não pode estar vazio.")
    @Size(min = 4, max = 30, message = "O campo name precisa ter entre 4 e 30 caracteres.")
    private String name;

    public DisciplinaRegisterDTO(String name) {
        this.name = name;
    }
}

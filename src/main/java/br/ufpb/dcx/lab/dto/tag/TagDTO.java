package br.ufpb.dcx.lab.dto.tag;

import br.ufpb.dcx.lab.entities.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Data
public class TagDTO implements Serializable {
    @NotBlank(message = "O campo (nome) não pode estar vazio.")
    @Size(min = 2, max = 15, message = "O campo (nome) excedeu o limite de caracteres.")
    private String tagName;

    public TagDTO(Tag tag) {
        this.tagName = tag.getName();
    }
}

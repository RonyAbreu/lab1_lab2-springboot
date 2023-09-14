package br.ufpb.dcx.lab.dto;

import br.ufpb.dcx.lab.entities.Comentario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter

public class ComentarioDTO implements Serializable {
    @NotBlank(message = "Insira o text no comentário.")
    @Size(min = 1, max = 255, message = "Seu text excedeu o limite de caracteres")
    private String text;

    public ComentarioDTO(Comentario comentario) {
        this.text = comentario.getText();
    }
}

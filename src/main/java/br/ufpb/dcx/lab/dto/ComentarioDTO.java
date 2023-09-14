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
    @NotBlank(message = "Insira o texto no comentário.")
    @Size(min = 1, max = 255, message = "Seu texto excedeu o limite de caracteres")
    private String texto;

    public ComentarioDTO(Comentario comentario) {
        this.texto = comentario.getTexto();
    }
}

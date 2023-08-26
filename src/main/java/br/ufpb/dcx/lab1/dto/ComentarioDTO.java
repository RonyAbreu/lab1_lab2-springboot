package br.ufpb.dcx.lab1.dto;

import br.ufpb.dcx.lab1.entities.Comentario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter

public class ComentarioDTO implements Serializable {
    private String texto;

    public ComentarioDTO(Comentario comentario) {
        this.texto = comentario.getTexto();
    }
}

package br.ufpb.dcx.lab.dto;

import br.ufpb.dcx.lab.entities.Comentario;
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

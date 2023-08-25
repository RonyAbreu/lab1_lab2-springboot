package br.ufpb.dcx.lab1.dto;

import jakarta.persistence.JoinColumn;
import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "nomeTag")

public class TagDTO implements Serializable {
    @JoinColumn(unique = true)
    private String nomeTag;
}

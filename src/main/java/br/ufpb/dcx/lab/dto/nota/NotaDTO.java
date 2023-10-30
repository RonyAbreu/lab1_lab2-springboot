package br.ufpb.dcx.lab.dto.nota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotaDTO implements Serializable {
    @NotBlank(message = "O campo (nota) não pode estar vazio.")
    @Size(min = 1, max = 5, message = "Sua nota excedeu o limite de caracteres.")
    private Double note;
}

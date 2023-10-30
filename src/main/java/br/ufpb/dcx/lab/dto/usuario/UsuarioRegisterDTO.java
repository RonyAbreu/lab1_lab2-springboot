package br.ufpb.dcx.lab.dto.usuario;

import br.ufpb.dcx.lab.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
@Data
public class UsuarioRegisterDTO implements Serializable {
    @NotBlank(message = "O campo (nome) não pode estar vazio.")
    @Size(min = 3, max = 60, message = "O campo (nome) ultrapassou o limite de caracteres.")
    private String nome;
    @Email
    @NotBlank(message = "O campo (email) não pode estar vazio.")
    @Size(min = 11, max = 50, message = "O campo (email) ultrapassou o limite de caracteres.")
    private String email;
    @NotBlank(message = "O campo (senha) não pode estar vazio.")
    @Size(min = 8, max = 14, message = "O campo (senha) ultrapassou o limite de caracteres.")
    private String senha;

    public UsuarioRegisterDTO(Usuario usuario){
        this.nome = usuario.getNome();;
        this.email = usuario.getEmail();;
        this.senha = usuario.getSenha();
    }
}

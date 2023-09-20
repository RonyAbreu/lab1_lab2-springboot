package br.ufpb.dcx.lab.entities;

import br.ufpb.dcx.lab.dto.usuario.UsuarioRegisterDTO;
import br.ufpb.dcx.lab.entities.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "email")

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Cargo cargo = Cargo.USUARIO;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario (UsuarioRegisterDTO usuarioRegisterDTO){
        this.nome = usuarioRegisterDTO.getNome();
        this.email = usuarioRegisterDTO.getSenha();
        this.senha = usuarioRegisterDTO.getSenha();
    }
}

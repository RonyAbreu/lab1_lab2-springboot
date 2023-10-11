package br.ufpb.dcx.lab.entities;

import br.ufpb.dcx.lab.dto.usuario.UsuarioDeRegistro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data

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

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(UsuarioDeRegistro usuarioDeRegistro){
        this.nome = usuarioDeRegistro.nome();;
        this.email = usuarioDeRegistro.email();
        this.senha = usuarioDeRegistro.senha();
    }
}

package br.ufpb.dcx.lab1.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_disciplinas")
public class Disciplina implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer likes;
    private List<Integer> notas = new ArrayList<>();

    @OneToMany(mappedBy = "disciplina")
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    public Disciplina(Long id,String nome, Integer likes) {
        this.id = id;
        this.nome = nome;
        this.likes = likes;
    }

    public void somaLikes(){
        this.likes++;
    }

    public Integer getMedia(){
        Integer media = 0;
        Integer valorTotal = 0;
        for (Integer i: notas){
            valorTotal+=i;
            media = valorTotal/notas.size();
        }
        return media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id.equals(that.id) && nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

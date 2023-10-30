package br.ufpb.dcx.lab.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "tb_disciplinas")
public class Disciplina implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer likes = 0;
    @ElementCollection
    @CollectionTable(name = "tb_notas")
    private List<Double> notas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "disciplina")
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    public Disciplina(String name) {
        this.name = name;
    }

    public String getMedia(){
        String media = formatMedia(calculatesMedia());
        return media;
    }

    public Double calculatesMedia(){
        double media = 0;
        double valorTotal = 0;
        for (Double i: notas){
            valorTotal+=i;
            media = valorTotal/notas.size();
        }
        return media;
    }
    public String formatMedia(Double media){
        return new DecimalFormat("##.##").format(media);
    }

    public boolean containsTag(Tag tag){
        return tags.contains(tag);
    }

    public void addLikes(){
        this.likes++;
    }

    public void addNotas(Double nota){
        this.notas.add(nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package br.ufpb.dcx.lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_comentarios")
public class Comentario implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateComment;
    private String text;
    private boolean remove;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @JsonIgnore
    private Disciplina disciplina;

}

package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.ComentarioDTO;
import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.services.ComentarioService;
import br.ufpb.dcx.lab.services.DisciplinaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private DisciplinaServices disciplinaServices;

    @PostMapping(value = "/disciplina/{id}/comentarios")
    public ResponseEntity<Void> addComment(@PathVariable Long id, @RequestBody ComentarioDTO comentario){
        Comentario c = comentarioService.dtoFromComment(id, comentario);
        comentarioService.insertComment(id,c);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/disciplina/{id}/comentarios")
    public ResponseEntity<List<ComentarioDTO>> findAll(@PathVariable Long id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d.getComentarios().stream().map(ComentarioDTO::new).toList());
    }

    @DeleteMapping(value = "/disciplina/{disciplinaId}/comentarios/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long disciplinaId, @PathVariable Long commentId){
        comentarioService.deleteComment(disciplinaId,commentId);
        return ResponseEntity.noContent().build();
    }
}

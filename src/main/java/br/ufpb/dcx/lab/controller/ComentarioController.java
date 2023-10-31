package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.comentario.ComentarioDTO;
import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.services.ComentarioService;
import br.ufpb.dcx.lab.services.DisciplinaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "/disciplina/{id}/comentarios",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ComentarioDTO> addComment(@PathVariable Long id, @RequestBody ComentarioDTO comentario){
        var commentReturn = comentarioService.insertComment(id,comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentReturn);
    }

    @GetMapping(value = "/disciplina/{id}/comentarios",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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

package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.ComentarioDTO;
import br.ufpb.dcx.lab.dto.DisciplinaDTO;
import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
import br.ufpb.dcx.lab.services.ComentarioService;
import br.ufpb.dcx.lab.services.DisciplinaServices;
import br.ufpb.dcx.lab.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaServices disciplinaServices;
    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody DisciplinaDTO d){
        Disciplina obj = disciplinaServices.fromDto(d);
        disciplinaServices.add(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Long id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> list = disciplinaServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        disciplinaServices.delete(id);
        HttpStatus status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(status);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody Disciplina obj){
        Disciplina d = disciplinaServices.update(obj,id);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/{id}/nota")
    public ResponseEntity<Disciplina> addNota(@PathVariable Long id, @RequestParam(value = "nota")Integer nota){
        Disciplina d = disciplinaServices.addNota(id,nota);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/{id}/like")
    public ResponseEntity<Disciplina> addLike(@PathVariable Long id){
        Disciplina d = disciplinaServices.addLike(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/ranking/notas")
    public ResponseEntity<List<Disciplina>> findRankingNotas(){
        List<Disciplina> list = disciplinaServices.findRankingNotas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/ranking/likes")
    public ResponseEntity<List<Disciplina>> findRankingLikes(){
        List<Disciplina> list = disciplinaServices.findRankingLikes();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/{id}/comentarios")
    public ResponseEntity<Void> addComment(@PathVariable Long id, @RequestBody ComentarioDTO comentario){
        Comentario c = comentarioService.fromDTO(id, comentario);
        comentarioService.add(id,c);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}/comentarios")
    public ResponseEntity<List<ComentarioDTO>> findAll(@PathVariable Long id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d.getComentarios().stream().map(ComentarioDTO::new).toList());
    }

    @PostMapping(value = "/{id}/tags")
    public ResponseEntity<Void> addTag(@PathVariable Long id, @RequestBody Tag tag){
        tagService.add(id,tag);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

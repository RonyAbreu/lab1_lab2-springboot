package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaRegisterDTO;
import br.ufpb.dcx.lab.dto.nota.NotaDTO;
import br.ufpb.dcx.lab.dto.tag.TagDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.services.DisciplinaServices;
import br.ufpb.dcx.lab.services.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/api")
public class DisciplinaController {
    @Autowired
    private DisciplinaServices disciplinaServices;
    @Autowired
    private TagService tagService;

    @PostMapping(value = "/disciplina")
    public ResponseEntity<Void> insert(@RequestBody @Valid DisciplinaRegisterDTO obj){
        disciplinaServices.insertDiscipline(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/disciplina/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Long id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/disciplina")
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> list = disciplinaServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/disciplina/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        disciplinaServices.deleteDiscipline(id);
        HttpStatus status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(status);
    }

    @PutMapping(value = "/disciplina/{id}/update")
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody DisciplinaRegisterDTO obj){
        Disciplina d = disciplinaServices.updateDiscipline(obj,id);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/disciplina/{id}/nota")
    public ResponseEntity<Disciplina> addNota(@PathVariable Long id, @RequestBody NotaDTO nota){
        Disciplina d = disciplinaServices.insertNota(id,nota);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/disciplina/{id}/like")
    public ResponseEntity<Disciplina> addLike(@PathVariable Long id){
        Disciplina d = disciplinaServices.insertLike(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/disciplina/ranking/notas")
    public ResponseEntity<List<Disciplina>> findRankingNotas(){
        List<Disciplina> list = disciplinaServices.findRankingNotas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/disciplina/ranking/likes")
    public ResponseEntity<List<Disciplina>> findRankingLikes(){
        List<Disciplina> list = disciplinaServices.findRankingLikes();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/disciplina/{id}/tags")
    public ResponseEntity<Void> addTag(@PathVariable Long id, @RequestBody TagDTO tag){
        tagService.insertTag(id,tag);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{disciplinaId}/tags/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long disciplinaId, @PathVariable Long tagId){
        tagService.deleteTag(disciplinaId,tagId);
        return ResponseEntity.noContent().build();
    }
}

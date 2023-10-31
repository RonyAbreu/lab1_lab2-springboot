package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaDTO;
import br.ufpb.dcx.lab.dto.nota.NotaDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.services.DisciplinaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/api")
public class DisciplinaController {
    @Autowired
    private DisciplinaServices disciplinaServices;

    @PostMapping(value = "/disciplina",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DisciplinaDTO> insert(@RequestBody @Valid DisciplinaDTO obj){
        var disciplinaReturn = disciplinaServices.insertDiscipline(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaReturn);
    }

    @GetMapping(value = "/disciplina/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Disciplina> findById(@PathVariable Long id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/disciplina",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DisciplinaDTO>> findAll(){
        List<DisciplinaDTO> list = disciplinaServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/disciplina/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        disciplinaServices.deleteDiscipline(id);
        HttpStatus status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(status);
    }

    @PutMapping(value = "/disciplina/{id}/update",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody DisciplinaDTO obj){
        Disciplina d = disciplinaServices.updateDiscipline(obj,id);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/disciplina/{id}/nota",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Disciplina> addNota(@PathVariable Long id, @RequestBody NotaDTO nota){
        Disciplina d = disciplinaServices.insertNota(id,nota);
        return ResponseEntity.ok().body(d);
    }

    @PatchMapping(value = "/disciplina/{id}/like",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Disciplina> addLike(@PathVariable Long id){
        Disciplina d = disciplinaServices.insertLike(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/disciplina/ranking/notas",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Disciplina>> findRankingNotas(){
        List<Disciplina> list = disciplinaServices.findRankingNotas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/disciplina/ranking/likes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Disciplina>> findRankingLikes(){
        List<Disciplina> list = disciplinaServices.findRankingLikes();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/disciplina/search/tags",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Disciplina>> findTagName(@RequestParam(value = "tagName",defaultValue = "q") String tagName){
        return ResponseEntity.ok().body(disciplinaServices.findByTagName(tagName));
    }

    @GetMapping(value = "/disciplina/search/name",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Disciplina>> findName(@RequestParam(value = "name",defaultValue = "q") String name){
        return ResponseEntity.ok().body(disciplinaServices.findByName(name));
    }
}

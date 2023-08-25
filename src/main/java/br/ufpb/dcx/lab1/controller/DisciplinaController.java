package br.ufpb.dcx.lab1.controller;

import br.ufpb.dcx.lab1.dto.DisciplinaDTO;
import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.services.DisciplinaServices;
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

    @PostMapping
    public ResponseEntity<Disciplina> add(@RequestBody DisciplinaDTO d){
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

    @GetMapping(value = "/ranking")
    public ResponseEntity<List<Disciplina>> findRanking(){
        List<Disciplina> list = disciplinaServices.findRanking();
        return ResponseEntity.ok().body(list);
    }

}

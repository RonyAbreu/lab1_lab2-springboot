package br.ufpb.dcx.lab1.controller;

import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.services.DisciplinaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaServices disciplinaServices;

    @PostMapping
    public ResponseEntity<Disciplina> add(@RequestBody Disciplina d){
        Disciplina obj = disciplinaServices.add(d);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Integer id){
        Disciplina d = disciplinaServices.findById(id);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> list = disciplinaServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        disciplinaServices.delete(id);
        HttpStatus status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(status);
    }

    @PutMapping(value = "/{id}/nome")
    public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina obj){
        Disciplina d = disciplinaServices.update(obj,id);
        return ResponseEntity.ok().body(d);
    }

    @PutMapping(value = "/{id}/nota")
    public ResponseEntity<Disciplina> addNota(@PathVariable Integer id, @RequestParam(value = "nota")Integer nota){
        Disciplina d = disciplinaServices.addNota(id,nota);
        return ResponseEntity.ok().body(d);
    }

    @PutMapping(value = "/{id}/like")
    public ResponseEntity<Disciplina> addLike(@PathVariable Integer id,@RequestParam(value = "like")Integer like){
        Disciplina d = disciplinaServices.addLike(id, like);
        return ResponseEntity.ok().body(d);
    }

    @GetMapping(value = "/ranking")
    public ResponseEntity<List<Disciplina>> findRanking(){
        List<Disciplina> list = disciplinaServices.findRanking();
        return ResponseEntity.ok().body(list);
    }

}

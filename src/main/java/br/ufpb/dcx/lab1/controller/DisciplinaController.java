package br.ufpb.dcx.lab1.controller;

import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.services.DisciplinaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaServices disciplinaServices;

    @PostMapping
    public ResponseEntity<Disciplina> add(@RequestBody Disciplina d){
        d = disciplinaServices.add(d);
        return ResponseEntity.ok().body(d);
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disciplina> update(@RequestBody Disciplina disciplina, @PathVariable Long id){
        disciplinaServices.update(disciplina,id);
        return ResponseEntity.ok().body(disciplina);
    }

}

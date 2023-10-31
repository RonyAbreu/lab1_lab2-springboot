package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.tag.TagDTO;
import br.ufpb.dcx.lab.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api")
public class TagController {
    @Autowired
    private TagService tagService;
    @Autowired
    private DisciplinaController disciplinaController;

    @PostMapping(value = "/disciplina/{id}/tags",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> addTag(@PathVariable Long id, @RequestBody TagDTO tag){
        tagService.insertTag(id,tag);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/disciplina/{disciplinaId}/tags/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long disciplinaId, @PathVariable Long tagId){
        tagService.deleteTag(disciplinaId,tagId);
        return ResponseEntity.noContent().build();
    }
}

package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.entities.Tag;
import br.ufpb.dcx.lab1.repository.DisciplinaRepository;
import br.ufpb.dcx.lab1.repository.TagRepository;
import br.ufpb.dcx.lab1.services.exceptions.DisciplinaNotFound;
import br.ufpb.dcx.lab1.services.exceptions.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void add(Long id, Tag tag){
        Optional<Disciplina> d = disciplinaRepository.findById(id);
        if (!d.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        } else if(d.get().getTags().contains(tag)){
            throw new TagException("Essa Disciplina já Possui essa Tag!");
        }
        d.get().getTags().add(tag);
        tagRepository.save(tag);
    }
}

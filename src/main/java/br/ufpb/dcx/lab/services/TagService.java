package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
import br.ufpb.dcx.lab.repository.DisciplinaRepository;
import br.ufpb.dcx.lab.repository.TagRepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import br.ufpb.dcx.lab.services.exceptions.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

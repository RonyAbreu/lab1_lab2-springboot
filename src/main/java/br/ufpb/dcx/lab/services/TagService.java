package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
import br.ufpb.dcx.lab.repository.DisciplinaDAORepository;
import br.ufpb.dcx.lab.repository.TagDAORepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import br.ufpb.dcx.lab.services.exceptions.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagDAORepository tagDAORepository;
    @Autowired
    private DisciplinaDAORepository disciplinaDAORepository;

    public void add(Long id, Tag tag){
        Optional<Disciplina> d = disciplinaDAORepository.findById(id);
        if (!d.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        } else if(d.get().getTags().contains(tag)){
            throw new TagException("Essa Disciplina já Possui essa Tag!");
        }
        d.get().getTags().add(tag);
        tagDAORepository.save(tag);
    }

    public void delete(Long disciplinaId, Long tagId){
        Disciplina d = disciplinaDAORepository.getReferenceById(disciplinaId);
        Tag t = tagDAORepository.getReferenceById(tagId);
        d.getTags().remove(t);
        tagDAORepository.deleteById(tagId);
    }
}

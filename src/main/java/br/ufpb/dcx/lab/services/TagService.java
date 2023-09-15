package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.tag.TagDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
import br.ufpb.dcx.lab.repository.DisciplinaDAORepository;
import br.ufpb.dcx.lab.repository.TagDAORepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import br.ufpb.dcx.lab.services.exceptions.TagAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagDAORepository tagDAORepository;
    @Autowired
    private DisciplinaDAORepository disciplinaDAORepository;

    public void insertTag(Long id, TagDTO tag){
        Optional<Disciplina> discipline = disciplinaDAORepository.findById(id);

        Tag tagSave = tagDtoFromTag(tag);

        if (discipline.isEmpty()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        } else if(discipline.get().containsTag(tagSave)){
            throw new TagAlreadyExistsException("Essa Disciplina já Possui essa Tag!");
        }

        discipline.get().getTags().add(tagSave);
        tagDAORepository.save(tagSave);
    }

    private Tag tagDtoFromTag(TagDTO tagDTO){
        return new Tag(null, tagDTO.getTagName());
    }

    public void deleteTag(Long disciplinaId, Long tagId){
        Disciplina discipline = disciplinaDAORepository.getReferenceById(disciplinaId);

        Tag tag = tagDAORepository.getReferenceById(tagId);

        discipline.getTags().remove(tag);
        tagDAORepository.deleteById(tagId);
    }
}

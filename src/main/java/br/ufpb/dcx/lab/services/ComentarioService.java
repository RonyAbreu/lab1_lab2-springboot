package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.comentario.ComentarioDTO;
import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.repository.ComentarioDAORepository;
import br.ufpb.dcx.lab.repository.DisciplinaDAORepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioDAORepository comentarioDAORepository;

    @Autowired
    DisciplinaDAORepository disciplinaDAORepository;

    public void insertComment(Long id, ComentarioDTO comentario){
        Optional<Disciplina> discipline = disciplinaDAORepository.findById(id);

        if (discipline.isEmpty()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }

        Comentario comentarioSave = comentarioDtoFromComentario(id, comentario);

        discipline.get().getComentarios().add(comentarioSave);
        comentarioDAORepository.save(comentarioSave);
    }

    private Comentario comentarioDtoFromComentario(Long id,ComentarioDTO comentarioDTO){
        return new Comentario(null,LocalDate.now(),comentarioDTO.getText(),false,disciplinaDAORepository.getReferenceById(id));
    }

    public void deleteComment(Long disciplinaId, Long commentId){
        Disciplina d = disciplinaDAORepository.getReferenceById(disciplinaId);

        Comentario c = comentarioDAORepository.getReferenceById(commentId);

        comentarioDAORepository.deleteById(commentId);
    }
}

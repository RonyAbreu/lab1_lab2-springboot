package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.ComentarioDTO;
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

    public void insertComment(Long id, Comentario comentario){
        Optional<Disciplina> discipline = disciplinaDAORepository.findById(id);

        if (discipline.isEmpty()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }

        discipline.get().getComentarios().add(comentario);
        comentarioDAORepository.save(comentario);
    }

    public void deleteComment(Long disciplinaId, Long commentId){
        Disciplina d = disciplinaDAORepository.getReferenceById(disciplinaId);

        Comentario c = comentarioDAORepository.getReferenceById(commentId);

        d.getComentarios().remove(c);
        comentarioDAORepository.deleteById(commentId);
    }

    public Comentario dtoFromComment(Long id, ComentarioDTO comentarioDTO){
        return new Comentario(null, LocalDate.now(), comentarioDTO.getText(), false, disciplinaDAORepository.getReferenceById(id));
    }
}

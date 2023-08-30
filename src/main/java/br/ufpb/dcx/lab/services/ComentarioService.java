package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.ComentarioDTO;
import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.repository.ComentarioRepository;
import br.ufpb.dcx.lab.repository.DisciplinaRepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void add(Long id, Comentario comentario){
        Optional<Disciplina> d = disciplinaRepository.findById(id);
        if (!d.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        d.get().getComentarios().add(comentario);
        comentarioRepository.save(comentario);
    }

    public void delete(Long disciplinaId, Long commentId){
        Disciplina d = disciplinaRepository.getReferenceById(disciplinaId);
        Comentario c = comentarioRepository.getReferenceById(commentId);
        d.getComentarios().remove(c);
        comentarioRepository.deleteById(commentId);
    }

    public Comentario fromDTO(Long id,ComentarioDTO comentarioDTO){
        return new Comentario(null, LocalDate.now(), comentarioDTO.getTexto(), false,disciplinaRepository.getReferenceById(id));
    }
}

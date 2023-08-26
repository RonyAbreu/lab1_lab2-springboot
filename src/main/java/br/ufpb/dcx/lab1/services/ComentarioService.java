package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.dto.ComentarioDTO;
import br.ufpb.dcx.lab1.entities.Comentario;
import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.repository.ComentarioRepository;
import br.ufpb.dcx.lab1.repository.DisciplinaRepository;
import br.ufpb.dcx.lab1.services.exceptions.DisciplinaNotFound;
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

    public Comentario fromDTO(Long id,ComentarioDTO comentarioDTO){
        return new Comentario(null, LocalDate.now(), comentarioDTO.getTexto(), false,disciplinaRepository.getReferenceById(id));
    }

}

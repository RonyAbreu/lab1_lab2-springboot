package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.entities.Comentario;
import br.ufpb.dcx.lab1.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository repository;

    public void add(Comentario c){
        repository.save(c);
    }

    public List<Comentario> findAllComment(){
        return repository.findAll();
    }
}

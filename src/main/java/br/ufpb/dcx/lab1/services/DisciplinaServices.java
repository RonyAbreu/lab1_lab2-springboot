package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServices {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void add(Disciplina d){
        disciplinaRepository.save(d);
    }

    public Disciplina findById(Long id){
        Optional<Disciplina> d = disciplinaRepository.findById(id);
        return d.get();
    }

    public List<Disciplina> findAll(){
        List<Disciplina> list = disciplinaRepository.findAll();
        return list;
    }
}

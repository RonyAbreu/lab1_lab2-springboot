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

    public Disciplina add(Disciplina d){
        return disciplinaRepository.save(d);
    }

    public Disciplina findById(Long id){
        Optional<Disciplina> d = disciplinaRepository.findById(id);
        return d.get();
    }

    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    public void delete(Long id){
        disciplinaRepository.deleteById(id);
    }

    public Disciplina update(Disciplina disciplina, Long id){
        Disciplina novaDisciplina = disciplinaRepository.getReferenceById(id);
        updateData(novaDisciplina, disciplina);
        return disciplinaRepository.save(novaDisciplina);
    }

    private void updateData(Disciplina novaDisciplina, Disciplina disciplina) {
        novaDisciplina.setNome(disciplina.getNome());
        novaDisciplina.setLikes(disciplina.getLikes());
    }
}

package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.DisciplinaDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.repository.DisciplinaRepository;
import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServices {
    @Autowired
    private DisciplinaRepository repository;

    public void add(Disciplina obj) {
        repository.save(obj);
    }

    public Disciplina findById(Long id) throws DisciplinaNotFound {
        Optional<Disciplina> d = repository.findById(id);
        return d.orElseThrow(() -> new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id));
    }

    public List<Disciplina> findAll() {
        List<Disciplina> list = repository.findAll();
        if (list.size() == 0){
            throw new DisciplinaNotFound("Lista de disciplinas está vazia!");
        }
        return repository.findAll();
    }

    public void delete(Long id) {
        Optional<Disciplina> d = Optional.ofNullable(findById(id));
        if (!d.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        repository.deleteById(id);
    }

    public Disciplina update(Disciplina obj, Long id) {
        Optional<Disciplina> novaDisciplina = repository.findById(id);
        if (!novaDisciplina.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        updateDisciplina(novaDisciplina.get(), obj);
        return repository.save(novaDisciplina.get());
    }

    private void updateDisciplina(Disciplina novaDisciplina, Disciplina obj) {
        novaDisciplina.setNome(obj.getNome());
    }

    public Disciplina addNota(Long id, Integer nota){
        Optional<Disciplina> novaDisciplina = repository.findById(id);
        if (!novaDisciplina.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        updateNota(novaDisciplina, nota);
        return repository.save(novaDisciplina.get());
    }

    private void updateNota(Optional<Disciplina> novaDisciplina, Integer nota) {
        novaDisciplina.get().getNotas().add(nota);
    }

    public Disciplina addLike(Long id){
        Optional<Disciplina> novaDisciplina = repository.findById(id);
        if (!novaDisciplina.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        novaDisciplina.get().somaLikes();
        return repository.save(novaDisciplina.get());
    }

    public List<Disciplina> findRankingNotas(){
        List<Disciplina> list = repository.findAll();
        if (list.size() == 0){
            throw new DisciplinaNotFound("Lista de disciplinas está vazia!");
        }
        list.sort(Comparator.comparingInt(Disciplina::getMedia).reversed());
        return list;
    }

    public List<Disciplina> findRankingLikes(){
        List<Disciplina> list = repository.findAll();
        if (list.size() == 0){
            throw new DisciplinaNotFound("Lista de disciplinas está vazia!");
        }
        list.sort(Comparator.comparingInt(Disciplina::getLikes).reversed());
        return list;
    }

    public Disciplina fromDto(DisciplinaDTO objDto){
        return new Disciplina(null,objDto.getNome(),0);
    }
}


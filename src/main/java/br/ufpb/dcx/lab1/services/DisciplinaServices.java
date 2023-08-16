package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.dto.DisciplinaDTO;
import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.repository.DisciplinaRepository;
import br.ufpb.dcx.lab1.services.exceptions.DisciplinaNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServices {
    @Autowired
    private DisciplinaRepository repository;

    public Disciplina add(Disciplina obj) {
        return repository.save(obj);
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
        Disciplina d = repository.getReferenceById(id);
        if (d == null){
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

    public  Disciplina addLike(Long id, Integer like){
        Optional<Disciplina> novaDisciplina = repository.findById(id);
        if (!novaDisciplina.isPresent()){
            throw new DisciplinaNotFound("Não foi encontrada disciplina com esse id: "+ id);
        }
        int somaLike = novaDisciplina.get().getLikes() + 1;
        novaDisciplina.get().setLikes(somaLike);
        return repository.save(novaDisciplina.get());
    }

    public List<Disciplina> findRanking(){
        List<Disciplina> list = repository.findAll();
        if (list.size() == 0){
            throw new DisciplinaNotFound("Lista de disciplinas está vazia!");
        }
        list.sort(Comparator.comparingInt(Disciplina::getMedia).reversed());
        return list;
    }

    public Disciplina fromDto(DisciplinaDTO objDto){
        return new Disciplina(objDto.getNome());
    }
}


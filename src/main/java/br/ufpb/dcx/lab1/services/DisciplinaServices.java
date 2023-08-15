package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.entities.Disciplina;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplinaServices {
    private Map<Integer, Disciplina> dataBase = new HashMap<>();

    public Disciplina add(Disciplina d) {
        return dataBase.put(d.getId(), d);
    }

    public Disciplina findById(Integer id){
        try {
            Optional<Disciplina> d = Optional.ofNullable(dataBase.get(id));
            return d.orElseThrow(() -> new Exception("Disciplina não encontrada!"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Disciplina> findAll() {
        return new ArrayList<>(dataBase.values());
    }

    public void delete(Integer id) {
        dataBase.remove(id);
    }

    public Disciplina update(Disciplina disciplina, Integer id) {
        Disciplina novaDisciplina = dataBase.get(id);
        novaDisciplina.setNome(disciplina.getNome());
        return dataBase.put(id, novaDisciplina);
    }

    public  Disciplina addNota(Integer id, Integer nota){
        Disciplina disciplina = dataBase.get(id);
        disciplina.getNotas().add(nota);
        return dataBase.put(id,disciplina);
    }

    public  Disciplina addLike(Integer id, Integer like){
        Disciplina disciplina = dataBase.get(id);
        int somaLike = disciplina.getLikes() + 1;
        disciplina.setLikes(somaLike);
        return dataBase.put(id,disciplina);
    }

    public List<Disciplina> findRanking(){
        List<Disciplina> list = new ArrayList<>(dataBase.values());
        return null;
    }






}


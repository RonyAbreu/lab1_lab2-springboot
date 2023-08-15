package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.entities.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DisciplinaServices {
    private Map<Integer, Disciplina> dataBase = new HashMap<>();

    public Disciplina add(Disciplina obj) {
        Disciplina d = dataBase.put(obj.getId(),obj);
        return d;
    }

    public Disciplina findById(Integer id) throws Exception {
        Optional<Disciplina> d = Optional.ofNullable(dataBase.get(id));
        return d.orElseThrow(() -> new Exception("Disciplina não encontrada!"));

    }

    public List<Disciplina> findAll() {
        return new ArrayList<>(dataBase.values());
    }

    public void delete(Integer id) {
        dataBase.remove(id);
    }

    public Disciplina update(Disciplina obj, Integer id) {
        Disciplina novaDisciplina = dataBase.get(id);
        novaDisciplina.setNome(obj.getNome());
        dataBase.put(id, novaDisciplina);
        return novaDisciplina;
    }

    public Disciplina addNota(Integer id, Integer nota){
        Disciplina novaDisciplina = dataBase.get(id);
        novaDisciplina.getNotas().add(nota);
        dataBase.put(id, novaDisciplina);
        return novaDisciplina;
    }

    public  Disciplina addLike(Integer id, Integer like){
        Disciplina novaDisciplina = dataBase.get(id);
        int somaLike = novaDisciplina.getLikes() + 1;
        novaDisciplina.setLikes(somaLike);
        dataBase.put(id, novaDisciplina);
        return novaDisciplina;
    }

    public List<Disciplina> findRanking(){
        List<Disciplina> list = new ArrayList<>(dataBase.values());
        Collections.sort(list,Comparator.comparingInt(Disciplina::getMedia).reversed());
        return list;
    }






}


package br.ufpb.dcx.lab.mock;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaRegisterDTO;
import br.ufpb.dcx.lab.entities.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaMock {

    public Disciplina mockDisciplina(Integer numero){
        Disciplina disciplina = new Disciplina();
        disciplina.setId(numero.longValue());
        disciplina.setLikes(numero);
        disciplina.setName("Disciplina " + numero);
        return disciplina;
    }

    public DisciplinaRegisterDTO mockDisciplinaDto(Integer numero){
        DisciplinaRegisterDTO disciplina = new DisciplinaRegisterDTO();
        disciplina.setName("Disciplina " + numero);
        return disciplina;
    }

    public List<Disciplina> mockListDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            disciplinas.add(mockDisciplina(i));
        }
        return disciplinas;
    }

    public List<DisciplinaRegisterDTO> mockListDisciplinasDto(){
        List<DisciplinaRegisterDTO> disciplinas = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            disciplinas.add(mockDisciplinaDto(i));
        }
        return disciplinas;
    }
}

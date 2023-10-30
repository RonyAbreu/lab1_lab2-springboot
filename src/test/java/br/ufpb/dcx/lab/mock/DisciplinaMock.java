package br.ufpb.dcx.lab.mock;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaDTO;
import br.ufpb.dcx.lab.entities.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaMock {

    public Disciplina mockDisciplina(Integer numero){
        Disciplina disciplina = new Disciplina();
        disciplina.setId(numero.longValue());
        disciplina.setName("Disciplina " + numero);
        return disciplina;
    }

    public DisciplinaDTO mockDisciplinaDto(Integer numero){
        DisciplinaDTO disciplina = new DisciplinaDTO();
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

    public List<DisciplinaDTO> mockListDisciplinasDto(){
        List<DisciplinaDTO> disciplinas = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            disciplinas.add(mockDisciplinaDto(i));
        }
        return disciplinas;
    }
}

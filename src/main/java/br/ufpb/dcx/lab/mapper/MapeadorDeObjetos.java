package br.ufpb.dcx.lab.mapper;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaRegisterDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import org.springframework.stereotype.Component;

@Component
public class MapeadorDeObjetos {

    public Disciplina converteDtoEmDisciplina(DisciplinaRegisterDTO disciplinaRegisterDTO){
        Disciplina disciplina = new Disciplina();
        disciplina.setName(disciplinaRegisterDTO.getName());
        return disciplina;
    }

    public DisciplinaRegisterDTO converteDisciplinaEmDto(Disciplina disciplina){
        DisciplinaRegisterDTO disciplinaRegisterDTO = new DisciplinaRegisterDTO();
        disciplinaRegisterDTO.setName(disciplina.getName());
        return disciplinaRegisterDTO;
    }
}

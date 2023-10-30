package br.ufpb.dcx.lab.mapper;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorDeObjetos {
    public Disciplina converteDtoEmDisciplina(DisciplinaDTO disciplinaDTO){
        Disciplina disciplina = new Disciplina();
        disciplina.setName(disciplinaDTO.getName());
        return disciplina;
    }

    public DisciplinaDTO converteDisciplinaEmDto(Disciplina disciplina){
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.setName(disciplina.getName());
        return disciplinaDTO;
    }

    public List<DisciplinaDTO> converteListaDeDisciplinaEmDto(List<Disciplina> disciplinaList){
        List<DisciplinaDTO> disciplinaDTOList = disciplinaList
                .stream()
                .map(d -> new DisciplinaDTO(d.getName()))
                .toList();

        return disciplinaDTOList;
    }


}

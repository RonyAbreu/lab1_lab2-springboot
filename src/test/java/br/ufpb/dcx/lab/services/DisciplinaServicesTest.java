package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaRegisterDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.mock.DisciplinaMock;
import br.ufpb.dcx.lab.repository.DisciplinaDAORepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DisciplinaServicesTest {
    DisciplinaMock disciplinaMock;
    @InjectMocks
    DisciplinaServices disciplinaServices;

    @Mock
    DisciplinaDAORepository repository;

    @BeforeEach
    void setUpMocks(){
        disciplinaMock = new DisciplinaMock();
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void insertDiscipline() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(1);

        DisciplinaRegisterDTO disciplinaRegisterDTO = disciplinaMock.mockDisciplinaDto(1);

        Mockito.lenient().when(repository.save(disciplina)).thenReturn(disciplina);

        disciplinaServices.insertDiscipline(disciplinaRegisterDTO);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteDiscipline() {
    }

    @Test
    void updateDiscipline() {
    }

    @Test
    void insertNota() {
    }

    @Test
    void insertLike() {
    }

    @Test
    void findRankingNotas() {
    }

    @Test
    void findRankingLikes() {
    }

    @Test
    void findByTagName() {
    }

    @Test
    void findByName() {
    }
}
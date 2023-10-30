package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.disciplina.DisciplinaDTO;
import br.ufpb.dcx.lab.dto.nota.NotaDTO;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
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


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

        DisciplinaDTO disciplinaDTO = disciplinaMock.mockDisciplinaDto(1);

        Mockito.lenient().when(repository.save(disciplina)).thenReturn(disciplina);

        var result = disciplinaServices.insertDiscipline(disciplinaDTO);

        assertNotNull(result);
        System.out.println(result);
        assertNotNull(result.getName());
        assertEquals("Disciplina 1", result.getName());
    }

    @Test
    void findById() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(1);

        DisciplinaDTO disciplinaDTO = disciplinaMock.mockDisciplinaDto(1);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(disciplina));

        var result = disciplinaServices.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals("Disciplina 1", result.getName());
    }

    @Test
    void findAll() {
        List<Disciplina> disciplinaList = disciplinaMock.mockListDisciplinas();

        Mockito.lenient().when(repository.findAll()).thenReturn(disciplinaList);

        var result = disciplinaServices.findAll();

        var disciplineOne = result.get(1);

        assertNotNull(result);
        assertEquals(10, result.size());

        assertEquals("Disciplina 1", disciplineOne.getName());
    }

    @Test
    void deleteDiscipline() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(1);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(disciplina));

        disciplinaServices.deleteDiscipline(1L);
    }

    @Test
    void updateDiscipline() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(1);

        DisciplinaDTO disciplinaDTO = disciplinaMock.mockDisciplinaDto(1);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(disciplina));
        Mockito.lenient().when(repository.save(disciplina)).thenReturn(disciplina);

        var result = disciplinaServices.updateDiscipline(disciplinaDTO,1L);

        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals("Disciplina 1", result.getName());
    }

    @Test
    void insertNota() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(1);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(disciplina));
        Mockito.lenient().when(repository.save(disciplina)).thenReturn(disciplina);

        NotaDTO notaDTO = new NotaDTO(8.0);

        var result = disciplinaServices.insertNota(1L, notaDTO);

        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getNotas());
        assertTrue(result.getNotas().contains(8.0));
    }

    @Test
    void insertLike() {
        Disciplina disciplina = disciplinaMock.mockDisciplina(0);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(disciplina));
        Mockito.lenient().when(repository.save(disciplina)).thenReturn(disciplina);

        var result = disciplinaServices.insertLike(1L);

        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getLikes());
        assertEquals(1, result.getLikes());
    }

    @Test
    void findRankingNotas() {
        List<Disciplina> disciplinaList = disciplinaMock.mockListDisciplinas();

        Mockito.lenient().when(repository.findAll()).thenReturn(disciplinaList);

        var result = disciplinaServices.findRankingNotas();

        var disciplineOne = result.get(1);
        disciplineOne.getNotas().add(9.0);

        assertNotNull(result);
        assertEquals(10, result.size());
        assertTrue(disciplineOne.getNotas().contains(9.0));
    }

    @Test
    void findRankingLikes() {
        List<Disciplina> disciplinaList = disciplinaMock.mockListDisciplinas();

        Mockito.lenient().when(repository.findAll()).thenReturn(disciplinaList);

        var result = disciplinaServices.findRankingLikes();

        var disciplineOne = result.get(1);

        assertNotNull(result);
        assertNotNull(disciplineOne);
        assertEquals("Disciplina 1", disciplineOne.getName());
        assertEquals(10, result.size());
    }

    @Test
    void findByTagName() {
        List<Disciplina> disciplinaList = disciplinaMock.mockListDisciplinas();

        Mockito.lenient().when(repository.findByTagsNameIgnoreCase("nameTag")).thenReturn(disciplinaList);

        var result = disciplinaServices.findByTagName("nameTag");

        var disciplineOne = result.get(1);

        assertNotNull(result);
        assertNotNull(disciplineOne);
        assertEquals("Disciplina 1", disciplineOne.getName());
        assertEquals(10, result.size());
    }

    @Test
    void findByName() {
        List<Disciplina> disciplinaList = disciplinaMock.mockListDisciplinas();

        Mockito.lenient().when(repository.findByNameContainingIgnoreCase("nameDiscipline")).thenReturn(disciplinaList);

        var result = disciplinaServices.findByName("nameDiscipline");

        var disciplineOne = result.get(1);

        assertNotNull(result);
        assertNotNull(disciplineOne);
        assertEquals("Disciplina 1", disciplineOne.getName());
        assertEquals(10, result.size());
    }
}
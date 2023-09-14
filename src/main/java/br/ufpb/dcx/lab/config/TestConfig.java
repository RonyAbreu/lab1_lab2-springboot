package br.ufpb.dcx.lab.config;

import br.ufpb.dcx.lab.entities.Comentario;
import br.ufpb.dcx.lab.entities.Disciplina;
import br.ufpb.dcx.lab.entities.Tag;
import br.ufpb.dcx.lab.repository.ComentarioDAORepository;
import br.ufpb.dcx.lab.repository.DisciplinaDAORepository;
import br.ufpb.dcx.lab.repository.TagDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private DisciplinaDAORepository disciplinaDAORepository;
    @Autowired
    private ComentarioDAORepository comentarioDAORepository;
    @Autowired
    private TagDAORepository tagDAORepository;
    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Disciplina dis1 = new Disciplina(null,"Português",0);
        Disciplina dis2 = new Disciplina(null,"Matemática",0);
        Disciplina dis3 = new Disciplina(null,"História",0);

        Comentario c1 = new Comentario(null, LocalDate.parse("11/10/2000",dtf),"Eu não gosto de português",false,dis1);
        Comentario c2 = new Comentario(null, LocalDate.now(),"Muito bom",false,dis2);
        Comentario c3 = new Comentario(null, LocalDate.parse("01/01/2001",dtf),"Gostei bastante",false,dis3);

        dis1.getComentarios().add(c1);
        dis2.getComentarios().add(c2);
        dis3.getComentarios().add(c3);

        disciplinaDAORepository.saveAll(Arrays.asList(dis1,dis2,dis3));
        comentarioDAORepository.saveAll(Arrays.asList(c1,c2,c3));

        Tag t1 = new Tag(null, "Ruim");
        Tag t2 = new Tag(null, "Massante");
        Tag t3 = new Tag(null, "Excelente");

        dis1.getTags().add(t1);
        dis2.getTags().add(t2);
        dis3.getTags().add(t3);

        tagDAORepository.saveAll(Arrays.asList(t1,t2,t3));

        List<Double> notas1 = new ArrayList<>(Arrays.asList(7.7,10.0,8.4));
        dis1.getNotas().addAll(notas1);

        disciplinaDAORepository.saveAll(Arrays.asList(dis1,dis2,dis3));
    }
}

package br.ufpb.dcx.lab1.config;

import br.ufpb.dcx.lab1.entities.Disciplina;
import br.ufpb.dcx.lab1.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Override
    public void run(String... args) throws Exception {
        Disciplina d1 = new Disciplina("Matemática",20);

        disciplinaRepository.save(d1);
    }
}

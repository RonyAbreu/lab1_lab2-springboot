package br.ufpb.dcx.lab1.services;

import br.ufpb.dcx.lab1.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository repository;
}

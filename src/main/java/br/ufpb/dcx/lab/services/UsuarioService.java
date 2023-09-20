package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.repository.UsuarioDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAORepository usuarioDAORepository;


}

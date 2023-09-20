package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.usuario.UsuarioRegisterDTO;
import br.ufpb.dcx.lab.entities.Usuario;
import br.ufpb.dcx.lab.repository.UsuarioDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAORepository usuarioDAORepository;

    public void create(UsuarioRegisterDTO usuarioDeRegistro) throws Exception {
        Optional<Usuario> usuarioPeloEmail = usuarioDAORepository.findByEmail(usuarioDeRegistro.getEmail());

        if(usuarioPeloEmail.isPresent()){
            throw new Exception("Usuário já existe!");
        }

        Usuario usuarioParaSerRegistrado = new Usuario(usuarioDeRegistro);

        usuarioDAORepository.save(usuarioParaSerRegistrado);
    }
}

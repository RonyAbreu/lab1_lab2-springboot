package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.usuario.UsuarioDeRegistro;
import br.ufpb.dcx.lab.entities.Usuario;
import br.ufpb.dcx.lab.repository.UsuarioRepository;
import br.ufpb.dcx.lab.services.exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.lab.services.exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.lab.services.exceptions.UsuarioNaoTemPermissaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository repository;
    private JWTService jwtService;

    @Autowired
    public UsuarioService(UsuarioRepository repository, JWTService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }

    public Usuario cadastraUsuario(UsuarioDeRegistro usuarioDeRegistro){
        if (usuarioExiste(usuarioDeRegistro.email())){
            throw new UsuarioJaExisteException("Usuário já existe!");
        }

        Usuario usuarioParaSalvar = new Usuario(usuarioDeRegistro);
        repository.save(usuarioParaSalvar);

        return usuarioParaSalvar;
    }

    private boolean usuarioExiste(String email){
        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        return usuarioOptional.isPresent();
    }

    private boolean usuarioTemPermissao(String header, String email){
        String sujeitoDoToken = jwtService.pegaSujeitoDoToken(header);
        Optional<Usuario> usuarioOptional = repository.findByEmail(sujeitoDoToken);
        return usuarioOptional.isPresent() && usuarioOptional.get().getEmail().equals(email);
    }

    public Usuario buscaUsuario(String header, String email){
        if (!usuarioExiste(email)){
            throw new UsuarioNaoExisteException("Usuario não existe");
        }
        if (!usuarioTemPermissao(header, email)){
            throw new UsuarioNaoTemPermissaoException("Usuario não tem permissão!");
        }
        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        return usuarioOptional.get();
    }

    public void removeUsuario(String header, String email){
        if (!usuarioExiste(email)){
            throw new UsuarioNaoExisteException("Usuario não existe");
        }
        if (!usuarioTemPermissao(header, email)){
            throw new UsuarioNaoTemPermissaoException("Usuario não tem permissão!");
        }
        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        repository.delete(usuarioOptional.get());
    }
}

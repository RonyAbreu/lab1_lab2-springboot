package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.dto.usuario.TokenDoUsuario;
import br.ufpb.dcx.lab.dto.usuario.UsuarioDeRegistro;
import br.ufpb.dcx.lab.dto.usuario.UsuarioLogin;
import br.ufpb.dcx.lab.entities.Usuario;
import br.ufpb.dcx.lab.services.JWTService;
import br.ufpb.dcx.lab.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api")
public class UsuarioLoginController {
    private JWTService jwtService;
    private UsuarioService service;
    @Autowired
    public UsuarioLoginController(JWTService jwtService, UsuarioService service) {
        this.jwtService = jwtService;
        this.service = service;
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody UsuarioDeRegistro usuarioDeRegistro){
        var usuarioParaCadastrar = service.cadastraUsuario(usuarioDeRegistro);
        return ResponseEntity.ok(usuarioParaCadastrar);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDoUsuario> autenticaUsuario(@RequestBody UsuarioLogin usuarioLogin){
        var tokenDoUsuario = jwtService.autenticaUsuario(usuarioLogin);
        return ResponseEntity.ok(tokenDoUsuario);
    }
}

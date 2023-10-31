package br.ufpb.dcx.lab.controller;

import br.ufpb.dcx.lab.entities.Usuario;
import br.ufpb.dcx.lab.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api/auth/usuarios")
public class UsuarioController {
    private UsuarioService service;
    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping(value = "/{email}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Usuario> buscaUsuario(@PathVariable String email, @RequestHeader("Authorization") String header){
        var usuarioRetornado = service.buscaUsuario(header,email);
        return ResponseEntity.ok(usuarioRetornado);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> removeUsuario(@PathVariable String email, @RequestHeader("Authorization") String header){
        service.removeUsuario(header, email);
        return ResponseEntity.ok().build();
    }
}

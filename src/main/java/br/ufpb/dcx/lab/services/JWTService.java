package br.ufpb.dcx.lab.services;

import br.ufpb.dcx.lab.dto.usuario.TokenDoUsuario;
import br.ufpb.dcx.lab.dto.usuario.UsuarioLogin;
import br.ufpb.dcx.lab.entities.Usuario;
import br.ufpb.dcx.lab.repository.UsuarioRepository;
import br.ufpb.dcx.lab.services.exceptions.LoginInvalidoException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class JWTService {
    public static final Key TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private UsuarioRepository repository;
    @Autowired
    public JWTService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public TokenDoUsuario autenticaUsuario(UsuarioLogin usuarioLogin){
        Optional<Usuario> usuarioOptional = repository.findByEmailAndSenha(usuarioLogin.email(), usuarioLogin.senha());

        if (usuarioOptional.isEmpty()){
            throw new LoginInvalidoException("Login inválido!");
        }

        String token = geraToken(usuarioLogin.email());
        return new TokenDoUsuario(token);
    }

    private String geraToken(String email) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .signWith(TOKEN_KEY, SignatureAlgorithm.HS512)
                .setExpiration(tempoDoToken())
                .compact();
    }

    private Date tempoDoToken() {
        return Date.from(Instant.now().plusSeconds(60 * 5));
    }

    public String pegaSujeitoDoToken(String header){
        if (header == null || !header.startsWith("Bearer ")){
            throw new SecurityException("Token inválido!!");
        }

        String token = header.substring(7);

        String sujeito;
        try {
            JwtParser parser = Jwts.parserBuilder().setSigningKey(TOKEN_KEY).build();
            sujeito = parser.parseClaimsJws(token).getBody().getSubject();
        }catch (SignatureException e){
            throw new SecurityException("Token mal formatado, ou inválido!");
        }
        return sujeito;
    }
}

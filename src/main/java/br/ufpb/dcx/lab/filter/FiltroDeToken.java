package br.ufpb.dcx.lab.filter;

import br.ufpb.dcx.lab.services.JWTService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class FiltroDeToken extends GenericFilterBean {
    public static final int TOKEN_INDEX = 7;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido (FT)!");
            return;
        }

        String token = header.substring(TOKEN_INDEX);

        try {
            JwtParser parser = Jwts.parserBuilder().setSigningKey(JWTService.TOKEN_KEY).build();
            parser.parseClaimsJws(token).getBody();
        }catch (SignatureException | MalformedJwtException | UnsupportedJwtException | ExpiredJwtException |PrematureJwtException | IllegalArgumentException e){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        chain.doFilter(request, response);
    }
}

package br.ufpb.dcx.lab.services.exceptions;

public class UsuarioJaExisteException extends RuntimeException{
    public UsuarioJaExisteException(String mensagem){
        super(mensagem);
    }
}

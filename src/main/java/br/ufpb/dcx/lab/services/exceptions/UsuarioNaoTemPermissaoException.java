package br.ufpb.dcx.lab.services.exceptions;

public class UsuarioNaoTemPermissaoException extends RuntimeException{
    public UsuarioNaoTemPermissaoException(String mensagem){
        super(mensagem);
    }
}

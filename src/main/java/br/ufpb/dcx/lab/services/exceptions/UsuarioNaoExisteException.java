package br.ufpb.dcx.lab.services.exceptions;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException(String mensagem) {
        super(mensagem);
    }
}

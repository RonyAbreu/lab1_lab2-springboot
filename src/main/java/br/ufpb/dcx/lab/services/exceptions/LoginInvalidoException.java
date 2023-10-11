package br.ufpb.dcx.lab.services.exceptions;

public class LoginInvalidoException  extends RuntimeException{
    public LoginInvalidoException(String mensagem){
        super(mensagem);
    }
}

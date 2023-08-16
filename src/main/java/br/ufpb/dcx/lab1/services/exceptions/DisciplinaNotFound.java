package br.ufpb.dcx.lab1.services.exceptions;

public class DisciplinaNotFound extends RuntimeException{
    public DisciplinaNotFound(String msg){
        super(msg);
    }
}

package br.ufpb.dcx.lab.services.exceptions;

public class DisciplinaNotFound extends RuntimeException{
    public DisciplinaNotFound(String msg){
        super(msg);
    }
}

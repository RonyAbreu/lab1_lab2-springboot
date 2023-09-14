package br.ufpb.dcx.lab.services.exceptions;
public class DisciplinaAlreadyExistsException extends RuntimeException{

    public DisciplinaAlreadyExistsException(String msg){
        super(msg);
    }
}

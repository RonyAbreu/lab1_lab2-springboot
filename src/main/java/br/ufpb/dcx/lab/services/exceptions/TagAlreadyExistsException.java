package br.ufpb.dcx.lab.services.exceptions;

public class TagAlreadyExistsException extends RuntimeException{
    public TagAlreadyExistsException(String msg){
        super(msg);
    }
}

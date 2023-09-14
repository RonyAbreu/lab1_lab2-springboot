package br.ufpb.dcx.lab.controller.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, String message, Integer code, String path) {
        super(timestamp, message, code, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String field, String message){
        erros.add(new FieldMessage(field, message));
    }
}

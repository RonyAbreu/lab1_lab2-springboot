package br.ufpb.dcx.lab.controller.exceptions;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class FieldMessage implements Serializable {
    private final String field;
    private final String message;
}

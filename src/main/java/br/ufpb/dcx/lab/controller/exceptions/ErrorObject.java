package br.ufpb.dcx.lab.controller.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
}

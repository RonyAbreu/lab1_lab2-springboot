package br.ufpb.dcx.lab.controller.exceptions;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
public class StandardError implements Serializable {
    private final Instant timestamp;
    private final String message;
    private final Integer code;
}

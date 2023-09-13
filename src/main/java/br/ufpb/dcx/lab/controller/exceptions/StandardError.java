package br.ufpb.dcx.lab.controller.exceptions;

import lombok.*;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter

public class StandardError {
    private final String message;
    private final Integer code;
    private final String status;
    private final String objectName;
    private final List<ErrorObject> erros;
}

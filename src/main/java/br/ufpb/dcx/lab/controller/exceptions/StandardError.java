package br.ufpb.dcx.lab.controller.exceptions;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError implements Serializable {
    private Instant timestamp;
    private String message;
    private Integer code;
    private String path;
}

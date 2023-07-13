package com.iiht.fse4.skilltracker.common.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String correlationId;
    private List<Error> errors;

    public ErrorResponse(String correlationId, Error error) {
        super();
        this.correlationId = correlationId;
        addError(error);
    }

    public void addError(Error error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }
}

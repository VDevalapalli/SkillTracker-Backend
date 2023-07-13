package com.iiht.fse4.skilltracker.common.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class Error {
    private String type;
    private String code;
    private String message;

    public Error(String type, int code, String message) {
        super();
        this.type = type;
        this.code = String.valueOf(code);
        this.message = message;
    }
}

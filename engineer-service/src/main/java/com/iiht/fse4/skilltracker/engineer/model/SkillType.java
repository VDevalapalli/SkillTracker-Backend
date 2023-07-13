package com.iiht.fse4.skilltracker.engineer.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum SkillType {
    TECHNICAL("TECHNICAL"), NON_TECHNICAL("NON_TECHNICAL");

    private String value;

    public String getValue() {
        return value;
    }
}
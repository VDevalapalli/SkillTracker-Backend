package com.iiht.fse4.skilltracker.common.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.ToString;

public enum NonTechnicalSkillType {
    SPOKEN("SPOKEN"), COMMUNICATION("COMMUNICATION"), APTITUDE("APTITUDE");

    private String value;

    NonTechnicalSkillType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static NonTechnicalSkillType fromValue(String text) {
        if (text != null) {
            for (NonTechnicalSkillType obj : NonTechnicalSkillType.values()) {
                if (obj.value.equals(text)) {
                    return obj;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

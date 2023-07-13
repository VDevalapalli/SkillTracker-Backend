package com.iiht.fse4.skilltracker.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.ToString;

public enum TechnicalSkillType {
    HTML_CSS_JAVASCRIPT("HTML-CSS-JAVASCRIPT"), ANGULAR("ANGULAR"), REACT("REACT"), SPRING("SPRING"), RESTFUL("RESTFUL"),
    HIBERNATE("HIBERNATE"), GIT("GIT"), DOCKER("DOCKER"), JENKINS("JENKINS"), AWS("AWS");

    private String value;

    TechnicalSkillType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public TechnicalSkillType createFromValue(String text) {
        if (text != null) {
            for (TechnicalSkillType obj : TechnicalSkillType.values()) {
                if (obj.value.equals(text)) {
                    return obj;
                }
            }
            throw new RuntimeException(CommonConstants.INVALID_SKILL_TYPE_MSG);
        }
        return null;
    }

    public static TechnicalSkillType fromValue(String text) {
        if (text != null) {
            for (TechnicalSkillType obj : TechnicalSkillType.values()) {
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

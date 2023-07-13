package com.iiht.fse4.skilltracker.common.model;

import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.ToString;

public enum CriteriaType {
    NAME("NAME"), ASSOCIATE_ID("ASSOCIATE_ID"), SKILL("SKILL");

    private String value;

    CriteriaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CriteriaType createFromValue(String text) {
        if (text != null) {
            for (CriteriaType obj : CriteriaType.values()) {
                if (obj.value.equals(text)) {
                    return obj;
                }
            }
            throw new RuntimeException(CommonConstants.INVALID_CRITERIA_TYPE_MSG);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

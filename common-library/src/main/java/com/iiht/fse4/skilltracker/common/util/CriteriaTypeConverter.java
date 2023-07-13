package com.iiht.fse4.skilltracker.common.util;

import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import lombok.NoArgsConstructor;

import java.beans.PropertyEditorSupport;

@NoArgsConstructor
public class CriteriaTypeConverter extends PropertyEditorSupport {
    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(CriteriaType.createFromValue(text));
    }
}

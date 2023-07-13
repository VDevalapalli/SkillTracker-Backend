package com.iiht.fse4.skilltracker.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class TechnicalSkill extends Skill {

    @NotNull(message = "is mandatory field")
    private TechnicalSkillType skillName;

    public TechnicalSkillType getSkillName() {
        return skillName;
    }

    public void setSkillName(TechnicalSkillType skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "TechnicalSkill[" +
                "skillName=" + skillName +
                ", expertiseLevel=" + expertiseLevel +
                ']';
    }
}

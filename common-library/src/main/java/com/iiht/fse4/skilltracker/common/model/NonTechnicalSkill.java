package com.iiht.fse4.skilltracker.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class NonTechnicalSkill extends Skill {

    @NotNull(message = "is mandatory field")
    private NonTechnicalSkillType skillName;

    public NonTechnicalSkillType getSkillName() {
        return skillName;
    }

    public void setSkillName(NonTechnicalSkillType skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "NonTechnicalSkill[" +
                "skillName=" + skillName +
                ", expertiseLevel=" + expertiseLevel +
                ']';
    }
}

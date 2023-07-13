package com.iiht.fse4.skilltracker.common.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Skill {

    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=20, message="must be equal or less than 20")
    protected int expertiseLevel;

    public Skill() {
        this.expertiseLevel = -1;
    }

    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }

    @Override
    public String toString() {
        return "Skill[" +
                "expertiseLevel=" + expertiseLevel +
                ']';
    }
}
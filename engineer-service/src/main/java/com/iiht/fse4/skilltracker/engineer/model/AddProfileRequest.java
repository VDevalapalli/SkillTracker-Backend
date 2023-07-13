package com.iiht.fse4.skilltracker.engineer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iiht.fse4.skilltracker.common.model.SkillProfile;

@JsonIgnoreProperties({ "profileId" })
public class AddProfileRequest extends SkillProfile {

    @Override
    public String toString() {
        return "AddProfileRequest [profileId=" + profileId + ", profileName=" + profileName + ", associateId="
                + associateId + ", mobile=" + mobile + ", email=" + email + ", technicalSkills=" + technicalSkills
                + ", nonTechnicalSkills=" + nonTechnicalSkills + "]";
    }
}

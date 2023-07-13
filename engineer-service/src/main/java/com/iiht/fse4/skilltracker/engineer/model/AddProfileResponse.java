package com.iiht.fse4.skilltracker.engineer.model;

import com.iiht.fse4.skilltracker.common.model.SkillProfile;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
public class AddProfileResponse extends SkillProfile {
    public AddProfileResponse(SkillProfile skillProfile) {
        super();
        this.profileId = skillProfile.getProfileId();
        this.profileName = skillProfile.getProfileName();
        this.associateId = skillProfile.getAssociateId();
        this.mobile = skillProfile.getMobile();
        this.email = skillProfile.getEmail();
        this.technicalSkills = skillProfile.getTechnicalSkills();
        this.nonTechnicalSkills = skillProfile.getNonTechnicalSkills();
    }
}

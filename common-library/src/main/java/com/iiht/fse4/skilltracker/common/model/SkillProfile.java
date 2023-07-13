package com.iiht.fse4.skilltracker.common.model;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class SkillProfile {

    protected long profileId;

    @NotBlank(message = "is mandatory field")
    @Size(min = 5, max = 30, message = "allows min 5 and max 30 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{5,30}$", message = "must be alphanumeric")
    protected String profileName;

    @NotBlank(message = "is mandatory field")
    @Size(min = 5, max = 30, message = "allows min 5 and max 30 characters")
    @Pattern(regexp = "^CTS[0-9]{2,27}$", message = "must start with CTS and followed by numerics")
    protected String associateId;

    @NotBlank(message = "is mandatory field")
    @Size(min = 10, max = 10, message = "should contains 10 characters")
    @Pattern(regexp = "^[0-9]{10}$", message = "should contains numeric characters")
    protected String mobile;

    @NotBlank(message = "is mandatory field")
    @Size(min = 5, max = 30, message = "allows min 5 and max 30 characters")
    @Email(message = "must be in valid format")
    protected String email;

    @Valid
    @NotEmpty(message = "are required")
    protected List<@NotNull TechnicalSkill> technicalSkills;

    @Valid
    @NotEmpty(message = "are required")
    protected List<@NotNull NonTechnicalSkill> nonTechnicalSkills;

    /**
     * @param technicalSkill
     */
    public void addTechnicalSkill(TechnicalSkill technicalSkill) {
        if (this.technicalSkills == null) {
            this.technicalSkills = new ArrayList<>();
        }
        this.technicalSkills.add(technicalSkill);
    }

    /**
     * @param nonTechnicalSkill
     */
    public void addNonTechnicalSkill(NonTechnicalSkill nonTechnicalSkill) {
        if (this.nonTechnicalSkills == null) {
            this.nonTechnicalSkills = new ArrayList<>();
        }
        this.nonTechnicalSkills.add(nonTechnicalSkill);
    }


    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TechnicalSkill> getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(List<TechnicalSkill> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public List<NonTechnicalSkill> getNonTechnicalSkills() {
        return nonTechnicalSkills;
    }

    public void setNonTechnicalSkills(List<NonTechnicalSkill> nonTechnicalSkills) {
        this.nonTechnicalSkills = nonTechnicalSkills;
    }

    @Override
    public String toString() {
        return "SkillProfile[" +
                "profileId=" + profileId +
                ", profileName='" + profileName + '\'' +
                ", associateId='" + associateId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", technicalSkills=" + technicalSkills +
                ", nonTechnicalSkills=" + nonTechnicalSkills +
                ']';
    }
}

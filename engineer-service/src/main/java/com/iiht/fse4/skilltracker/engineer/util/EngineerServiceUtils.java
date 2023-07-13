package com.iiht.fse4.skilltracker.engineer.util;

import com.iiht.fse4.skilltracker.common.aspect.TrackElapsedTime;
import com.iiht.fse4.skilltracker.common.model.*;
import com.iiht.fse4.skilltracker.engineer.entity.SkillEntity;
import com.iiht.fse4.skilltracker.engineer.entity.ProfileEntity;
import com.iiht.fse4.skilltracker.engineer.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public interface EngineerServiceUtils {
    @TrackElapsedTime
    static ProfileEntity convertToEntity(SkillProfile skillProfile) {
        if (skillProfile != null) {
            final ProfileEntity profileEntity = new ProfileEntity();
            profileEntity.setProfileName(skillProfile.getProfileName());
            profileEntity.setAssociateId(skillProfile.getAssociateId());
            profileEntity.setMobile(skillProfile.getMobile());
            profileEntity.setEmail(skillProfile.getEmail());
            profileEntity.setLastUpdatedTime(LocalDateTime.now());
            Set<SkillEntity> skillEntities = new HashSet<>();
            Optional.ofNullable(skillProfile.getTechnicalSkills()).orElse(new ArrayList<>()).stream().forEach(obj -> {
                SkillEntity skillEntityObj = new SkillEntity();
                skillEntityObj.setSkillName(obj.getSkillName().getValue());
                skillEntityObj.setSkillType(SkillType.TECHNICAL);
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                skillEntities.add(skillEntityObj);
            });
            Optional.ofNullable(skillProfile.getNonTechnicalSkills()).orElse(new ArrayList<>()).stream().forEach(obj -> {
                SkillEntity skillEntityObj = new SkillEntity();
                skillEntityObj.setSkillName(obj.getSkillName().getValue());
                skillEntityObj.setSkillType(SkillType.NON_TECHNICAL);
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                skillEntities.add(skillEntityObj);
            });
            skillEntities.stream().forEach(obj -> {
                SkillEntity skillEntityObj = new SkillEntity();
                skillEntityObj.setSkillName(obj.getSkillName());
                skillEntityObj.setSkillType(obj.getSkillType());
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                profileEntity.addSkill(skillEntityObj);
            });
            return profileEntity;
        }
        return null;
    }

    @TrackElapsedTime
    static SkillProfile convertToModel(ProfileEntity profileEntity) {
        if (profileEntity != null) {
            final SkillProfile skillProfileObj = new SkillProfile();
            skillProfileObj.setProfileId(profileEntity.getProfileId());
            skillProfileObj.setProfileName(profileEntity.getProfileName());
            skillProfileObj.setAssociateId(profileEntity.getAssociateId());
            skillProfileObj.setMobile(profileEntity.getMobile());
            skillProfileObj.setEmail(profileEntity.getEmail());
            Optional.ofNullable(profileEntity.getSkills()).orElse(new HashSet<>()).stream().sorted((lObj, rObj) -> {
                return (lObj.getExpertiseLevel() < rObj.getExpertiseLevel()) ? 1 : -1;
            }).forEach(skillObj -> {
                if (SkillType.TECHNICAL.equals(skillObj.getSkillType())) {
                    TechnicalSkill technicalSkill = new TechnicalSkill();
                    technicalSkill.setSkillName(TechnicalSkillType.fromValue(skillObj.getSkillName()));
                    technicalSkill.setExpertiseLevel(skillObj.getExpertiseLevel());
                    skillProfileObj.addTechnicalSkill(technicalSkill);
                } else {
                    NonTechnicalSkill ntsObj = new NonTechnicalSkill();
                    ntsObj.setSkillName(NonTechnicalSkillType.fromValue(skillObj.getSkillName()));
                    ntsObj.setExpertiseLevel(skillObj.getExpertiseLevel());
                    skillProfileObj.addNonTechnicalSkill(ntsObj);
                }
            });
            return skillProfileObj;
        }
        return null;
    }

    @TrackElapsedTime
    public static ProfileEntity updateSkillEntity(ProfileEntity profileEntity, UpdateProfileRequest request) {
        if (profileEntity != null) {
            profileEntity.setLastUpdatedTime(LocalDateTime.now());
            Map<String, SkillEntity> skillEntityMap = Optional.of(profileEntity.getSkills()).orElse(new HashSet<>())
                    .stream()
                    .collect(Collectors.toMap(obj -> obj.getSkillName(), obj -> obj, (oldObj, newObj) -> newObj));
            Set<SkillEntity> skillEntities = new HashSet<>();
            Optional.ofNullable(request.getTechnicalSkills()).orElse(new ArrayList<>()).stream().forEach(obj -> {
                SkillEntity skillEntityObj = new SkillEntity();
                skillEntityObj.setSkillName(obj.getSkillName().getValue());
                skillEntityObj.setSkillType(SkillType.TECHNICAL);
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                skillEntities.add(skillEntityObj);
            });
            Optional.ofNullable(request.getNonTechnicalSkills()).orElse(new ArrayList<>()).stream().forEach(obj -> {
                SkillEntity skillEntityObj = new SkillEntity();
                skillEntityObj.setSkillName(obj.getSkillName().getValue());
                skillEntityObj.setSkillType(SkillType.NON_TECHNICAL);
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                skillEntities.add(skillEntityObj);
            });
            skillEntities.stream().forEach(obj -> {
                SkillEntity skillEntityObj = skillEntityMap.getOrDefault(obj.getSkillName(), new SkillEntity());
                skillEntityObj.setSkillName(obj.getSkillName());
                skillEntityObj.setSkillType(obj.getSkillType());
                skillEntityObj.setExpertiseLevel(obj.getExpertiseLevel());
                profileEntity.addSkill(skillEntityObj);
            });
        }
        return profileEntity;
    }

}

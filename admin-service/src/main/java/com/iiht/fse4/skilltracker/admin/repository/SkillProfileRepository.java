package com.iiht.fse4.skilltracker.admin.repository;

import com.iiht.fse4.skilltracker.common.model.SkillProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillProfileRepository extends MongoRepository<SkillProfile, Long> {

    List<SkillProfile> findSkillProfilesByProfileNameStartsWith(String profileName);

    List<SkillProfile> findSkillProfilesByAssociateId(String associateId);

    SkillProfile findSkillProfileByAssociateId(String associateId);

    @Query("SELECT u FROM SkillProfile AS u JOIN u.skills AS s WHERE s.skillName = :skillName AND s.expertiseLevel > 10")
    List<SkillProfile> findBySkillNameAndExpertiseLevel(@Param("skillName") String skillName);


}

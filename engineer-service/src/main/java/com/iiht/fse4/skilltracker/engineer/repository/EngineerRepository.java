package com.iiht.fse4.skilltracker.engineer.repository;

import com.iiht.fse4.skilltracker.engineer.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<ProfileEntity, Long> {

    List<ProfileEntity> findByAssociateId(String associateId);

    List<ProfileEntity> findByProfileNameStartsWith(String profileName);

    Boolean existsByAssociateId(String associateId);

    @Query("SELECT u FROM ProfileEntity AS u JOIN u.skills AS s WHERE s.skillName = :skillName AND s.expertiseLevel > 10")
    List<ProfileEntity> findBySkillNameAndExpertiseLevel(@Param("skillName") String skillName);
}

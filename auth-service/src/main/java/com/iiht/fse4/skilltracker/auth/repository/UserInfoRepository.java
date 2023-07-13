package com.iiht.fse4.skilltracker.auth.repository;

import com.iiht.fse4.skilltracker.auth.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    Optional<UserInfoEntity> findByUserName(String userName);
}

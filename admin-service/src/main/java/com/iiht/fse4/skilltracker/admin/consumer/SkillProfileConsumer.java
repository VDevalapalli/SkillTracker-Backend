package com.iiht.fse4.skilltracker.admin.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiht.fse4.skilltracker.admin.repository.SkillProfileRepository;
import com.iiht.fse4.skilltracker.admin.service.SkillProfileService;
import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.model.ProfileEvent;
import com.iiht.fse4.skilltracker.common.model.SkillProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SkillProfileConsumer {

    @Autowired
    SkillProfileService skillProfileService;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.groupId}")
    public void consumeProfile(ProfileEvent profileEvent) {
        log.info(String.format("Profile event received =>" + profileEvent.toString()));
        try {
            this.updateSkillProfile(profileEvent);
        } catch (Exception ex) {
            log.error(Constants.KAFKA_UPDATE_PROFILE_EXCEPTION, ex);
        }
        log.info("{} method End", Constants.CONSUME_USER_SKILL_ENTITY);
    }

    @Transactional
    public void updateSkillProfile(ProfileEvent profileEvent) {
        SkillProfile skillProfile = skillProfileService.saveProfile(profileEvent.getSkillProfile());
    }
}

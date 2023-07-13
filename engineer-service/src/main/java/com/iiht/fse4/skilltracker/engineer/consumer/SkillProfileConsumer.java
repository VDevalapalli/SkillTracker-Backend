//package com.iiht.fse4.skilltracker.engineer.consumer;
//
//import com.iiht.fse4.skilltracker.common.model.ProfileEvent;
//import com.iiht.fse4.skilltracker.common.util.CommonConstants;
//import com.iiht.fse4.skilltracker.engineer.entity.ProfileEntity;
//import com.iiht.fse4.skilltracker.engineer.repository.EngineerRepository;
//import com.iiht.fse4.skilltracker.engineer.util.Constants;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class SkillProfileConsumer {
//    @Autowired
//    private EngineerRepository engineerRepository;
//
//    @KafkaListener(topics = "profile_topic", groupId = "profile_group", containerFactory = "kafkaListenerContainerFactory")
//    public void consumeProfileEntity(ProfileEvent profileEvent) {
//        log.info(CommonConstants.METHOD_START, Constants.CONSUME_PROFILE_ENTITY);
//        try {
//            //engineerRepository.save(profileEntity);
//        } catch (Exception ex) {
//            log.error(Constants.KAFLA_UPDATE_PROFILE_EXP_LOG_MSG, ex);
//        }
//        log.info(CommonConstants.METHOD_END, Constants.CONSUME_PROFILE_ENTITY);
//    }
//}

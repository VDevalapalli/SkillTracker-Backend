package com.iiht.fse4.skilltracker.engineer.producer;

import com.iiht.fse4.skilltracker.common.model.ProfileEvent;
import com.iiht.fse4.skilltracker.engineer.entity.ProfileEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillProfileProducer {
    private final KafkaTemplate<String, ProfileEvent> kafkaTemplate;

//    @Value("${spring.kafka.topic}")
//    private NewTopic profileTopic;

    @Autowired
    private NewTopic profileTopic;

    public void sendUserSkillProfile(ProfileEvent profileEvent){
        log.info(String.format("Profile event => " + profileEvent.toString()));

        //Create Message
        Message<ProfileEvent> message = MessageBuilder
                .withPayload(profileEvent)
                        .setHeader(KafkaHeaders.TOPIC, profileTopic.name())
                                .build();

        kafkaTemplate.send(message);
    }
}

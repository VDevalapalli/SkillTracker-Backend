package com.iiht.fse4.skilltracker.admin.client;

import com.iiht.fse4.skilltracker.admin.config.FeignClientConfig;
import com.iiht.fse4.skilltracker.admin.hystrix.EngineerServiceFallBack;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "engineer-service", url = "http://localhost:8081/skill-tracker", configuration = FeignClientConfig.class, fallback = EngineerServiceFallBack.class)
public interface EngineerServiceClient {

//    @GetMapping(value = "/{criteria}/{criteriaValue}", produces = MediaType.APPLICATION_JSON_VALUE)
//    SearchProfileResponse searchProfile(@RequestHeader("Authorization") String accessToken,
//                                                        @PathVariable("criteria")CriteriaType criteria,
//                                                        @PathVariable("criteriaValue") String criteriaValue);


    @GetMapping(value = "/api/v1/engineer/{criteria}/{criteriaValue}", produces = MediaType.APPLICATION_JSON_VALUE)
    SearchProfileResponse searchProfile(@PathVariable("criteria")CriteriaType criteria,
                                        @PathVariable("criteriaValue") String criteriaValue);
}

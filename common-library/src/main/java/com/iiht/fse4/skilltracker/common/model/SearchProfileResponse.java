package com.iiht.fse4.skilltracker.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchProfileResponse {
    private List<SkillProfile> profiles;
}

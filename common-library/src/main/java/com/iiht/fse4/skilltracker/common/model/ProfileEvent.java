package com.iiht.fse4.skilltracker.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEvent {
    private String message;
    private String status;
    private SkillProfile skillProfile;
}

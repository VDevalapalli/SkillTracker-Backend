package com.iiht.fse4.skilltracker.engineer.model;

import com.iiht.fse4.skilltracker.common.model.NonTechnicalSkill;
import com.iiht.fse4.skilltracker.common.model.TechnicalSkill;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {
    @Valid
    @NotEmpty(message = "are required")
    private List<@NotNull TechnicalSkill> technicalSkills;

    @Valid
    @NotEmpty(message = "are required")
    private List<@NotNull NonTechnicalSkill> nonTechnicalSkills;

}

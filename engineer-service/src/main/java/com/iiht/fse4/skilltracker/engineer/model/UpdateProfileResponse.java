package com.iiht.fse4.skilltracker.engineer.model;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileResponse {
    private UpdateProfileRequest request;
    private String message;
}

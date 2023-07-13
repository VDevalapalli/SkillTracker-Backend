package com.iiht.fse4.skilltracker.engineer.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "skilltracker.profiles")
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "associate_id", unique = true)
    private String associateId;

    private String mobile;

    private String email;

    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdatedTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_ref_id", referencedColumnName = "profile_id")
    private Set<SkillEntity> skills;

    /**
     * @param skill
     */
    public void addSkill(SkillEntity skill) {
        if (this.skills == null) {
            this.skills = new HashSet<>();
        }
        this.skills.add(skill);
    }
}

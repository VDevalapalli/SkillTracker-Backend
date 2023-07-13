package com.iiht.fse4.skilltracker.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skilltracker.user_info")
public class UserInfoEntity {

    @Id
    @SequenceGenerator(name = "user_info_seq", sequenceName = "skilltracker.user_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq")
    @Column(name = "user_info_id")
    private int userInfoId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "user_first_name")
    private String userFirstName;
    @Column(name = "user_last_name")
    private String userLastName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "token")
    private String token;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;
}

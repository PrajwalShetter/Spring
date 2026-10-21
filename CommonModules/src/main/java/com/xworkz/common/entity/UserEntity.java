package com.xworkz.common.entity;

import com.xworkz.common.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_table")

@NamedQueries({
        @NamedQuery(name="findByEmail",query = "select user from UserEntity user where user.email=:email"),
        @NamedQuery(name="findByPhNo",query = "select user from UserEntity user where user.phone=:phone"),

})

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true,nullable = false)
    private Long phone;
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(name = "status")
    private Boolean status;

    @Column(name = "count")
    private Integer count;

    private String otp;

    @Column(name = "profile_pic")
    private String profilePic;

}

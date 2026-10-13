package com.xworkz.carepluse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_table")
@NamedQueries({
        @NamedQuery(name = "viewAllUsers", query = "select u from UserEntity u"),
        @NamedQuery(name = "getUserById", query = "select u from UserEntity u where u.id =: id"),
        @NamedQuery(name = "deleteUserById", query = "delete from UserEntity u where u.id =:id"),
})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long mobileNumber;
    private String password;
    private String role;
    private boolean active;
}

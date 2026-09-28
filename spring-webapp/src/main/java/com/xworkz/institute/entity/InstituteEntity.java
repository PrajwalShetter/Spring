package com.xworkz.institute.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institute_table")
@Entity
@NamedQueries({
        @NamedQuery(name = "deleteInstitute", query = "delete  from InstituteEntity where id =:id")
})
public class InstituteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String instituteName;
    private String address;
    private boolean isLicenced;
    private long contactNumber;
    private String email;

}

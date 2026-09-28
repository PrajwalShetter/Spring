package com.xworkz.institute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDto {

    private int id;
    private String instituteName;
    private String address;
    private boolean isLicenced;
    private long contactNumber;
    private String email;

}

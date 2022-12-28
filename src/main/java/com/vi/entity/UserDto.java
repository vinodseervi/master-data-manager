package com.vi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Date Dob;
    private String password;
}

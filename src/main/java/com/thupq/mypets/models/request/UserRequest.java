package com.thupq.mypets.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String code;

    private String userName;

    private String password;

    private String fullName;

    private String contactPhone;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date dateOfBirth;

    private String gender;

    private String description;

    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+7")
    private Instant createDate;

    @JsonIgnore
    private String createBy;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+7")
    private Instant updateDate;

    @JsonIgnore
    private String updateBy;
}
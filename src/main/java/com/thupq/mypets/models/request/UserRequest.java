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

    private String fullName;

    private String contactPhone;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String gender;

    private String description;

    private String status;

    @JsonIgnore
    private Instant createDate;

    @JsonIgnore
    private String createBy;

    @JsonIgnore
    private Instant updateDate;

    @JsonIgnore
    private String updateBy;
}
//trong postman nhập trường dateOfBirth dạng thế nào cho đúng
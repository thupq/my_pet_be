package com.thupq.mypets.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;

    private String code;

    private String userName;

    private String fullName;

    private String contactPhone;

    private String email;

    private Instant dateOfBirth;

    private String gender;

    private String description;

    private String status;

    private Instant createDate;

    private String createBy;

    private Instant updateDate;

    private String updateBy;
}

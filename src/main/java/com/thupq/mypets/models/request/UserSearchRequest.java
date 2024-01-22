package com.thupq.mypets.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {
    private String userName;

    private String status;

    private String contactPhone;

    private Instant fromDate;

    private Instant toDate;
}

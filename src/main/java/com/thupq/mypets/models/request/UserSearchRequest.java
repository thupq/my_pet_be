package com.thupq.mypets.models.request;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserSearchRequest {
    private String userName;

    private String status;

    private String contactPhone;

    private Instant fromDate;

    private Instant toDate;
}

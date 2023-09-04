package com.thupq.mypets.repository;

import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepoCustom {
    Page<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);
}

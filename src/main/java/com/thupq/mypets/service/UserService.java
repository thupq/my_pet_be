package com.thupq.mypets.service;

import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    UserResponse getDetails(Long id);

    Page<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);

    UserResponse update(Long id, UserRequest userUpdateRequest);

    String delete(Long id);

    String signin(String userName, String password);
}

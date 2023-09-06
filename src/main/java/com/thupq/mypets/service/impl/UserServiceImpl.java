package com.thupq.mypets.service.impl;

import com.thupq.mypets.common.MessageCode;
import com.thupq.mypets.exceptions.ValidateException;
import com.thupq.mypets.models.entity.User;
import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import com.thupq.mypets.repository.UserRepoCustom;
import com.thupq.mypets.repository.UserRepository;
import com.thupq.mypets.service.UserService;
import com.thupq.mypets.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.thupq.mypets.common.MessageUtils.getMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRepoCustom userRepoCustom;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.toEntityCreate(userRequest);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponse getDetails(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ValidateException(getMessage(MessageCode.Teacher.NOT_EXISTS)));
    }

    @Override
    public Page<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable) {
        return userRepoCustom.searchUser(userSearchRequest, pageable);
    }

    @Override
    public UserResponse update(Long id, UserRequest userUpdateRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ValidateException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        userMapper.partialUpdate(user, userUpdateRequest);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

}

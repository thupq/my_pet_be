package com.thupq.mypets.service.impl;

import com.thupq.mypets.common.Constants;
import com.thupq.mypets.common.MessageCode;
import com.thupq.mypets.exceptions.ValidateException;
import com.thupq.mypets.models.entity.User;
import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import com.thupq.mypets.repository.UserRepoCustom;
import com.thupq.mypets.repository.UserRepository;
import com.thupq.mypets.security.JwtTokenProvider;
import com.thupq.mypets.service.UserService;
import com.thupq.mypets.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;

import static com.thupq.mypets.common.MessageUtils.getMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRepoCustom userRepoCustom;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.toEntityCreate(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
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
    @Transactional
    public UserResponse update(Long id, UserRequest userUpdateRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ValidateException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        userMapper.partialUpdate(user, userUpdateRequest);
        user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public String delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ValidateException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        user.setStatus(Constants.STATUS_INACTIVE);
        user.setUpdateBy("System");
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        try {
            userRepository.save(user);
            return "Success";
        } catch (Exception ex) {
            return "Failed";
        }
    }

    @Override
    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username);
        } catch (AuthenticationException e) {
            throw new ValidateException("Invalid username/password supplied");
        }
    }

}

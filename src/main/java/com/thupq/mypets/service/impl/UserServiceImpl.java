package com.thupq.mypets.service.impl;

import com.thupq.mypets.common.Constants;
import com.thupq.mypets.common.MessageCode;
import com.thupq.mypets.configurations.security.UserAuthenticationProvider;
import com.thupq.mypets.exceptions.ValidateException;
import com.thupq.mypets.models.entity.user.User;
import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import com.thupq.mypets.repository.user.impl.UserRepoCustom;
import com.thupq.mypets.repository.user.impl.UserRepository;
import com.thupq.mypets.service.UserService;
import com.thupq.mypets.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.nio.CharBuffer;
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
    private final UserAuthenticationProvider userAuthenticationProvider;

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
    public String signin(String userName, String password) {
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new ValidateException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        if (passwordEncoder.matches(CharBuffer.wrap(password), user.getPassword())) {
            return userAuthenticationProvider.createToken(userName);
        }
        throw new ValidateException("Invalid username/password supplied");
    }

}

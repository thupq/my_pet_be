package com.thupq.mypets.service.mapper;

import com.thupq.mypets.common.Constants;
import com.thupq.mypets.models.entity.User;
import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserResponse, User>{
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "createBy", defaultValue = "system")
    @Mapping(target = "updateDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updateBy", defaultValue = "system")
    @Mapping(target = "status", defaultValue = Constants.STATUS_ACTIVE)
    User toEntityCreate(UserRequest userRequest);
}

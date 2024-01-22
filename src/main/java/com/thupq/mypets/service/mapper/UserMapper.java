package com.thupq.mypets.service.mapper;

import com.thupq.mypets.common.Constants;
import com.thupq.mypets.models.entity.user.User;
import com.thupq.mypets.models.request.UserRequest;
import com.thupq.mypets.models.response.UserResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserResponse, User>{
    @Mapping(target = "createDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
    @Mapping(target = "createBy", defaultValue = "system")
    @Mapping(target = "updateDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
    @Mapping(target = "updateBy", defaultValue = "system")
    @Mapping(target = "status", defaultValue = Constants.STATUS_ACTIVE)
    User toEntityCreate(UserRequest userRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "updateDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
            @Mapping(target = "updateBy", constant = "system"),
    })
    void partialUpdate(@MappingTarget User entity, UserRequest dto);
}

package com.thupq.mypets.repository.impl;

import com.thupq.mypets.exceptions.ValidateException;
import com.thupq.mypets.models.request.UserSearchRequest;
import com.thupq.mypets.models.response.UserResponse;
import com.thupq.mypets.repository.UserRepoCustom;
import com.thupq.mypets.utils.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class UserRepoImpl extends BaseSearchRepoImpl implements UserRepoCustom {
    @Override
    public Page<UserResponse> searchUser(UserSearchRequest param, Pageable pageable) {
        validateDate(param);
        HashMap<String, Object> mapParams = new HashMap<>();

        StringBuilder baseSql = new StringBuilder(" from users us where 1 = 1 ");
        if (!StringUtil.isNullObject(param.getUserName())) {
            baseSql.append(" and us.user_name =: userName ");
            mapParams.put("userName", param.getUserName());
        }

        if (!StringUtil.isNullObject(param.getStatus())) {
            baseSql.append(" and us.status =: status ");
            mapParams.put("status", param.getStatus());
        }

        if (!StringUtil.isNullObject(param.getContactPhone())) {
            baseSql.append(" and us.contact_phone =: contactPhone ");
            mapParams.put("contactPhone", param.getContactPhone());
        }

        baseSql.append(" and us.create_date >= :fromDate and us.create_date <= :toDate ");
        mapParams.put("fromDate", param.getFromDate());
        mapParams.put("toDate", param.getToDate());

        String countSql = "select count(*) ";
        String dataSql = "select * ";

        countSql = countSql + baseSql;
        dataSql = dataSql + baseSql + " order by us.create_date desc";
        return getPageData(dataSql, countSql, mapParams, UserResponse.class, pageable);
    }

    private void validateDate(UserSearchRequest param) {
        if (param.getFromDate() == null) {
            throw new ValidateException("Từ ngày không được để trống!", "ERR01");
        }
        if (param.getToDate() == null) {
            throw new ValidateException("Đến ngày không được để trống!", "ERR02");
        }
        if (param.getToDate().isBefore(param.getFromDate())) {
            throw new ValidateException("Từ ngày không được > đến ngày!", "ERR03");
        }
    }
}

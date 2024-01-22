package com.thupq.mypets.repository;

import com.thupq.mypets.utils.QueryUtil;
import com.thupq.mypets.utils.Tools;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Log4j2
public class BaseSearchRepoImpl {
    @Autowired
    private EntityManager em;

    public <T> List<T> executeQuery(String sqlData, HashMap<String, Object> mapParams,
                                    Class<T> targetClass, Pageable pageable) {
        Query query = em.createNativeQuery(sqlData);
        QueryUtil.setParametersByMap(query, mapParams);

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }

        List<Object[]> listObject = query.getResultList();
        List<T> listRes = new ArrayList<>();
        listObject.forEach(object -> {
            try {
                T obj = targetClass.getDeclaredConstructor().newInstance();
                listRes.add(Tools.convertObjectsToClass(object, obj));
            } catch (Exception e) {
                log.error("executeQuery exception: {}", e.getMessage());
            }
        });

        return listRes;
    }

    public <T> Page<T> getPageData(String sqlData, String sqlCount, HashMap<String, Object> mapParams,
                                   Class<T> targetClass, Pageable pageable) {
        List<T> listRes = executeQuery(sqlData, mapParams, targetClass, pageable);
        long count = count(sqlCount, mapParams);

        return new PageImpl<>(listRes, pageable, count);
    }

    public <T> List<T> getAllData(String sqlData, HashMap<String, Object> mapParams, Class<T> targetClass) {
        return executeQuery(sqlData, mapParams, targetClass, null);
    }

    public <T> T getData(String sqlData, HashMap<String, Object> mapParams, Class<T> targetClass) {
        List<T> listRes = executeQuery(sqlData, mapParams, targetClass, null);
        return listRes.size() > 0 ? listRes.get(0) : null;
    }

    public Long count(String sql, HashMap<String, Object> mapParams) {
        BigDecimal result;
        try {
            result = (BigDecimal) getSingleResult(sql, mapParams);
            return result.toBigInteger().longValue();
        } catch (Exception ex) {
            return 0L;
        }
    }


    public Object getSingleResult(String sql, HashMap<String, Object> mapParams) {
        Query q = em.createNativeQuery(sql);
        QueryUtil.setParametersByMap(q, mapParams);
        return q.getSingleResult();
    }

    public Long getSum(String sqlSum, HashMap<String, Object> mapParams) {
        BigDecimal result;
        try {
            result = (BigDecimal) getSingleResult(sqlSum, mapParams);
            return result.toBigInteger().longValue();
        } catch (Exception ex) {
            return 0L;
        }
    }

    public BigDecimal getSumD(String sqlSum, HashMap<String, Object> mapParams) {
        BigDecimal result;
        try {
            result = (BigDecimal) getSingleResult(sqlSum, mapParams);
            return result;
        } catch (Exception ex) {
            return new BigDecimal(0);
        }
    }
}

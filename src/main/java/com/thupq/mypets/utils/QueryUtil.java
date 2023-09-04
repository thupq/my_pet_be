package com.thupq.mypets.utils;

import javax.persistence.Query;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * QueryUtil
 */
public class QueryUtil {
    /**
     * setParametersByMap(Query query, HashMap<String, Object> mapParams)
     * @param query Query
     * @param mapParams HashMap<String, Object>
     */
    public static void setParametersByMap(Query query, HashMap<String, Object> mapParams) {
        mapParams.keySet().forEach(param -> {
            Object value = mapParams.get(param);
            query.setParameter(param, value);
        });
    }
}

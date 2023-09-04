package com.thupq.mypets.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

/**
 * common Tools
 */
public class Tools {

    /**
     * convert Date to String
     * @param date Date
     * @param pattern String
     * @return kq date sau format
     */
    public static String date2StringByPattern(Date date, String pattern) {
        if (date == null || StringUtil.isNullOrEmpty(pattern)) {
            return null;
        }

        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * convertObjectsToClass
     * @param objects Object[]
     * @param object Object
     * @param <T> T
     * @return T
     */
    public static <T> T convertObjectsToClass(Object[] objects, Object object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                if (i > objects.length - 1)
                    break;

                Field f = fields[i];

                f.setAccessible(true);
                Class t = f.getType();

                Object item = objects[i];
                if (item == null)
                    continue;
                if (String.class.getName().equalsIgnoreCase(t.getName())) {
                    if (item instanceof String || item instanceof Long || item instanceof Character
                            || item instanceof BigDecimal) {
                        f.set(object, StringUtil.safeToString(item));
                    } else if (item instanceof Date) {
                        f.set(object,
                                date2StringByPattern(StringUtil.safeToDate(item), "yyyy-MM-dd"));
                    }
                } else if (Long.class.getName().equalsIgnoreCase(t.getName())
                        || long.class.getName().equalsIgnoreCase(t.getName())) {
                    f.set(object, StringUtil.safeToLong(item));
                } else if (Double.class.getName().equalsIgnoreCase(t.getName())
                        || double.class.getName().equalsIgnoreCase(t.getName())) {
                    f.set(object, StringUtil.safeToDouble(item));
                } else if (Boolean.class.getName().equalsIgnoreCase(t.getName())
                        || boolean.class.getName().equalsIgnoreCase(t.getName())) {
                    f.set(object, item);
                } else if (Date.class.getName().equalsIgnoreCase(t.getName())) {
                    f.set(object, StringUtil.safeToDate(item));
                }

            }

            return (T) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * cấu hình minio
     * @param base64String String
     * @param fileName String
     * @return detectMimeType
     */
    public static String detectMimeType(String base64String, String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (StringUtil.isStringNullOrEmpty(ext)) {
            ext = "bin";
        }
        ext = ext.toLowerCase();
        HashMap<String, String> signatures = new HashMap<>();
        signatures.put("JVBERi0", "application/pdf");
        signatures.put("R0lGODdh", "image/gif");
        signatures.put("R0lGODlh", "image/gif");
        signatures.put("iVBORw0KGgo", "image/png");
        signatures.put("TU0AK", "image/tiff");
        signatures.put("/9j/", "image/jpg");
        signatures.put("UEs", "application/vnd.openxmlformats-officedocument.");
        signatures.put("PK", "application/zip");

        for (String s : signatures.keySet()) {
            if (base64String.indexOf(s) == 0) {
                String x = signatures.get(s);
                if (ext.length() > 3 && ext.startsWith("ppt")) {
                    x += "presentationml.presentation";
                } else if (ext.length() > 3 && ext.startsWith("xls")) {
                    x += "spreadsheetml.sheet";
                } else if (ext.length() > 3 && ext.startsWith("doc")) {
                    x += "wordprocessingml.document";
                }
                return x;
            }
        }

        HashMap<String, String> extensions = new HashMap<>();
        extensions.put("xls", "application/vnd.ms-excel");
        extensions.put("ppt", "application/vnd.ms-powerpoint");
        extensions.put("doc", "application/msword");
        extensions.put("xml", "text/xml");
        extensions.put("mpeg", "audio/mpeg");
        extensions.put("mpg", "audio/mpeg");
        extensions.put("txt", "text/plain");

        for (String e : extensions.keySet()) {
            if (ext.indexOf(e) == 0) {
                return extensions.get(e);
            }
        }

        return "unknown";
    }

    /**
     * lấy ngày ? ngày trước
     * @param day int
     * @return ngày
     */
    public static Date getDateLast(int day) {
        LocalDate threeDaysAgoDate = LocalDate.now().minusDays(day);
        return Date.from(threeDaysAgoDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * convertModelToJsonString
     * @param o Object
     * @return convertModelToJsonString
     */
    public static String convertModelToJsonString(Object o) {
        ObjectMapper obj = new ObjectMapper();
        try {
            return obj.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}

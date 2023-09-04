package com.thupq.mypets.common;

import lombok.Getter;

public class Constants {

  private Constants() {
  }

  public static final char DEFAULT_ESCAPE_CHAR = '@';
  public static final int LIKE_STARTS_WITH = 2;
  public static final int LIKE_ENDS_WITH = 1;

  public static final String STATUS_ACTIVE = "ACTIVE";
  public static final String STATUS_INACTIVE = "INACTIVE";
  public static final String TIMEZONE_VN = "Asia/Ho_Chi_Minh";
  public static final String SESSION_NAME_PREFIX = "Session";

  public static final String REGEX_NAME_VN = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
  public static final String REGEX_PHONE_VN = "([\\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8,13})";
  public static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
  public static final String UN_ASSIGN_CLASS = "UN_ASSIGN_CLASS";
  public static final String HAD_CLASS = "HAD_CLASS";

  public static final class PrefixCode {

    private PrefixCode() {
    }

    public static final String PRE_STUDENT_CODE = "ST";
    public static final String PRE_TEACHER_CODE = "TC";
    public static final String PRE_CLASS_CODE = "SPU";

  }

  public enum GENDER {
    MALE(0),
    FEMALE(1),
    OTHER(2);

    @Getter
    private Integer value;

    GENDER(Integer value) {
      this.value = value;
    }

    public static Integer getValue(String gender) {
      for (GENDER e : GENDER.values()) {
        if (e.toString().equals(gender)) {
          return e.value;
        }
      }
      return OTHER.value;
    }
  }

  public static final class CUSTOM_FIELD {

    public static final Long ID_DOB = 5582L;
  }

  public static final String URL_LESSON_DETAILS = "https://console.classin.com/saas/school/index.html#/singlePage/LessonMonitor/LessonDetail?lessonId=%s&lessonType=1";
}

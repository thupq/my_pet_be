package com.thupq.mypets.common;

public class MessageCode {

  private MessageCode() {
  }

  public static final class Student {

    private Student() {
    }

    // Validate fullName
    public static final String FULLNAME_REQUIRED = "error.student.fullName.required";
    public static final String FULLNAME_MAX_255 = "error.student.fullName.max.255";
    public static final String FULLNAME_NOT_VALID = "error.student.fullName.notValid";
    // Validate phone
    public static final String PHONE_EXIST = "error.student.phone.exist";
    public static final String PHONE_NOT_VALID = "error.student.phone.notValid";
    // Validate email
    public static final String EMAIL_NOT_VALID = "error.student.email.notValid";
    // Validate gender
    // Validate parentName
    public static final String PARENT_NAME_MAX_255 = "error.student.parentName.max.255";
    // Validate parentPhone
    public static final String PARENT_PHONE_NOT_VALID = "error.student.parentPhone.notValid";

    // Validate id
    public static final String ID_NOT_EXIST_DELETED = "error.student.id.notExist.or.deleted";

    // Validate province, district
    public static final String PROVINCE_REQUIRED = "error.student.province.required";
    public static final String DISTRICT_REQUIRED = "error.student.district.required";
    // Validate customerService
    public static final String CUSTOMER_SERVICE_REQUIRED = "error.student.customerService.required";
    // Student not found
    public static final String NOT_EXISTS = "error.student.not.exists";

    // Validate class_in_phone
    public static final String CLASS_IN_PHONE_EXISTS = "error.student.classInPhone.exists";
    public static final String CLASS_IN_PHONE_REQUIRED = "error.student.classInPhone.required";
    public static final String CLASS_IN_PHONE_NOT_VALID = "error.student.classInPhone.notValid";

    // Validate represent_name
    public static final String REPRESENT_NAME_REQUIRED = "error.student.representativeName.required";
    public static final String REPRESENT_NAME_MAX_255 = "error.student.representativeName.max.255";
    public static final String REPRESENT_NAME_NOT_VALID = "error.student.representativeName.notValid";

    // Validate represent_phone
    public static final String REPRESENT_PHONE_REQUIRED = "error.student.representativePhone.required";
    public static final String REPRESENT_PHONE_NOT_VALID = "error.student.representativePhone.notValid";
    public static final String REPRESENT_PHONE_EXIST = "error.student.representativePhone.exist";
  }

  public static final class SystemShift {

    private SystemShift() {
    }

    // Shift not found
    public static final String NOT_EXISTS = "error.shift.not.exists";

    // Validate dates
    public static final String FROM_DATE_REQUIRED = "error.shift.from_date.required";
    public static final String TO_DATE_REQUIRED = "error.shift.to_date.required";
    public static final String DAYS_REQUIRED = "error.shift.days.required";
    public static final String FROM_DATE_NOT_GREATER_TO_DATE = "error.shift.fromDate.not.greater.toDate";
    public static final String CANNOT_BE_REMOVED = "error.shift.cannot_be_removed";
  }


  public static final class StudentPackage {

    private StudentPackage() {
    }

    public static final String AVAILABLE_SESSION_REQUIRED = "error.sp.availableSession.required";
    public static final String AVAILABLE_GREATER_THAN_TOTAL = "error.sp.available.greater.than.total";
    public static final String PAID_PRICE_REQUIRED = "error.sp.paidPrice.required";
    public static final String PAID_PRICE_GREATER_THAN_LIST_PRICE = "error.sp.paidPrice.greater.than.listPrice";
    public static final String VALID_THROUGH_REQUIRED = "error.sp.validThrough.required";
    public static final String TOTAL_LIST_PRICE_REQUIRED = "error.sp.totalListPrice.required";
    public static final String TOTAL_PAID_PRICE_REQUIRED = "error.sp.totalPaidPrice.required";
    public static final String NOTE_MAX_1000 = "error.sp.note.max.1000";
    public static final String ID_NOT_EXIST = "error.sp.id.notExist.orDeleted";
    public static final String TOTAL_LIST_PRICE_MIN_0 = "error.sp.totalListPrice.min.0";
    public static final String TOTAL_PAID_PRICE_MIN_0 = "error.sp.totalPaidPrice.min.0";
    public static final String AVAILABLE_SESSION_GREATER_0 = "error.sp.availableSession.greater.than.0";
    public static final String PAID_PRICE_MIN_0 = "error.sp.paidPrice.min.0";

  }

  public static final class Package {

    private Package() {
    }

    public static final String ID_NOT_EXIST = "error.package.id.not.exist";
    public static final String PACKAGE_PRODUCT_ID_REQUIRED = "error.packageProductId.required";
  }

  public static final class Teacher {

    private Teacher() {
    }

    // Validate fullName
    public static final String FULLNAME_REQUIRED = "error.teacher.fullName.required";
    public static final String FULLNAME_MAX_255 = "error.teacher.fullName.max.255";

    // Validate phone
    public static final String PHONE_REQUIRED = "error.teacher.phone.required";
    public static final String PHONE_NOT_VALID = "error.teacher.phone.notValid";
    public static final String PHONE_EXISTS = "error.teacher.phone.exists";

    // Validate email
    public static final String EMAIL_REQUIRED = "error.teacher.email.required";
    public static final String EMAIL_NOT_VALID = "error.teacher.email.notValid";
    public static final String EMAIL_EXISTS = "error.teacher.email.exists";

    // Nationality
    public static final String NATIONALITY_REQUIRED = "error.teacher.nationality.required";

    // Partner
    public static final String PARTNER_REQUIRED = "error.teacher.partner.required";

    // working status
    public static final String WORKING_STATUS_REQUIRED = "error.teacher.workingStatus.required";

    // description
    public static final String DESCRIPTION_MAX_1000 = "error.teacher.description.max.1000";

    // skype
    public static final String SKYPE_MAX_255 = "error.teacher.skype.max.255";

    // Validate customerService
    public static final String CUSTOMER_SERVICE_REQUIRED = "error.teacher.customerService.required";
    // Student not found
    public static final String NOT_EXISTS = "error.user.not.exists";

    // Validate class_in_phone
    public static final String CLASS_IN_PHONE_REQUIRED = "error.teacher.classInPhone.required";
    public static final String CLASS_IN_PHONE_NOT_VALID = "error.teacher.classInPhone.notValid";
    public static final String CLASS_IN_PHONE_EXISTS = "error.teacher.classInPhone.exists";

    // lms
    public static final String LMS_USERNAME_MAX_255 = "error.teacher.lmsUsername.max.255";
    public static final String LMS_USERNAME_EXISTS = "error.teacher.lmsUsername.exists";

    // Product
    public static final String PRODUCTS_CAN_NOT_EMPTY = "error.teacher.products.required";
  }


  public static final class ClassConfig {

    private ClassConfig() {
    }

    public static final String PRODUCT_REQUIRED = "error.class.product.required";
    public static final String NAME_REQUIRED = "error.class.name.required";
    public static final String NAME_MAX_200 = "error.class.name.max.200";
    public static final String MAX_STUDENT_REQUIRED = "error.class.max.student.required";
    public static final String MAX_TEACHER_REQUIRED = "error.class.max.teacher.required";
    public static final String CLASS_TYPE_REQUIRED = "error.class.classType.required";
    public static final String CUSTOMER_SERVICE_REQUIRED = "error.class.customerService.required";
    public static final String LIST_SESSION_REQUIRED = "error.class.session.lesson.required";
    public static final String COURSE_REQUIRED = "error.class.courseId.required";
    public static final String START_DATE_REQUIRED = "error.class.startDate.required";
    public static final String DURATION_REQUIRED = "error.class.duration.required";
    public static final String DURATION_MIN_1 = "error.class.duration.min.1";
    public static final String SCHEDULER_REQUIRED = "error.class.schedulers.required";
    public static final String SYSTEM_SHIFT_REQUIRED = "error.class.systemShift.required";
    public static final String TEACHER_REQUIRED = "error.class.teacher.required";
    public static final String START_DATE_CAN_MUST_BE_AFTER_CURRENT_DAY = "error.class.startDate.must.after.currentDay";
    public static final String CLASS_SESSION_TIME_IS_OVERLAP = "error.class.classSession.time.overlap";
    public static final String NUMBER_TEACHER_PER_CLASS_SESSION_VIOLATION = "error.class.classSession.number.teacher.violation";
    public static final String CLASS_ID_REQUIRED = "error.class.id.required";
    public static final String ID_NOT_EXIST = "error.class.id.not.exist";
    public static final String TO_SESSION_MUST_BE_GREATER_OR_EQUAL_THAN_FROM_SESSION = "error.class.classSession.to.session.must.greater.or.equal.than.from.session";
    public static final String STUDENT_HAVE_NOT_ENOUGH_AVAILABLE_SESSIONS = "error.class.classSession.student.have.not.enough.available.sessions";
    public static final String STUDENT_ORDER_MUST_SMALLER_OR_EQUAL_TOTAL_SESSION = "error.class.classSession.student.order.must.smaller.or.equal.total.session";
    public static final String STUDENT_ALREADY_JOINED_CLASS = "error.class.classSession.student.already.joined.class";
    public static final String STUDENT_ALREADY_JOINED_CLASS_SESSION = "error.class.classSession.student.already.joined.classSession";
    public static final String NUMBER_OF_STUDENT_IS_OVER_MAXIMUM_STUDENT_PER_CLASS = "error.class.number.of.student.is.over.maximum.student.per.class";
    public static final String STUDENTS_REQUIRED = "error.class.students.required";
    public static final String STUDENT_ID_REQUIRED = "error.class.student.id.required";
    public static final String FROM_SESSION_REQUIRED = "error.class.fromSession.required";
    public static final String TO_SESSION_REQUIRED = "error.class.toSession.required";
    public static final String SESSION_MUST_GREATER_OR_EQUAL_THAN_1 = "error.class.classSession.must.greater.or.equal.than.1";
    public static final String STUDENT_SESSION_NOT_AVAILABLE = "error.class.studentSession.not.available";
    public static final String STUDENT_NOT_JOIN_ALL_SESSION = "error.class.student.not.join.all.session";
    public static final String SESSION_ORDER_LESS_THAN_TOTAL_SESSION = "error.class.sessionOrder.less.than.totalSession";
    public static final String CLASS_SESSION_REQUIRED = "error.class.classSessionId.required";
    public static final String CLASS_SESSION_NOT_EXIST = "error.class.classSessionId.not.exist";
    public static final String CLASS_SESSION_IS_NOT_UN_START_STATUS = "error.class.classSessions.is.not.un.start.status";
    public static final String SWITCH_TEACHER_REQUEST_REQUIRED = "error.class.classSessions.switch.teacher.request.required";
    public static final String TEACHERS_MUST_NOT_EMPTY = "error.class.classSessions.teachers.must.not.empty";
    public static final String STUDENT_JOINED_ANOTHER_CLASS_SESSION_AT_THIS_TIME = "error.class.classSessions.student.joined.another.class.session.at.this.time";
    public static final String TEACHER_JOINED_ANOTHER_CLASS_SESSION_AT_THIS_TIME = "error.class.teacher.joined.another.class.session.at.this.time";
    public static final String SCHEDULE_NOT_VALID_FOR_STUDENT_SHIFT = "error.class.classSessions.notValid.for.studentShift";
    public static final String CLASS_SESSION_ORDER_RANGE_VIOLATION = "error.class.classSessions.order.range.violation";
  }

  public static final class TeacherShift {

    private TeacherShift() {
    }

    // Validate fromDate - toDate
    public static final String START_DATE_OF_WEEK_REQUIRED = "error.teacherShift.startDate.required";
    public static final String SYSTEM_SHIFT_REQUIRED = "error.teacherShift.systemShiftId.required";
    public static final String SHIFT_INFO_REQUIRED = "error.teacherShift.shiftInfo.required";
    public static final String SHIFT_EXISTS_SESSION = "error.teacherShift.exists.session";
  }

  public static final class StudentShift {

    private StudentShift() {
    }

    // Validate date
    public static final String SHIFT_INFO_REQUIRED = "error.studentShift.shiftInfo.required";
    // Validate system shift
    public static final String SYSTEM_SHIFT_REQUIRED = "error.studentShift.systemShift.required";
    public static final String SYSTEM_SHIFT_NOT_EXISTS = "error.studentShift.systemShift.notExists";
    // Validate DayInWeek
    public static final String DAYS_REQUIRED = "error.studentShift.days.required";
    public static final String DAY_IN_WEEK_NOT_VALID = "error.studentShift.dayInWeek.notValid";

  }

}

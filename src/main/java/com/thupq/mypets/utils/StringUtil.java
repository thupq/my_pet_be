package com.thupq.mypets.utils;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Xu ly String
 */
@SuppressWarnings("java:S1643")
public class StringUtil {
    public static final String CHARFORM_NOHORN = "aaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyd"
            + "AAAAAAAAAAAAAAAAAEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYYD";
    public static final String CHARFORM_UNICODE = "àáảãạâầấẩẫậăằắẳẵặèéẻẽẹê�?ếểễệìíỉĩịòó�?õ�?ôồốổỗộơ�?" +
            "ớởỡợùúủũụưừứửữựỳýỷỹỵđ"
            + "À�?ẢÃẠÂẦẤẨẪẬĂẰẮẲẴẶÈÉẺẼẸÊỀẾỂỄỆÌ�?ỈĨỊÒÓỎÕỌÔỒ�?ỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲ�?ỶỸỴ�?";
    public static final String CHARFORM_TCVN = "µ¸¶·¹©ÇÊÈÉË¨»¾¼½ÆÌ�?Î�?ÑªÒÕÓÔÖ×�?ØÜÞßãáâä«åèæçé¬êíëìîïóñòô­õøö÷ùúýûüþ®"
            + "µ¸¶·¹©ÇÊÈÉË¨»¾¼½ÆÌ�?Î�?ÑªÒÕÓÔÖ×�?ØÜÞßãáâä«åèæçé¬êíëìîïóñòô­õøö÷ùúýûüþ®";
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;

    /**
     * format long to String
     * @param lngNumber long
     * @param strPattern String
     * @return strPattern
     */
    public static String format(long lngNumber, String strPattern) {
        java.text.DecimalFormat fmt = new java.text.DecimalFormat(strPattern);
        return fmt.format(lngNumber);
    }

    /**
     * format double to String
     * @param dblNumber double
     * @param strPattern String
     * @return strPattern
     */
    public static String format(double dblNumber, String strPattern) {
        java.text.DecimalFormat fmt = new java.text.DecimalFormat(strPattern);
        return fmt.format(dblNumber);
    }

    /**
     * replaceAll(String strSrc, String strFind, String strReplace)
     * @param strSrc String
     * @param strFind String
     * @param strReplace String
     * @return ket qua
     */
    public static String replaceAll(String strSrc, String strFind, String strReplace) {
        if (strFind == null || strFind.length() == 0)
            return strSrc;
        int iLocation = 0;
        int iPrevLocation = 0;
        StringBuffer strResult = new StringBuffer();
        while ((iLocation = strSrc.indexOf(strFind, iLocation)) >= 0) {
            strResult.append(strSrc.substring(iPrevLocation, iLocation));
            strResult.append(strReplace);
            iLocation += strFind.length();
            iPrevLocation = iLocation;
        }
        strResult.append(strSrc.substring(iPrevLocation, strSrc.length()));
        return strResult.toString();
    }

    /**
     * replaceAll(String strSrc, String strFind, String strReplace, int iMaxReplacement)
     * @param strSrc String
     * @param strFind String
     * @param strReplace String
     * @param iMaxReplacement int
     * @return ket qua
     */
    public static String replaceAll(String strSrc, String strFind, String strReplace, int iMaxReplacement) {
        int iLocation = 0;
        if (strFind == null || strFind.length() == 0)
            return strSrc;
        int iPrevLocation = 0;
        int iCount = 0;
        StringBuffer strResult = new StringBuffer();
        while ((iLocation = strSrc.indexOf(strFind, iLocation)) >= 0 && iCount < iMaxReplacement) {
            strResult.append(strSrc.substring(iPrevLocation, iLocation));
            strResult.append(strReplace);
            iCount++;
            iLocation += strFind.length();
            iPrevLocation = iLocation;
        }
        strResult.append(strSrc.substring(iPrevLocation, strSrc.length()));
        return strResult.toString();
    }

    /**
     * replaceAllIgnoreCase(String strSrc, String strFind, String strReplace)
     * @param strSrc String
     * @param strFind String
     * @param strReplace String
     * @return kq
     */
    public static String replaceAllIgnoreCase(String strSrc, String strFind, String strReplace) {
        if (strFind == null || strFind.length() == 0)
            return strSrc;
        String strSrcUpper = strSrc.toUpperCase();
        strFind = strFind.toUpperCase();

        int iLocation = 0;
        int iPrevLocation = 0;
        StringBuffer strResult = new StringBuffer();
        while ((iLocation = strSrcUpper.indexOf(strFind, iLocation)) >= 0) {
            strResult.append(strSrc.substring(iPrevLocation, iLocation));
            strResult.append(strReplace);
            iLocation += strFind.length();
            iPrevLocation = iLocation;
        }
        strResult.append(strSrc.substring(iPrevLocation, strSrc.length()));
        return strResult.toString();
    }

    /**
     * check gia tri null cua obj
     * @param objInput Object
     * @param strNullValue String
     * @return kq
     */
    public static String nvl(Object objInput, String strNullValue) {
        if (objInput == null)
            return strNullValue;
        return objInput.toString();
    }

    /**
     * indexOfLetter(String strSource, int iOffset)
     * @param strSource String
     * @param iOffset int
     * @return kq
     */
    public static int indexOfLetter(String strSource, int iOffset) {
        char c;
        while (iOffset < strSource.length()) {
            c = strSource.charAt(iOffset);
            if (c > ' ')
                return iOffset;
            else
                iOffset++;
        }
        return -1;
    }

    /**
     * tìm vị trí của ký tự khoảng trắng đầu tiên trong một chuỗi
     * @param strSource String
     * @param iOffset int
     * @return kq
     */
    public static int indexOfSpace(String strSource, int iOffset) {
        char c;
        while (iOffset < strSource.length()) {
            c = strSource.charAt(iOffset);
            if (c > ' ')
                iOffset++;
            else
                return iOffset;
        }
        return -1;
    }

    /**
     * countSymbol(String strSource, String chrSymbol, int iOffset)
     * @param strSource String
     * @param chrSymbol String
     * @param iOffset int
     * @return kq
     */
    public static int countSymbol(String strSource, String chrSymbol, int iOffset) {
        if (chrSymbol == null || chrSymbol.length() == 0)
            return 0;
        int iCount = 0;
        while ((iOffset = strSource.indexOf(chrSymbol, iOffset) + 1) > 0)
            iCount++;
        return iCount;
    }

    /**
     * toStringArray(String strSource, String strSeparator)
     * @param strSource String
     * @param strSeparator String
     * @return strReturn
     */
    public static String[] toStringArray(String strSource, String strSeparator) {
        Vector vtReturn = toStringVector(strSource, strSeparator);
        String[] strReturn = new String[vtReturn.size()];
        for (int iIndex = 0; iIndex < strReturn.length; iIndex++)
            strReturn[iIndex] = (String) vtReturn.elementAt(iIndex);
        return strReturn;
    }

    /**
     * toStringVector(String strSource, String strSeparator)
     * @param strSource String
     * @param strSeparator String
     * @return vector
     */
    public static Vector toStringVector(String strSource, String strSeparator) {
        Vector vtReturn = new Vector();
        int iIndex = 0;
        int iLastIndex = 0;
        while ((iIndex = strSource.indexOf(strSeparator, iLastIndex)) >= 0) {
            vtReturn.addElement(strSource.substring(iLastIndex, iIndex).trim());
            iLastIndex = iIndex + strSeparator.length();
        }
        if (iLastIndex <= strSource.length())
            vtReturn.addElement(strSource.substring(iLastIndex, strSource.length()).trim());
        return vtReturn;
    }

    /**
     * toStringArray(String strSource)
     * @param strSource String
     * @return toStringArray(strSource, ",")
     */
    public static String[] toStringArray(String strSource) {
        return toStringArray(strSource, ",");
    }

    /**
     * toStringVector(String strSource)
     * @param strSource String
     * @return toStringVector(strSource, ",")
     */
    public static Vector toStringVector(String strSource) {
        return toStringVector(strSource, ",");
    }

    /**
     * convertCharForm(String strSource, String strCharformSource, String strCharformDestination)
     * @param strSource String
     * @param strCharformSource String
     * @param strCharformDestination String
     * @return kq
     */
    public static String convertCharForm(String strSource, String strCharformSource, String strCharformDestination) {
        if (strSource == null)
            return null;
        int iLength = strSource.length();
        int iResult = 0;
        StringBuffer strReturn = new StringBuffer();
        for (int iIndex = 0; iIndex < iLength; iIndex++) {
            char c = strSource.charAt(iIndex);
            if ((iResult = strCharformSource.indexOf(c)) >= 0)
                strReturn.append(strCharformDestination.charAt(iResult));
            else
                strReturn.append(c);
        }
        return strReturn.toString();
    }

    /**
     * unicodeToTCVN(String strSource)
     * @param strSource String
     * @return convertCharForm
     */
    public static String unicodeToTCVN(String strSource) {
        return convertCharForm(strSource, CHARFORM_UNICODE, CHARFORM_TCVN);
    }

    /**
     * tcvnToUnicode(String strSource)
     * @param strSource String
     * @return convertCharForm
     */
    public static String tcvnToUnicode(String strSource) {
        return convertCharForm(strSource, CHARFORM_TCVN, CHARFORM_UNICODE);
    }

    /**
     * clearHornUnicode(String strSource)
     * @param strSource String
     * @return convertCharForm
     */
    public static String clearHornUnicode(String strSource) {
        return convertCharForm(strSource, CHARFORM_UNICODE, CHARFORM_NOHORN);
    }

    /**
     * clearHornTCVN(String strSource)
     * @param strSource String
     * @return convertCharForm
     */
    public static String clearHornTCVN(String strSource) {
        return convertCharForm(strSource, CHARFORM_TCVN, CHARFORM_NOHORN);
    }

    /**
     * Don vi dem tieng Viet
     * @param lNumber long
     * @return cach doc
     */
    public static String pronounceVietnameseNumber(long lNumber) {
        String[] strUnit = new String[]{"", "nghìn", "triệu", "tỷ", "nghìn tỷ", "triệu tỷ", "nghìn triệu tỷ",
                "tỷ tỷ"};

        // Analyse the number to array
        byte[] btDecimalNumber = new byte[30];
        byte btDecimalCount = 0;
        boolean bNegative = (lNumber < 0);
        if (bNegative)
            lNumber = -lNumber;
        while (lNumber > 0) {
            byte btValue = (byte) (lNumber - 10 * (lNumber / 10));
            lNumber /= 10;
            btDecimalNumber[btDecimalCount++] = btValue;
        }

        // Pronounce array
        String strReturn = "";
        int iUnitIndex = 0;
        while (iUnitIndex < strUnit.length && iUnitIndex * 3 < btDecimalCount) {
            String str = pronounceVietnameseNumber(btDecimalNumber[iUnitIndex * 3], btDecimalNumber[iUnitIndex * 3 + 1],
                    btDecimalNumber[iUnitIndex * 3 + 2], iUnitIndex * 3 + 2 < btDecimalCount);
            if (str.length() > 0) {
                if (strReturn.length() > 0)
                    strReturn = str + " " + strUnit[iUnitIndex] + " " + strReturn;
                else
                    strReturn = str + " " + strUnit[iUnitIndex];
            }
            iUnitIndex++;
        }
        if (bNegative)
            strReturn = "âm " + strReturn;
        return strReturn;
    }

    private static String pronounceVietnameseNumber(byte bUnit, byte bTen, byte bHundred, boolean bMax) {
        // Return zero
        if (bUnit == 0 && bTen == 0 && bHundred == 0)
            return "";

        String[] strUnitSuffix = new String[]{"", "một", "hai", "ba", "tư", "lăm", "sáu", "bảy", "tám", "chín"};
        String[] strUnitTen = new String[]{"", "mư�?i một", "mư�?i hai", "mư�?i ba", "mư�?i bốn", "mư�?i lăm",
                "mư�?i sáu", "mư�?i bảy", "mư�?i tám", "mư�?i chín"};
        String[] strUnit = new String[]{"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String[] strTenFirst = new String[]{"", "mư�?i một", "hai mươi mốt", "ba mươi mốt", "bốn mươi mốt",
                "năm mươi mốt", "sáu mươi mốt", "bảy mươi mốt", "tám mươi mốt", "chín mươi mốt"};
        String[] strTen = new String[]{"", "mư�?i", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi",
                "bảy mươi", "tám mươi", "chín mươi"};
        String[] strHundred = new String[]{"không trăm", "một trăm", "hai trăm", "ba trăm", "bốn trăm", "năm trăm",
                "sáu trăm", "bảy trăm", "tám trăm", "chín trăm"};
        String strReturn = "";

        if (bMax || bHundred > 0)
            strReturn = strHundred[bHundred];
        if (bTen > 0) {
            if (strReturn.length() > 0)
                strReturn += " ";
            if (bUnit > 0) {
                if (bTen == 1)
                    strReturn += strUnitTen[bUnit];
                else {
                    if (bUnit == 1)
                        strReturn += strTenFirst[bTen];
                    else
                        strReturn += strTen[bTen] + " " + strUnitSuffix[bUnit];
                }
            } else
                strReturn += strTen[bTen];
        } else {
            if (bUnit > 0) {
                if (strReturn.length() > 0)
                    strReturn += " linh " + strUnit[bUnit];
                else
                    strReturn = strUnit[bUnit];
            }
        }
        return strReturn;
    }

    /**
     * align(String str, int iAlignment, int iLength)
     * @param str String
     * @param iAlignment int
     * @param iLength int
     * @return buf
     */
    public static String align(String str, int iAlignment, int iLength) {
        if (str == null)
            return null;
        if (str.length() > iLength)
            return str.substring(0, iLength);
        StringBuffer buf = new StringBuffer();
        if (iAlignment == ALIGN_CENTER) {
            int iFirstLength = (iLength - str.length()) / 2;
            for (int iIndex = 0; iIndex < iFirstLength; iIndex++)
                buf.append(" ");
            buf.append(str);
            for (int iIndex = str.length() + iFirstLength; iIndex < iLength; iIndex++)
                buf.append(" ");
        } else if (iAlignment == ALIGN_RIGHT) {
            iLength = iLength - str.length();
            for (int iIndex = 0; iIndex < iLength; iIndex++)
                buf.append(" ");
            buf.append(str);
        } else {
            buf.append(str);
            for (int iIndex = str.length(); iIndex < iLength; iIndex++)
                buf.append(" ");
        }
        return buf.toString();
    }

    /**
     * compareVietnameseString(String o1, String o2): so sanh 2 chuoi tieng Viet
     * @param o1 String
     * @param o2 String
     * @return kq
     */
    public static int compareVietnameseString(String o1, String o2) {
        return compareString(o1, o2, new Locale("vi"));
    }

    /**
     * Kiem tra chuoi null hoac empty
     * @param str String
     * @return kq
     */
    public static boolean stringIsNullOrEmty(String str) {
        if (str == null)
            return true;
        else {
            if (str.trim().length() <= 0)
                return true;
        }
        return false;
    }

    /**
     * kiem tra object null hoac empty
     * @param str Object
     * @return kq
     */
    public static boolean stringIsNullOrEmty(Object str) {
        if (str == null)
            return true;
        else {
            if (str.toString().trim().length() <= 0)
                return true;
        }
        return false;
    }

    /**
     * compareString(String strObj1, String strObj2, Locale locale)
     * @param strObj1 String
     * @param strObj2 String
     * @param locale String
     * @return ket qua
     */
    public static int compareString(String strObj1, String strObj2, Locale locale) {
        final String DELIMITERS = "\\p{Cntrl}\\s\\p{Punct}\u0080-\u00BF\u2000-\uFFFF";
        Collator primary = null;
        Collator secondary = null;
        if (primary == null) {
            primary = Collator.getInstance(locale);
            secondary = (Collator) primary.clone();
            secondary.setStrength(Collator.SECONDARY);
        }

        int result;
        String[] s1 = (" " + strObj1).split("[" + DELIMITERS + "]+");
        String[] s2 = (" " + strObj2).split("[" + DELIMITERS + "]+");
        for (int i = 1; i < s1.length && i < s2.length; i++) {
            result = secondary.compare(s1[i], s2[i]);
            if (result != 0) {
                return result;
            }
        }

        if (s1.length > s2.length) {
            return 1;
        } else if (s1.length < s2.length) {
            return -1;
        }

        for (int i = 1; i < s1.length; i++) {
            result = primary.compare(s1[i], s2[i]);
            if (result != 0) {
                return result;
            }

        }

        s1 = (strObj1 + " ").split("[^" + DELIMITERS + "]+");
        s2 = (strObj2 + " ").split("[^" + DELIMITERS + "]+");

        for (int i = 1; i < s1.length - 1 && i < s2.length - 1; i++) {
            result = primary.compare(s1[i], s2[i]);
            if (result != 0) {
                return result;
            }
        }

        result = primary.compare(s1[0], s2[0]);

        if (result != 0) {
            return result;
        }

        return primary.compare(strObj1, strObj2);
    }

    /**
     * stringToArrayList(String strData, String chSplit)
     * @param strData String
     * @param chSplit String
     * @return kq
     */
    public static ArrayList<String> stringToArrayList(String strData, String chSplit) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            String[] arr = strData.split(chSplit);
            for (String string : arr) {
                list.add(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * stringHMSToMillis(String strHMS)
     * @param strHMS String
     * @return kq
     */
    public static Long stringHMSToMillis(String strHMS) {
        if (stringIsNullOrEmty(strHMS))
            return null;

        String[] arrStr = strHMS.split(":");
        if (arrStr.length == 3) {
            int h = Integer.parseInt(arrStr[0]);
            int m = Integer.parseInt(arrStr[1]);
            int s = Integer.parseInt(arrStr[2]);
            long mH = h * (60 * (60 * 1000));
            long mM = m * (60 * 1000);
            long mS = s * 1000;
            return (mH + mM + mS);
        } else
            return null;
    }

    /**
     * strCodeToList(String str)
     * @param str String
     * @return kq
     */
    public static List<String> strCodeToList(String str) {
        List<String> list = new ArrayList<String>();
        String[] arrStr = str.split(",");
        for (String string : arrStr) {
            list.add(string);
        }
        return list;
    }

    /**
     * convertListToString(List<Object> list)
     * @param list List<Object>
     * @return data
     */
    public static String convertListToString(List<Object> list) {
        String data = "";
        if (list != null) {
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        data += "'" + list.get(i) + "'";
                    } else {
                        data += "'" + list.get(i) + "',";
                    }
                }
            }
        }
        return data;
    }

    /**
     * convert list to String
     * @param list List<String>
     * @param strSeparator String
     * @return String
     */
    public static String listToString(List<String> list, String strSeparator) {
        String str = null;
        for (Object string : list) {
            if (str == null) {
                if (string instanceof BigDecimal) {
                    str = String.valueOf(string);
                } else {
                    str = string.toString();
                }
            } else {
                if (string instanceof BigDecimal) {
                    str += strSeparator + String.valueOf(string);
                } else {
                    str += strSeparator + string.toString();
                }
            }
        }
        return str;
    }

    /**
     * convert list to String
     * @param list List<String>
     * @param strSeparator String
     * @param strChar String
     * @return String
     */
    public static String listToString(List<String> list, String strSeparator, String strChar) {
        String str = null;
        for (String string : list) {
            if (str == null) {
                str = strChar + string + strChar;
            } else {
                str += strSeparator + strChar + string + strChar;
            }
        }
        return str;
    }

    /**
     * lay random gia tri trong khoang min; max
     * @param min int
     * @param max int
     * @return gia tri random
     */
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * isNumericLong(String str)
     * @param str String
     * @return Long.parseLong(str)
     */
    public static boolean isNumericLong(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * sondt18 convert "FIELD_NAME" to "fieldName"
     *
     * @param name String
     * @return name
     */
    public static String enFieldName(String name) {
        try {
            StringBuilder nameStr = new StringBuilder(name.toLowerCase());
            if (nameStr.indexOf("_") == 0) {
                nameStr.deleteCharAt(0);
            }
            while (nameStr.indexOf("_") >= 0) {
                int i = nameStr.indexOf("_") + 1;
                if (i < nameStr.length()) {
                    nameStr.setCharAt(i, Character.toUpperCase(nameStr.charAt(i)));
                }
                nameStr.deleteCharAt(i - 1);
            }
            return nameStr.toString().replaceAll("_", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * sondt18 convert "fieldName" to "FIELD_NAME"
     *
     * @param name String
     * @return name
     */
    public static String deFieldName(String name) {
        try {
            StringBuilder nameStr = new StringBuilder(name);
            StringBuilder newName = new StringBuilder();
            for (int i = 0; i < nameStr.length(); i++) {
                if (nameStr.charAt(i) == Character.toUpperCase(nameStr.charAt(i))) {
                    newName.append("_");
                }
                newName.append(Character.toUpperCase(nameStr.charAt(i)));
            }
            return newName.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * getParamSQLWithLike(String param)
     * @param param String
     * @return param.trim()
     */
    public static String getParamSQLWithLike(String param) {
        if (StringUtil.stringIsNullOrEmty(param)) {
            return "";
        }
        return "%" + param.trim() + "%";
    }

    /**
     * checkValidPath(String path)
     * @param path String
     * @return Pattern.matches(regularExpression, path)
     */
    public static boolean checkValidPath(String path) {
        String regularExpression = "((/)*[a-zA-Z0-9_-]+(/)*)+";
        Pattern.compile(regularExpression);
        return Pattern.matches(regularExpression, path);
    }

    /**
     * extractDirectoryPath(String path)
     * @param path String
     * @return path
     */
    public static String extractDirectoryPath(String path) {
        int index = path.lastIndexOf("/");
        return path.substring(0, index);
    }

    /**
     * extractFileName(String path)
     * @param path String
     * @return path
     */
    public static String extractFileName(String path) {
        int index = path.lastIndexOf("/");
        return path.substring(index);
    }

    /**
     * trimPhoneNumber
     * @param msisdn String
     * @return msisdn
     */
    public static String trimPhoneNumber(String msisdn) {
        if (StringUtil.stringIsNullOrEmty(msisdn)) {
            return "";
        } else {
            msisdn = msisdn.trim();
            if (msisdn.startsWith("0")) {
                msisdn = msisdn.substring(1);
            } else if (msisdn.startsWith("84")) {
                msisdn = msisdn.substring(2);
            } else if (msisdn.startsWith("+84")) {
                msisdn = msisdn.substring(3);
            }
        }
        return msisdn;
    }

    /**
     * objectToXml(Object messageContent, Class c)
     * @param messageContent Object
     * @param c Class
     * @return stringWriter
     * @throws Exception ex
     */
    public static String objectToXml(Object messageContent, Class c) throws Exception {
        Marshaller marshaller = JAXBContext.newInstance(c).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(messageContent, stringWriter);
        return stringWriter.toString();
    }

    /**
     * xu ly xml?
     * @param tagName String
     * @param element Element
     * @return kq
     */
    public static String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }
        return null;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * cleanPath(String fullPath)
     * @param fullPath String
     * @return fullPath
     */
    public static String cleanPath(String fullPath) {
        if (stringIsNullOrEmty(fullPath))
            return fullPath;
        int index = fullPath.lastIndexOf(File.separator);
        return fullPath.substring(index + 1);
    }

    /**
     * formatCurrency(String number, char separate)
     * @param number String
     * @param separate char
     * @return formatter.format(value)
     */
    public static String formatCurrency(String number, char separate) {
        try {
            if (StringUtil.stringIsNullOrEmty(number)) {
                return "0";
            }
            Long value = Long.parseLong(number, 10);
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.UK);
            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

            symbols.setGroupingSeparator(separate);
            formatter.setDecimalFormatSymbols(symbols);
            return formatter.format(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    /**
     * check list null or empty
     * @param lst List
     * @return kq
     */
    public static boolean isListEmpty(List lst) {
        return lst == null || lst.isEmpty();
    }

    /**
     * replaceVariableInString(String inputString, String[] values)
     * @param inputString String
     * @param values String[]
     * @return MessageFormat.format(inputString, values)
     */
    public static String replaceVariableInString(String inputString, String[] values) {
        if (Objects.isNull(inputString))
            return null;
        return MessageFormat.format(inputString, values);
    }

    /**
     * replaceCountryCode(String input, String[] countryCodes)
     * @param input String
     * @param countryCodes String[]
     * @return input
     */
    public static String replaceCountryCode(String input, String[] countryCodes) {
        String mobiNumber = input.trim();
        for (String data : countryCodes) {
            int index = mobiNumber.indexOf(data);
            if (index < 0)
                continue;
            else {
                return "0" + mobiNumber.substring(data.length()).trim();
            }
        }
        return input;
    }

    /**
     * check string is empty
     * @param input String
     * @return kq
     */
    public static boolean isNullOrEmptyCore(String input) {
        return StringUtils.isEmpty(input);
    }

    /**
     *  check String is null || "null" || ""
     * @param input String
     * @return kq
     */
    public static boolean isNullOrEmpty(String input) {
        return (StringUtils.isEmpty(input) || input.equals("null") || input.equals(""));
    }

    /**
     * check String is ""
     * @param input String
     * @return kq
     */
    public static boolean isEmpty(String input) {
        return input.equals("");
    }

    /**
     * check object is null || ""
     * @param obj1 Object
     * @return kq
     */
    public static boolean isStringNullOrEmpty(Object obj1) {
        return obj1 == null || "".equals(obj1.toString().trim());
    }

    /**
     * kiem tra isNullOrEmpty cua gia tri truyen vao
     * @param cs CharSequence
     * @return ket qua
     */
    public static boolean isNullOrEmpty(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * check Collection is null || empty
     * @param collection Collection
     * @return kq
     */
    public static boolean isNullOrEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * check Object[] is null || ""
     * @param collection Object[]
     * @return kq
     */
    public static boolean isNullOrEmpty(final Object[] collection) {
        return collection == null || collection.length == 0;
    }

    /**
     * check map null || empty
     * @param map Map
     * @return kq
     */
    public static boolean isNullOrEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * check object is null
     * @param obj1 Object
     * @return kq
     */
    public static boolean isNullObject(Object obj1) {
        if (obj1 == null) {
            return true;
        }
        if (obj1 instanceof String) {
            return isNullOrEmpty(obj1.toString());
        }
        return false;
    }

    /**
     * check long is null || = 0
     * @param value Long
     * @return kq
     */
    public static boolean isNullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }

    /**
     * check Double is null || = 0
     * @param value Double
     * @return kq
     */
    public static boolean isNullOrZero(Double value) {
        return (value == null || value == 0);
    }

    /**
     * check string is null || = 0
     * @param value String
     * @return kq
     */
    public static boolean isNullOrZero(String value) {
        return (value == null || safeToLong(value).equals(0L));
    }

    /**
     * check Integer is null || = 0
     * @param value Integer
     * @return kq
     */
    public static boolean isNullOrZero(Integer value) {
        return (value == null || value.equals(0));
    }

    /**
     * check Long is null || = -1
     * @param value Long
     * @return kq
     */
    public static boolean isNullOrOneNavigate(Long value) {
        return (value == null || value.equals(-1L));
    }

    /**
     * check Long is null || <=0
     * @param value Long
     * @return kq
     */
    public static boolean isNullOrNotGreaterZero(Long value) {
        return (value == null || value.compareTo(0L) <= 0);
    }

    /**
     * check BigDecimal is null || = 0
     * @param value BigDecimal
     * @return kq
     */
    public static boolean isNullOrZero(BigDecimal value) {
        return (value == null || value.compareTo(BigDecimal.ZERO) == 0);
    }

    /**
     * safeToLong từ 1 obj
     * @param obj1 Object
     * @param defaultValue Long : gia tri mac dinh neu loi
     * @return giá trị sau convert
     */
    public static Long safeToLong(Object obj1, Long defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }
        if (obj1 instanceof BigDecimal) {
            return ((BigDecimal) obj1).longValue();
        }
        if (obj1 instanceof BigInteger) {
            return ((BigInteger) obj1).longValue();
        }
        if (obj1 instanceof Double) {
            return ((Double) obj1).longValue();
        }

        try {
            return Long.parseLong(obj1.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * safeToLong từ 1 obj tr ra giá trị mặc định là 0 neu lỗi
     * @param obj1 Object
     * @return gia tri sau khi convert
     */
    public static Long safeToLong(Object obj1) {
        return safeToLong(obj1, 0L);
    }

    /**
     * safeToDouble từ 1 obj
     * @param obj1 Object
     * @param defaultValue Double : gia tri mac dinh neu loi
     * @return giá trị sau convert
     */
    public static Double safeToDouble(Object obj1, Double defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(obj1.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * safeToDouble từ 1 obj tr ra giá trị mặc định là 0 neu lỗi
     * @param obj1 Object
     * @return gia tri sau khi convert
     */
    public static Double safeToDouble(Object obj1) {
        return safeToDouble(obj1, 0.0);
    }

    /**
     * safeToShort(Object obj1, Short defaultValue)
     * @param obj1 Object
     * @param defaultValue Short
     * @return kq
     */
    public static Short safeToShort(Object obj1, Short defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }
        try {
            return Short.parseShort(obj1.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * convert Object to Short
     * @param obj1 Object
     * @return ket qua
     */
    public static Short safeToShort(Object obj1) {
        return safeToShort(obj1, (short) 0);
    }

    /**
     * safeToInt(Object obj1, int defaultValue)
     * @param obj1 Object
     * @param defaultValue String
     * @return safeToInt
     * @author phuvk
     */
    public static int safeToInt(Object obj1, int defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(obj1.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * safeToInt(Object obj1)
     * @param obj1 Object
     * @return int
     */
    public static int safeToInt(Object obj1) {
        return safeToInt(obj1, 0);
    }

    /**
     * convert Object to String neu obj null thi tra ra defaultValue
     * @param obj1 Object
     * @param defaultValue String
     * @return String sau khi format
     */
    public static String safeToString(Object obj1, String defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }

        return obj1.toString().trim();
    }

    /**
     * safeToString từ 1 obj
     * @param obj1 Object
     * @return giá trị sau convert
     */
    public static String safeToString(Object obj1) {
        return safeToString(obj1, "");
    }

    /**
     * safeToDate từ 1 obj
     * @param obj1 Object
     * @return giá trị sau convert kieu Date
     */
    public static Date safeToDate(Object obj1) {
        if (obj1 == null) {
            return null;
        }
        return (Date) obj1;
    }

    public static BigDecimal safeToDecimal(Object obj1, BigDecimal defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }
        try {
            return new BigDecimal(obj1.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static BigDecimal safeToDecimal(Object obj1) {
        return safeToDecimal(obj1, BigDecimal.valueOf(0));
    }

    /**
     * string2Date(String value, String format)
     * @param value String
     * @param format String
     * @return dbUpdateDateTime.parse(value)
     */
    public static Date string2Date(String value, String format) {
        try {
            if (!isStringNullOrEmpty(value)) {
                SimpleDateFormat dbUpdateDateTime = new SimpleDateFormat(format);
                dbUpdateDateTime.setLenient(false);
                return dbUpdateDateTime.parse(value);
            }

        } catch (ParseException ex) {
        }
        return null;
    }

    /**
     * Lay duong dan tu url nhan duoc, dang co 2 truong hop test local duong dan file la http va manualFile,
     * nhan tren dev, uat: https va accounting/temp
     * @param isUploadLocal boolean
     * @param path String
     * @return modifiedUrl
     */
    public static String getModifiedUrl(boolean isUploadLocal, String path) {
        String url = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .build()
                .toUriString();
        String pathTemp = url.concat(path);
        String modifiedUrlTemp = pathTemp.replace("accounting/action", isUploadLocal
                ? "manualFile" : "accounting/manualFile");
        String modifiedUrl = modifiedUrlTemp;
        if (!isUploadLocal) {
            modifiedUrl = modifiedUrlTemp.replace("http", "https");
        }
        return modifiedUrl;
    }

    /**
     * Lay duong dan tu url nhan duoc, dang co 2 truong hop test local duong dan file la http va manualFile,
     * nhan tren dev, uat: https va accounting/temp
     * @param isUploadLocal boolean
     * @param path String
     * @param checkAsync boolean
     * @return url co the xem duoc file
     */
    public static String getModifiedUrlTemp(boolean isUploadLocal, String path, boolean checkAsync) {
        String url = checkAsync ? "" : ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .build()
                .toUriString();
        String pathTemp = url.concat(path);
        String modifiedUrlTemp = pathTemp.replace("accounting/temp", isUploadLocal
                ? "manualFile" : "accounting/manualFile");
        String modifiedUrl = modifiedUrlTemp;
        if (!isUploadLocal) {
            modifiedUrl = modifiedUrlTemp.replace("http", "https");
        }
        return modifiedUrl;
    }

    /**
     * Dem so ky tu 1 chuoi
     * @param input String
     * @return so luong ky tu
     */
    public static int countCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return input.codePointCount(0, input.length());
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

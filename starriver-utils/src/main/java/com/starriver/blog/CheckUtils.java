package com.starriver.blog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: CheckUtils
 * @Description: 校验工具类
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public class CheckUtils {

    static String CHECK_EMAIL_REGEX = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    static String CHECK_MOBILE_NUMBER_REGEX = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 校验邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile(CHECK_EMAIL_REGEX);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 校验手机号
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile(CHECK_MOBILE_NUMBER_REGEX);
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}


package org.pettyfox.base.comm.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/13</p>
 * <p></p>
 * 文本安全隐藏工具
 *
 * @author Petty Fox
 */
public class SecretTextUtil {
    public static String phone(String phone) {
        if (StringUtils.isNotBlank(phone)) {
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return phone;
    }

    public static String idcard(String idcard) {
        if (StringUtils.isNotBlank(idcard)) {
            return idcard.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
        }
        return idcard;
    }
    public static String email(String email) {
        if (StringUtils.isNotBlank(email)) {
            return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        }
        return email;
    }
}

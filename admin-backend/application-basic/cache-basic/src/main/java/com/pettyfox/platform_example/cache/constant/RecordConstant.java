package com.pettyfox.platform_example.cache.constant;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/12/3</p>
 * <p></p>
 *
 * @author Petty Fox
 */
public class RecordConstant {

    private static String KEY_GROUP = "record::";
    /**
     * 今日ai检出总数
     */
    public static String KEY_TODAY_AI_CHECKOUT_COUNT = KEY_GROUP + "todayAiCheckoutCount";

    /**
     * 今日ai识别总数
     */
    public static String KEY_TODAY_AI_TOTAL_COUNT = KEY_GROUP + "todayAiTotalCount";

    public static String KEY_AI_STA = KEY_GROUP + "aiSta";
}

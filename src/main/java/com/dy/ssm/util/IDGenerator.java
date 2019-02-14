package com.dy.ssm.util;

import java.util.UUID;

/**
 * @author daiyun
 * @date 2018-6-5
 */
public class IDGenerator {

    /**
     * 生成主键（32位）
     *
     * @return
     */
    public static String generateID() {
        return generateID(System.currentTimeMillis());
    }

    /**
     * 根据指定时间生成主键
     *
     * @param time
     * @return
     */
    public static String generateID(long time) {
        String rtnVal = Long.toHexString(time);
        rtnVal += UUID.randomUUID();
        rtnVal = rtnVal.replaceAll("-", "");
        return rtnVal.substring(0, 32);
    }



    public static void main(String[] args) {
        System.out.println(generateID());
    }
}

package com.dy.ssm.util;

import java.util.Collection;

/**
 * @author daiyun
 * @date 2018-6-5
 */
public class ArrayUtils {


    public static boolean isEmpty(Collection collection) {
        if (collection == null){
            return true;
        }
        return collection.isEmpty();
    }
}

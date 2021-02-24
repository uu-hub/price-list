package io.zbc.price.util;

import static io.zbc.price.util.SignUtil.MINUS;
import static io.zbc.price.util.SignUtil.SPACE;

/**
 * @author Jay.H.Zou
 * @date 8/20/2019
 */
public class CommonUtil {

    public static String replaceSpace(String original) {
        return original.replaceAll(SPACE, MINUS);
    }

}

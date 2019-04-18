package com.hiveview.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author huxunqiang created on 2019/4/16
 */
public class VerifyCodeUtil {
    public static Map<String, Object> checkPhoneNumber(String phone){
        Map<String, Object> result = Maps.newHashMap();
        result.put("flag", true);
        if(StringUtils.isEmpty(phone)){
            result.put("flag", false);
            result.put("msg", "手机号不能为空");
            return result;
        }
        if(!phone.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){
            result.put("flag", false);
            result.put("msg", "手机号不正确");
            return result;
        }
        return result;
    }
}

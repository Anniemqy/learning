package com.hiveview.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Random;

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

    /**
     * 生成指定位数的验证码
     * @param bix
     * @return
     */
    public static String createVerifyCode(int bix){
        String code = "";
        if(bix > 0){
            StringBuilder sb = new StringBuilder(bix);
            Random rand = new Random();
            for(int i = 0; i < bix; i++){
                sb.append(rand.nextInt(bix));
            }
            code = sb.toString();
        }
        return code;
    }
}

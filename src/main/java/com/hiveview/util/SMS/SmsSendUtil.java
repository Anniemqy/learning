package com.hiveview.util.SMS;

import com.google.common.collect.Maps;
import com.hiveview.util.validateCode.ValidateCode;
import com.hiveview.util.validateCode.ValidateCodeUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author huxunqiang created on 2019/4/17
 */
public class SmsSendUtil {
    public static HashMap<String, Object> validateSmsAndImgCode(HttpServletRequest request){
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("flag", false);
        String type = request.getParameter("verifyType");
        String imgCode = request.getParameter("imgCode");
        // 验证图片验证码
        ValidateCode imgVerify = ValidateCodeUtil.validateImgCode(request, imgCode, type);
        if(!imgVerify.isSuccess()){
            result.put("msg", imgVerify.getMsg());
            return result;
        }
        return null;
    }
}

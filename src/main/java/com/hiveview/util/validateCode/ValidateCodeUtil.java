package com.hiveview.util.validateCode;

import com.hiveview.util.VerifyUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author huxunqiang created on 2019/4/17
 */
public class ValidateCodeUtil {
    public static ValidateCode validateImgCode(HttpServletRequest request, String verifyCode, String type){
        ValidateCode validateCode;
        if(StringUtils.isNotEmpty(verifyCode) && StringUtils.isNotEmpty(type)){
            if("reg".equals(type)){
                type = VerifyUtil.ImgVerifyType.REGISTER.getVal();
            }else{
                type = VerifyUtil.ImgVerifyType.RETRIEVE_PASSWORD.getVal();
            }
             validateCode = ValidateCodeUtil.verifyCode(request, verifyCode, type);
        }else{
            validateCode = new ValidateCode();
            validateCode.setSuccess(false);
            validateCode.setMsg("验证码错误");
        }
        return validateCode;
    }

    public static ValidateCode verifyCode(HttpServletRequest request, String verifyCode, String type){
        Boolean flag = false;
        String message = "";
        HttpSession session = request.getSession();
        ValidateCode verifyVal = (ValidateCode)session.getAttribute(type);
        if(verifyVal != null){
            String code = verifyVal.getCode();
            if(StringUtils.isNotEmpty(code) && code.toLowerCase().equals(verifyCode.toLowerCase())){
                flag = true;
            }else {
                message = "验证码错误";
            }
        }else{
            message = "请输入验证码";
        }
        ValidateCode result = new ValidateCode();
        result.setSuccess(flag);
        result.setMsg(message);
        return result;
    }
}

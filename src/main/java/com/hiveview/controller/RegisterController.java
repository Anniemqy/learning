package com.hiveview.controller;

import com.hiveview.model.Member;
import com.hiveview.service.IRegisterService;
import com.hiveview.util.SMS.SmsSendUtil;
import com.hiveview.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author huxunqiang created on 2019/4/16
 */

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    /**
     * 注册会员
     * @param request
     * @param member
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerMember")
    public Map registerMember(HttpServletRequest request, Member member){
        String phone = member.getMobile();
        Map<String, Object> result = VerifyCodeUtil.checkPhoneNumber(phone);
        if (!(Boolean) result.get("flag")) {
            return result;
        }

        // 校验验证码和短信验证码
        result = SmsSendUtil.validateSmsAndImgCode(request);


        if(!registerService.checkPhoneRegister(phone)){
            // 未注册，进行注册

        }
        return null;
    }
}

package com.hiveview.controller;

import com.hiveview.model.Member;
import com.hiveview.service.IMemberService;
import com.hiveview.service.IRegisterService;
import com.hiveview.util.InviteCodeUtil;
import com.hiveview.util.VerifyCodeUtil;
import com.hiveview.util.log.LogMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hiveview.util.MemberUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @Autowired
    private IMemberService memberService;

    /**
     * 注册会员
     * @param request
     * @param member
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerMember")
    public Map registerMember(HttpServletRequest request, Member member){
        String mobile = member.getMobile();
        Map<String, Object> result = VerifyCodeUtil.checkPhoneNumber(mobile);
        if (!(Boolean) result.get("flag")) {
            return result;
        }

        // 校验验证码和短信验证码
//        result = SmsSendUtil.validateSmsAndImgCode(request);

        Boolean flag = false;
        String msg = "";

        if(!registerService.checkPhoneRegister(mobile)){
            // 未注册，进行注册
            try {
                member.setStatus(MemberUtil.STATUS.getDisable());
                member.setAddTime(new Date());
                member.setInviteCode(InviteCodeUtil.getInviteCode());
                if(memberService.saveMember(member) > 0){
                    String pass = member.getPassword() + member.getId(); //密码加会员id加密
                    member.setPassword(DigestUtils.md5DigestAsHex(pass.getBytes()));
                    member.setStatus(MemberUtil.STATUS.getNormal());
                    memberService.updateMember(member);
                    flag = true;
                    msg = "注册成功!";
                }
            } catch (Exception e) {
                LogMgr.writeErrorLog("保存会员信息出错", e);
                flag = false;
                msg = "保存会员信息出错";
            }
        }

        result.put("flag", flag);
        result.put("msg", msg);

        return result;
    }
}

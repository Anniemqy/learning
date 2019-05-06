package com.hiveview.controller;

import com.google.common.collect.Maps;
import com.hiveview.model.Member;
import com.hiveview.model.Msg;
import com.hiveview.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-05-05
 * Time: 16:19
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    IMemberService memberService;

    @ResponseBody
    @RequestMapping("/login")
    public Map login(HttpServletRequest request, Member member){
        Boolean flag = false;
        String msg = "用户名或密码错误";
        Map<String, Object> result = Maps.newHashMap();
        try{
            String mobile = member.getMobile();
            if(mobile != null){
                Member tempMember = memberService.getMemberByMobile(mobile);
                if (tempMember != null) {
                    String pass = member.getPassword()+ tempMember.getId();//密码加会员id加密
                    member.setPassword(DigestUtils.md5DigestAsHex(pass.getBytes()));
                    Member currentUser = memberService.getMemberInfo(member);
                    if (currentUser != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("currentUser", currentUser);
                        String sessionId = session.getId();
                        //登录用户的信息放到application
                        ServletContext application = session.getServletContext();
                        Msg.getInstance().put(currentUser.getId().toString(), sessionId);
                        application.setAttribute("sessionIdMap", Msg.sessionIdMap);
                        flag = true;
                        msg = "登录成功！";
                        String fromUrl = request.getParameter("formUrl");
//                        if (StringUtils.isNotEmpty(fromUrl)) { //todo
//                            result.put("fromUrl", fromUrl);
//                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            msg = "登录异常";
        }

        result.put("flag", flag);
        result.put("msg", msg);
        return result;
    }
}

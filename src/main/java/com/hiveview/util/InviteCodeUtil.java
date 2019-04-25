package com.hiveview.util;

public class InviteCodeUtil {

    /**
     * 获得一个随机邀请码
     * @return
     */
    public static String getInviteCode(){
        String code = System.currentTimeMillis() + VerifyCodeUtil.createVerifyCode(1);
        return code;
    }
}

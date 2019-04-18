package com.hiveview.util;

/**
 * @author huxunqiang created on 2019/4/16
 */
public class VerifyUtil {
    public enum ImgVerifyType{
        REGISTER("registerVerifyCode"), //注册
        RETRIEVE_PASSWORD("retrievePasswordVerifyCode");//找回密码

        private String val;

        ImgVerifyType(String p) {
            this.val = p;
        }
        public String getVal() {
            return val;
        }
    }
}

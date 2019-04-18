package com.hiveview.util.validateCode;

/**
 * @author huxunqiang created on 2019/4/17
 */
public class ValidateCode {
    /**
     * 是否
     */
    private boolean isSuccess;

    /**
     * code ,1d 23
     */
    private String code;

    private String codePath;

    private String msg;

    private int verifyTimes;//验证次数

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVerifyTimes() {
        return verifyTimes;
    }

    public void setVerifyTimes(int verifyTimes) {
        this.verifyTimes = verifyTimes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }
}

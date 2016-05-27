package com.ghy.baseapp.api;

/**
 * Created by GHY on 2016/5/3.
 * retCode 和 msg 提出来
 * retCode：状态码，msg：提示信息
 */
public class ResponseData {

    public int retCode;
    public String msg;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "retCode=" + retCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}

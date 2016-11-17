package com.wangqu.kuaqu.response;

/**
 * Created by Administrator on 2016/11/10.
 */

public class Loginbean {


    /**
     * result : 404
     * msg : 账号密码不正确
     */

    private String result;
    private String msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

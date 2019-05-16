package com.majianwei.common;

//后台返回给前台的一个基本的JSON对象
public class JsonResult {
    private boolean success = true;
    private String msg;

    public JsonResult() {}

    public JsonResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

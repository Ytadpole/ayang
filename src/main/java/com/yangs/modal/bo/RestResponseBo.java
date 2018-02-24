package com.yangs.modal.bo;

/**
 * Created by Ytadpole on 2018/2/24.
 * 统一响应
 */
public class RestResponseBo <T>{
    /**
     * 请求结果
     */
    private boolean isSuccess;
    /**
     * 错误描述
     */
    private String message;
    /**
     * 响应码
     */
    private int code = -1;
    /**
     * 响应时间
     */
    private  long responseTime;
    /**
     * 内容
     */
    private T body;

    public RestResponseBo(boolean isSuccess) {
        this(isSuccess, null, null);
    }

    public RestResponseBo(boolean isSuccess, T body) {
        this(isSuccess, null, body);
    }

    public RestResponseBo(boolean isSuccess, int code, T body) {
        this(isSuccess, null, code, body);
    }

    public RestResponseBo(boolean isSuccess, String messeage) {
        this(isSuccess, messeage, null);
    }

    public RestResponseBo(boolean isSuccess, String messeage, int code) {
        this(isSuccess, messeage, code, null);
    }

    public RestResponseBo(boolean isSuccess, String message, T body) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.responseTime = System.currentTimeMillis() / 1000;
        this.body = body;
    }

    public RestResponseBo(boolean isSuccess, String message, int code, T body) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.code = code;
        this.responseTime = System.currentTimeMillis() / 1000;
        this.body = body;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static RestResponseBo ok(){
        return new RestResponseBo(true);
    }

    public static RestResponseBo fail(){
        return new RestResponseBo(false);
    }

}

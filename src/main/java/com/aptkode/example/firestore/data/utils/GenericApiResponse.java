package com.aptkode.example.firestore.data.utils;

public class GenericApiResponse<T> {
    private String status;
    private String message;
    private String stackTrace;
    private int code;
    private T body ;

    public GenericApiResponse(String status, String message, String stackTrace,int code, T body) {
        this.status = status;
        this.message = message;
        this.stackTrace = stackTrace;
        this.body = body;
        this.code=code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}

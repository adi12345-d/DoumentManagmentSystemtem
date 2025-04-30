package com.document.dmdemo.response;

public class Response {
    private String responseCode;
    private String responseMessage;
    private Object successObject;

    // Getters and Setters
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getSuccessObject() {
        return successObject;
    }

    public void setSuccessObject(Object successObject) {
        this.successObject = successObject;
    }
}
package com.alfian.latihanspring.helper;

public class Json {
    private Boolean status;
    private String message;
    private Object[] data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public Json(Boolean status, String message, Object[] data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}

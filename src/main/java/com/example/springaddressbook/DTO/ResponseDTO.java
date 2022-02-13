package com.example.springaddressbook.DTO;

public class ResponseDTO {
    private String message;
    private Object data;

    public String getMessage(){
        return message;
    }
    public void setMessage(){
        this.message = message;
    }
    public Object getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }
    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data = data;
    }
}

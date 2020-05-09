package com.fluex404.springbootweb.utils;

import com.fluex404.springbootweb.modal.BaseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CommonUtils {
    public ResponseEntity<BaseModel> handleError(Exception e){
        BaseModel base = new BaseModel();
        base.setData(null);
        base.setMessage(e.getMessage());
        base.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(base, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public void handleSuccess(BaseModel base, Object data){
        base.setMessage("success");
        base.setStatus(HttpStatus.OK.value());
        base.setData(data);
    }
}

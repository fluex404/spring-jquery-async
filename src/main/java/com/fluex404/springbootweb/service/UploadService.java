package com.fluex404.springbootweb.service;

import org.springframework.stereotype.Component;

@Component
public class UploadService {
    public void upload() throws Exception{
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
        }
    }
}

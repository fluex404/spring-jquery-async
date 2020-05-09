package com.fluex404.springbootweb.api;

import com.fluex404.springbootweb.modal.BaseModel;
import com.fluex404.springbootweb.service.UploadService;
import com.fluex404.springbootweb.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@RestController
@RequestMapping("/api/upload")
public class Upload {

    private CommonUtils commonUtils;
    private UploadService uploadService;

    @Autowired
    public Upload(CommonUtils commonUtils, UploadService uploadService) {
        this.commonUtils = commonUtils;
        this.uploadService = uploadService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseModel> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type){
        BaseModel base = new BaseModel();
        try{

            if("Error".equals(type))
                throw new Exception("Ada error nih, cek dibagian ini ...");

            byte[] bytes = file.getBytes();

            // bisnis logic
            uploadService.upload();

            commonUtils.handleSuccess(base, null);
        }catch(Exception e) {
            return commonUtils.handleError(e);
        }
        return new ResponseEntity<>(base, HttpStatus.OK);
    }
}

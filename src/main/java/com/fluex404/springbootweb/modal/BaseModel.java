package com.fluex404.springbootweb.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    private int status;
    private String message;
    private Object data;
}

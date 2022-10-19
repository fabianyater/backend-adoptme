package com.adoptme.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {
    private String message;
    private Object data;
    private String token;
}

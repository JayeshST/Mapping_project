package com.app.response;

import lombok.*;

@Getter @Setter @AllArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;
}

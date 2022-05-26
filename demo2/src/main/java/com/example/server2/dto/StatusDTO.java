package com.example.server2.dto;

import com.example.server2.StatusEnum;
import lombok.Data;

@Data
public class StatusDTO {
    private StatusEnum status;
    private String message;
    private Object data;

    public StatusDTO() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}

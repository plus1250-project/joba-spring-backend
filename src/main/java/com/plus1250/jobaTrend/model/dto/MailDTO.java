package com.plus1250.jobaTrend.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MailDTO {
    private String address;
    private String title;
    private String message;

    public MailDTO() {}

    public MailDTO(String address, String title, String message) {
        this.address = address;
        this.title = title;
        this.message = message;
    }
}

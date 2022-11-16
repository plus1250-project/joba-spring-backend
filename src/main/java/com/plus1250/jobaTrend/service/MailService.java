package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.MailDTO;
import com.plus1250.jobaTrend.model.dto.UserDTO;

public interface MailService {
    MailDTO createChangePassword(UserDTO userDTO);
    void updateChangePassword(String str, UserDTO userDTO);
    void mailSend(MailDTO mailDTO);
}

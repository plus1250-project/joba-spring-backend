package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.MailDTO;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

public interface MailService {
    MailDTO createChangePassword(UserDTO userDTO);
    void updateChangePassword(String str, UserDTO userDTO);
    void mailSend(MailDTO mailDTO);
}

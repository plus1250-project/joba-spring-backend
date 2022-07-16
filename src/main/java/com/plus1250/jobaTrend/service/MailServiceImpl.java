package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.MailDTO;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private final UserRepository userRepository;


    private final JavaMailSender javaMailSender;

    private static final String FROM_ADDRESS = "ekthfdh@gmail.com";

    // 메일 내용 생성, 임시 비빌번호 변경
    @Override
    public MailDTO createChangePassword(UserDTO userDTO) {
        System.out.println(userDTO.getEmail() + " | " + userDTO.getNickName());

        String str = getTempPassword();
        MailDTO mailDTO = new MailDTO();
        mailDTO.setAddress(userDTO.getEmail());
        mailDTO.setTitle(userDTO.getNickName() +"님의 JOBA 임시 비밀번호 발급 안내 메일입니다");
        mailDTO.setMessage(userDTO.getNickName() +"님의 임시 비밀번호는" + str + "입니다.");
        updateChangePassword(str, new UserDTO(userDTO.getEmail()));
        return mailDTO;
    }


    // 임시 비밀번호 발송 -> 비밀번호 변경
    @Override
    public void updateChangePassword(String str, UserDTO userDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String pw = encoder.encode(str);
        //int userId = userRepository.findByUserId(email).getUserId();
        System.out.println("updatepw" + userDTO.getEmail());

        User userSave = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        System.out.println("updatepw 받아온 값 : " + userSave.getEmail());

        User saveUser =  User.builder()
                .userId(userSave.getUserId())
                .email(userDTO.getEmail())
                .password(pw)
                .nickName(userSave.getNickName())
                .build();

        userRepository.save(saveUser);

        //userRepository.save(userId, pw);
    }

    // 10자리 랜덤난수 생성
    public static String getTempPassword(){

        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        System.out.println(str);
        return str;

    }

    // STMP
    @Bean
    @Override
    public void mailSend(MailDTO mailDTO) {
        System.out.println("전송 완료!");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDTO.getAddress());
        simpleMailMessage.setFrom(FROM_ADDRESS);
        simpleMailMessage.setSubject(mailDTO.getTitle());
        simpleMailMessage.setText(mailDTO.getMessage());

        javaMailSender.send(simpleMailMessage);
    }
}


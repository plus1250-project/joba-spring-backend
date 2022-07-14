package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.MailDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    private static UserRepository userRepository;

    @Autowired
    private static JavaMailSender javaMailSender;

    private static final String FROM_ADDRESS = "ekthfdh@gmail.com";

    // 메일 내용 생성, 임시 비빌번호 변경
    public static MailDTO createChagePassword(String email, String nickName) {
        System.out.println(email + " | " + nickName);

        String str = getTempPassword();
        MailDTO mailDTO = new MailDTO();
        mailDTO.setAddress(email);
        mailDTO.setTitle(nickName +"님의 JOBA 임시 비밀번호 발급 안내 메일입니다");
        mailDTO.setMessage(nickName +"님의 임시 비밀번호는" + str + "입니다.");
        updateChagePassword(str, email);
        return mailDTO;
    }


    // 임시 비밀번호 발송 -> 비밀번호 변경
    public static void updateChagePassword(String str, String email) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String pw = encoder.encode(str);
        //int userId = userRepository.findByUserId(email).getUserId();
        System.out.println(email);
        User userSave = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        User saveUser =  User.builder()
                .userId(userSave.getUserId())
                .email(email)
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
    public static void mailSend(MailDTO mailDTO) {
        System.out.println("전송 완료!");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDTO.getAddress());
        simpleMailMessage.setFrom(FROM_ADDRESS);
        simpleMailMessage.setSubject(mailDTO.getTitle());
        simpleMailMessage.setText(mailDTO.getMessage());

        javaMailSender.send(simpleMailMessage);
    }
}

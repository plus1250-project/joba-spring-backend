package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.MailDTO;
import com.plus1250.jobaTrend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

    @Autowired
    static
    UserRepository userRepository;

    @Autowired
    private static JavaMailSender javaMailSender;

    private static final String FROM_ADDRESS = "본인 이메일 주소를 입력해 주세요!";

    // 메일 내용 생성, 임시 비빌번호로 변경
    public static MailDTO createMailChagePw(String email) {
        String str = getTempPassword();
        MailDTO mailDTO = new MailDTO();
        mailDTO.setAddress(email);
        mailDTO.setTitle("JOBA 임시 비밀번호 안내 메일입니다");
        mailDTO.setMessage("비밀번호는" + str +"입니다");
        updatePassword(str, email);

        return mailDTO;
    }
    public static void updatePassword(String str, String email){
        String password = str;
        int id = userRepository.findByEmail(email).get().getIdx();
        userRepository.updateUserPassword(password);
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

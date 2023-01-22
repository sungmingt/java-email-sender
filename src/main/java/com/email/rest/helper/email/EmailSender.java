package com.email.rest.helper.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSender {  //추상화한 인터페이스를 통한 이메일 전송 (runtime에 구현체 주입)

    private final EmailSendable emailSendable;

    public void sendEmail(String[] to, String subject, String message) throws MailSendException, InterruptedException {
        emailSendable.send(to, subject, message);
    }
}

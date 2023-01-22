package com.email.rest.helper.email;

import org.springframework.stereotype.Component;

@Component
public interface EmailSendable {  //이메일 전송 추상화 인터페이스

    void send(String[] to, String subject, String message) throws InterruptedException;
}

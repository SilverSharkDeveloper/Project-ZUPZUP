package com.app.floc.service.user;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



public interface EmailService {
    public MimeMessage createMessage(String to,String type) throws MessagingException, UnsupportedEncodingException;
    public String createKey();
    public String sendSimpleMessage(String to,String type) throws Exception;
}

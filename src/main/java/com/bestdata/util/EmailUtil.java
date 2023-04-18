package com.bestdata.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件相关业务
 *
 * @author chenyuanheng
 * @version 1.0
 */
@Slf4j
@Component
@SpringBootTest
public class EmailUtil {

    // 我的163邮箱
    @Value("${spring.mail.host}")
    private String host ;
    @Value("${spring.mail.username}")
    private String my163Mail ;
    @Value("${spring.mail.password}")
    private String my163Password ;

    /**
     * 发送简单文本邮件
     *
     * @author chenyuanheng
     * @version 1.0
     */
    @Test
    public void sendSimpleTextMail() {
        JavaMailSender sender = new JavaMailSenderImpl();
        //设置邮件服务主机
        ((JavaMailSenderImpl)sender).setHost(host);
        //发送者邮箱的用户名
        ((JavaMailSenderImpl)sender).setUsername(my163Mail);
        //发送者邮箱的密码
        ((JavaMailSenderImpl)sender).setPassword(my163Password);
        MimeMessage mimeMessage = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            // 发件箱
            helper.setFrom(my163Mail);
            // 收件箱(此邮箱为王宏宇邮箱)
            helper.setTo("13812345678@163.com");
            helper.setSubject("我是主题呀");//邮件主题
            helper.setText("我是内容呀", false);//邮件内容
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
